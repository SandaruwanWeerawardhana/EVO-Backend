package edu.icet.service;

import edu.icet.dto.SearchHistory;

import java.util.List;

public interface SearchHistoryService {
    boolean saveSearchHistory(SearchHistory searchHistory);
    boolean deleteSearchHistory(SearchHistory report);
    boolean deleteSearchHistoryById(long searchId);
    SearchHistory searchSearchHistory(long searchId);
    SearchHistory getSearchHistoryById(long searchId);
    List<SearchHistory> getAllSearchHistory();
    List<SearchHistory> getFillterSearchHistory();
    List<SearchHistory>getTopSearchHistory();
}
