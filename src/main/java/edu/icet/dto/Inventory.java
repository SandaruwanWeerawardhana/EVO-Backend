package edu.icet.dto;

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
    private Long supplierID;

    @NotBlank(message = "cannot be empty")
    private String imageURL;

    @NotBlank(message = "cannot be empty")
    private String description;

    @NotBlank(message = "cannot be empty")
    private String supplierCategory;
}
