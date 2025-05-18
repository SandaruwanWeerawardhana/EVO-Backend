package edu.icet.dto.supplier;

import edu.icet.util.SupplierCategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supplier {
    private Long id;

    private String businessName;

    private String businessContactNumber;

    private String businessEmail;

    private String description;

    private Boolean availability;

    private SupplierCategoryType category;

    private String imageUrl;
}