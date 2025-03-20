package edu.icet.service.system.impl;

import edu.icet.dto.Category;
import edu.icet.entity.CategoryEntity;
import edu.icet.repository.CategoryRepository;
import edu.icet.service.system.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    final ModelMapper modelMapper;
    final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAll() {
       return categoryRepository.findAll();
    }

    @Override
    public Boolean save(Category category) {
        if (category == null) return false;
        CategoryEntity entity = modelMapper.map(category, CategoryEntity.class);
        categoryRepository.save(entity);
        return true;
    }

    @Override
    public Category search(String query) {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findAll()
                .stream()
                .filter(entity -> entity.getName().equalsIgnoreCase(query))
                .findFirst();

        return categoryEntity.map(entity -> modelMapper.map(entity, Category.class)).orElse(null);
    }

    @Override
    public Boolean delete(Long id) {
        if (id == null || !categoryRepository.existsById(id)) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean delete(Category category) {
        if (category == null || category.getId() == null) {
            return false;
        }
        return delete(category.getId());
    }

    @Override
    public Boolean update(Category category) {
        if (category == null || category.getId() == null) {
            return false;
        }
        if (!categoryRepository.existsById(category.getId())) {
            return false;
        }
        CategoryEntity entity = modelMapper.map(category, CategoryEntity.class);
        categoryRepository.save(entity);
        return true;
    }
}