package edu.icet.service.system;

import edu.icet.dto.Category;
import edu.icet.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Boolean save(Category category);
    Category search(String query);
    Boolean delete(Long id);
    Boolean delete(Category category);
    Boolean update(Category category);
}
