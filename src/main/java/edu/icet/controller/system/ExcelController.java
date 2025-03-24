package edu.icet.controller.system;
import edu.icet.service.system.impl.ExcelReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/text")

public class ExcelController {
    @Autowired
    private ExcelReaderService excelReaderService;


    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadExcel() {
        try {
            List<String> words = excelReaderService.readWordsFromExcel();
            return ResponseEntity.ok(words);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}

