package edu.icet.doc;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@RestController
@RequestMapping("/doc")
public class ApiDocumentController {
    private static final String API_URL = "http://localhost:8080/v3/api-docs";
    private static final String PDF_PATH = "api-documentation.pdf";

    @GetMapping("/create-doc")
    public String createDoc() {
        try {
            String jsonResponse = fetchApiJson(API_URL);
            if (jsonResponse.isEmpty()) {
                return "Failed to fetch API JSON.";
            }
            JSONObject jsonObject = new JSONObject(jsonResponse);
            generatePdf(jsonObject, PDF_PATH);
            return "PDF successfully generated at: " + new File(PDF_PATH).getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating PDF: " + e.getMessage();
        }
    }

    private String fetchApiJson(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        Scanner scanner = new Scanner(conn.getInputStream());
        StringBuilder jsonBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            jsonBuilder.append(scanner.nextLine());
        }
        scanner.close();
        return jsonBuilder.toString();
    }

    private void generatePdf(JSONObject jsonObject, String pdfPath) throws Exception {
        PdfWriter writer = new PdfWriter(new FileOutputStream(pdfPath));
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("API Documentation")
                .setBold()
                .setFontSize(20)
                .setFontColor(new DeviceRgb(0, 102, 204))
                .setTextAlignment(TextAlignment.CENTER));

        if (jsonObject.has("paths")) {
            document.add(new Paragraph("\nAPI Endpoints")
                    .setBold().setFontSize(14).setFontColor(ColorConstants.BLUE));
            JSONObject paths = jsonObject.getJSONObject("paths");

            for (String path : paths.keySet()) {
                document.add(new Paragraph("\nEndpoint: " + path)
                        .setBold().setFontSize(12).setFontColor(ColorConstants.DARK_GRAY));
                JSONObject methods = paths.getJSONObject(path);

                for (String method : methods.keySet()) {
                    JSONObject methodDetails = methods.getJSONObject(method);
                    document.add(new Paragraph("Method: " + method.toUpperCase())
                            .setBold()
                            .setFontColor(getMethodColor(method)));

                    if (methodDetails.has("parameters")) {
                        document.add(new Paragraph("Parameters:").setBold());
                        Table paramTable = new Table(UnitValue.createPercentArray(new float[]{3, 3, 2, 2})).useAllAvailableWidth();
                        paramTable.addHeaderCell(getHeaderCell("Name"));
                        paramTable.addHeaderCell(getHeaderCell("Type"));
                        paramTable.addHeaderCell(getHeaderCell("Required"));
                        paramTable.addHeaderCell(getHeaderCell("In"));

                        JSONArray parameters = methodDetails.getJSONArray("parameters");
                        for (int i = 0; i < parameters.length(); i++) {
                            JSONObject param = parameters.getJSONObject(i);
                            String paramName = param.getString("name");
                            String paramIn = param.getString("in");
                            String paramRequired = param.getBoolean("required") ? "Yes" : "No";
                            String paramType = "N/A";
                            if (param.has("schema")) {
                                JSONObject schema = param.getJSONObject("schema");
                                paramType = schema.optString("type", "N/A");
                            }
                            paramTable.addCell(paramName);
                            paramTable.addCell(paramType);
                            paramTable.addCell(paramRequired);
                            paramTable.addCell(paramIn);
                        }
                        document.add(paramTable);
                    }

                    if (methodDetails.has("requestBody")) {
                        document.add(new Paragraph("Request Body:").setBold());
                        Table requestBodyTable = new Table(UnitValue.createPercentArray(new float[]{3, 3})).useAllAvailableWidth();
                        requestBodyTable.addHeaderCell(getHeaderCell("Field"));
                        requestBodyTable.addHeaderCell(getHeaderCell("Type"));

                        JSONObject requestBody = methodDetails.getJSONObject("requestBody");
                        if (requestBody.has("content")) {
                            JSONObject content = requestBody.getJSONObject("content");
                            if (content.has("application/json")) {
                                JSONObject schema = content.getJSONObject("application/json").getJSONObject("schema");
                                if (schema.has("$ref")) {
                                    requestBodyTable.addCell("Reference");
                                    requestBodyTable.addCell(schema.getString("$ref"));
                                }
                            }
                        }
                        document.add(requestBodyTable);
                    }
                }
            }
        }
        document.close();
        System.out.println("PDF created successfully: " + pdfPath);
    }

    private DeviceRgb getMethodColor(String method) {
        switch (method.toUpperCase()) {
            case "GET": return new DeviceRgb(34, 177, 76);
            case "POST": return new DeviceRgb(0, 102, 204);
            case "PUT": return new DeviceRgb(255, 165, 0);
            case "DELETE": return new DeviceRgb(204, 0, 0);
            default: return (DeviceRgb) ColorConstants.BLACK;
        }
    }

    private Cell getHeaderCell(String text) {
        return new Cell().add(new Paragraph(text).setBold().setFontColor(ColorConstants.WHITE))
                .setBackgroundColor(ColorConstants.BLUE)
                .setTextAlignment(TextAlignment.CENTER);
    }
}