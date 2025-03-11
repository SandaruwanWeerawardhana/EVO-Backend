package edu.icet.controller;

import edu.icet.dto.Category;
import edu.icet.service.system.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/supplier/category")
@CrossOrigin
public class CategoryController {
    final CategoryService service;

    @PostMapping("/add")
    public Boolean addCategory(@RequestBody Category category){
        return service.save(category);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteCategoryById(@PathVariable Long id){
        return service.delete(id);
    }

    @DeleteMapping("/delete")
    public Boolean deleteCategory(@RequestBody Category category){
        return service.delete(category);
    }

    @PutMapping("/update")
    public Boolean updateCategory(@RequestBody Category category){
        return service.update(category);
    }

    @GetMapping("/search/{query}")
    public Category searchCategory(@PathVariable String query){
        return service.search(query);
    }

    @GetMapping("/get-all")
    public List<Category> getAllCategory(){
        return service.getAll();
    }
}
