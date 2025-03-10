package edu.icet.service.system;

import edu.icet.dto.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);
    Category search(String query);
    Boolean delete(Long id);
    Boolean delete(Category category);
    Category update(Category category);
}
