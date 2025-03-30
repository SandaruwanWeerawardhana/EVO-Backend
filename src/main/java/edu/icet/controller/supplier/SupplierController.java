package edu.icet.controller.supplier;


import com.fasterxml.jackson.annotation.JsonView;
import edu.icet.dto.customer.User;
import edu.icet.dto.supplier.BeautySaloon;
import edu.icet.dto.supplier.Catering;
import edu.icet.dto.supplier.Meal;
import edu.icet.dto.supplier.Supplier;
import edu.icet.service.supplier.BeautySaloonService;
import edu.icet.service.supplier.SupplierService;
import edu.icet.util.JsonAPIViews;
import edu.icet.util.MealType;
import edu.icet.util.SupplierCategoryType;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/users")
    @Operation(summary = "Returns user objects of all the suppliers")
//    @JsonView(JsonAPIViews.SupplierView.class)
    public ResponseEntity<List<User>> getAllUserSuppliers() {

        List<User> suppliers = supplierService.getAllSupplierUsers();

        return suppliers.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(suppliers);
    }

    @GetMapping("/all")
    @Operation(summary = "Returns supplier objects of all the suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers(@RequestParam(required = false) SupplierCategoryType category) {
        List<Supplier> suppliers = category == null
                ? supplierService.getAllSuppliers()
                : supplierService.getSupplierByCategory(category);


        return suppliers.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(suppliers);
    }



}
