package edu.icet.service.system.impl;

import edu.icet.dto.Category;
import edu.icet.service.system.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getAll() {
        return List.of();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public Category search(String query) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Category category) {
        return null;
    }

    @Override
    public Category update(Category category) {
        return null;
    }
}
