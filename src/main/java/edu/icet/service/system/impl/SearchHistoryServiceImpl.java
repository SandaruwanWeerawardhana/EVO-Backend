package edu.icet.service.system.impl;

import edu.icet.dto.SearchHistory;
import edu.icet.service.system.SearchHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {
    @Override
    public boolean saveSearchHistory(SearchHistory searchHistory) {
        return false;
    }

    @Override
    public boolean deleteSearchHistoryById(Long id) {
        return false;
    }

    @Override
    public SearchHistory searchSearchHistory(Long id) {
        return null;
    }

    @Override
    public List<SearchHistory> getAllSearchHistory() {
        return List.of();
    }

    @Override
    public List<SearchHistory> getFilterSearchHistory(String title) {
        return List.of();
    }

    @Override
    public boolean deleteAllSearchHistoryByCustomerId(Long id) {
        return false;
    }
}
