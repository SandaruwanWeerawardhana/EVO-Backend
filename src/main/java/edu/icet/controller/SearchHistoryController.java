package edu.icet.controller;

import edu.icet.dto.SearchHistory;
import edu.icet.service.SearchHistoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/search_history")
@Slf4j
public class SearchHistoryController {
    final SearchHistoryService searchHistoryService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSearchHistory(@Valid @RequestBody SearchHistory searchHistory, HttpServletRequest request){
        if(searchHistoryService.saveSearchHistory(searchHistory)){
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | Add SearchHistory detail: {}",os,searchHistory);
            return ResponseEntity.ok("search history saved successfully");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added search history");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSearchHistoryById(@PathVariable Long id){
        if (searchHistoryService.deleteSearchHistoryById(id)){
            return ResponseEntity.ok("search history delete successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("try again!, Can't delete search history");
        }
    }

    @DeleteMapping("/delete_all_search_history_by_id/{id}")
    public ResponseEntity<String> deleteAllSearchHistoryByCustomerId(@PathVariable Long id){
        if (searchHistoryService.deleteAllSearchHistoryByCustomerId(id)){
            return ResponseEntity.ok("search histories delete successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("try again!, Can't delete search histories");
        }
    }

    @GetMapping("/get_search_history_by_id/{id}")
    public ResponseEntity<SearchHistory> searchSearchHistory(@PathVariable Long id){
        SearchHistory searchHistory = searchHistoryService.searchSearchHistory(id);
        if(searchHistory != null){
            return new ResponseEntity<>(searchHistory, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get_all_search_history")
    public ResponseEntity<List<SearchHistory>> getAllSearchHistory(){
        List<SearchHistory> allSearchHistory = searchHistoryService.getAllSearchHistory();
        if(allSearchHistory != null){
            return new ResponseEntity<>(allSearchHistory, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get_all_search_history_by_title/{title}")
    public ResponseEntity<List<SearchHistory>> getFilterSearchHistory(@PathVariable String title){
        List<SearchHistory> allSearchHistoryByTitle = searchHistoryService.getFilterSearchHistory(title);
        if(allSearchHistoryByTitle != null){
            return new ResponseEntity<>(allSearchHistoryByTitle, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
