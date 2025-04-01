package edu.icet.dto.supplier;

import edu.icet.util.SupplierCategoryType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Inventory {
    private Long inventoryID;

    @NotBlank(message = "cannot be empty")
    private String imageURL;

    @NotBlank(message = "cannot be empty")
    private String description;

    @Enumerated(EnumType.STRING)
    private SupplierCategoryType supplierCategory;
}
