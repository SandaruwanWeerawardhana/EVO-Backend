package edu.icet.service.system.impl;

import edu.icet.dto.SearchHistory;
import edu.icet.service.system.SearchHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

    private final List<SearchHistory> searchHistoryList=new ArrayList<>();
    private final List<Long> customerIdList=new ArrayList<>();

    @Override
    public boolean saveSearchHistory(SearchHistory searchHistory) {
        if(searchHistory.getSearchId()==null||searchHistory.getTitle()==null||searchHistory.getDate()==null){
            throw new IllegalArgumentException("Search ID,Title,and Date cannot be null.");
        }
        if(searchHistory.getDate().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Search history date cannot be in the future.");
        }
        return searchHistoryList.add(searchHistory);
    }

    @Override
    public boolean deleteSearchHistoryById(Long id) {
        if (id==null){
            throw new IllegalArgumentException("ID cannot be null.");
        }
        return searchHistoryList.removeIf(history->history.getSearchId().equals(id));
    }

    @Override
    public SearchHistory searchSearchHistory(Long id) {
        if (id==null){
            throw new IllegalArgumentException("ID cannot be null");
        }
        return searchHistoryList.stream().filter(history->history.getSearchId().equals(id)).findFirst().orElse(null);

    }

    @Override
    public List<SearchHistory> getAllSearchHistory() {
        return new ArrayList<>(searchHistoryList);
    }

    @Override
    public List<SearchHistory> getFilterSearchHistory(String title) {
        if (title==null||title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or blank.");
        }
        return searchHistoryList.stream().filter(history->history.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());

    }

    @Override
    public boolean deleteAllSearchHistoryByCustomerId(Long customerId) {
        if (customerId==null){
            throw new IllegalArgumentException("Customer ID cannot be null.");
        }
        if(!customerIdList.contains(customerId)){
            throw new IllegalArgumentException("Customer Id doest not exist.");
        }

        boolean isDeleted=false;
        Iterator<SearchHistory> iterator=searchHistoryList.iterator();
        while (iterator.hasNext()){
            SearchHistory history=iterator.next();
            if (history.getSearchId().equals(customerId)){
                iterator.remove();
                isDeleted=true;
            }
        }
        return isDeleted;
    }
}
