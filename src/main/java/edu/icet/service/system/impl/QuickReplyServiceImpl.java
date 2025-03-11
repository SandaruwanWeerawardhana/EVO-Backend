package edu.icet.service.system.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.QuickReplies;
import edu.icet.dto.Supplier;
import edu.icet.service.system.QuickReplyService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class QuickReplyServiceImpl implements QuickReplyService {
    List<QuickReplies> repliesList = new ArrayList<>();

    @Override
    public Boolean save(QuickReplies quickReplies) {
        if (Boolean.FALSE.equals(filterProfanity(quickReplies.getContent()))) {
            repliesList.add(quickReplies);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        return repliesList.removeIf(p->p.getReplyID().equals(id));
    }

    @Override
    public Boolean update(QuickReplies quickReplies) {
        if (quickReplies == null) return false;

        for (QuickReplies temp : repliesList) {
            if (temp.getReplyID().equals(quickReplies.getReplyID())) {
                int index = repliesList.indexOf(temp);
                repliesList.set(index, quickReplies);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<QuickReplies> getAll(Supplier supplier) {
        return Collections.singletonList(repliesList.get((int) supplier.getUserId()));
    }

    public Boolean filterProfanity(String content) {
        HttpClient httpClient = HttpClient.newHttpClient();;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.apiverve.com/v1/profanityfilter"))
                    .header("x-api-key", "9939ffef-8f41-4c02-b6a9-714d670a3237")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .method("POST", HttpRequest.BodyPublishers.ofString(
                            "{ \"text\": \"" + content + "\", \"mask\": \"*\" }"
                    ))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(response.body(), Map.class);

            Map<String, Object> data = (Map<String,Object>) responseMap.get("data");
            return (boolean) data.get("isProfane");
        }catch (IOException e) {
            throw new IllegalArgumentException("Error while calling profanity API", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalArgumentException("Thread was interrupted", e);
        } finally {
            httpClient.close();
        }

    }
}
