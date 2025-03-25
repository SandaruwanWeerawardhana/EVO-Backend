package edu.icet.controller.supplier;

import edu.icet.dto.supplier.Meal;
import edu.icet.service.supplier.MealService;
import edu.icet.util.MealType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier/meal-controller")
@RequiredArgsConstructor
@CrossOrigin
public class MealController {

    final MealService mealService;

    @GetMapping("/get-all")
    public List<Meal> getAll(){
        return mealService.getAll();
    }

    @GetMapping("/search/{name}")
    public List<Meal> search(@PathVariable("name") String name){
        return mealService.search(name);
    }

    @GetMapping("/search/{id}")
    public Meal search(@PathVariable("id") Long id){
        return mealService.search(id);
    }

    @GetMapping("/search/{type}")
    public List<Meal> search(@PathVariable("type") MealType type){
        return mealService.search(type);
    }

    @PostMapping("/save")
    public Meal save(@RequestBody Meal meal){
        return mealService.save(meal);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestBody Meal meal){
        return mealService.delete(meal);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id){
        return mealService.delete(id);
    }

    @PutMapping("/update")
    public Meal update(@RequestBody Meal meal){
        return mealService.update(meal);
    }
}
