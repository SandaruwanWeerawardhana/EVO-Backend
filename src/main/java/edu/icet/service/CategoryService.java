package edu.icet.service;

import edu.icet.dto.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);
    Boolean delete(Long id);
    Boolean delete(Category category);
    Category update(Category category);
}
