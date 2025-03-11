package edu.icet.service.system.impl;

import edu.icet.dto.Category;
import edu.icet.service.system.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    List<Category> categoryList = new ArrayList<>();

    @Override
    public List<Category> getAll() {
        return categoryList;
    }

    @Override
    public Boolean save(Category category) {
        return categoryList.add(category);
    }

    @Override
    public Category search(String query) {
        if (query == null || query.isEmpty()) {
            return null;
        }

        for (Category category : categoryList) {
            if (category.getName().equalsIgnoreCase(query)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return categoryList.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public Boolean delete(Category category) {
        return categoryList.remove(category);
    }

    @Override
    public Boolean update(Category category) {
        if (category == null) return false;

        for (Category temp : categoryList) {
            if (temp.getId().equals(category.getId())) {
                int index = categoryList.indexOf(temp);
                categoryList.set(index, category);
                return true;
            }
        }
        return false;
    }
}
