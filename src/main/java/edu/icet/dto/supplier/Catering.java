package edu.icet.dto.supplier;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catering {
    @NotNull(message = "Catering ID cannot be null")
    @Min(value = 1, message = "Catering ID must be a positive number")
    private Integer cateringId;

    @NotNull(message = "Supplier ID cannot be null")
    @Min(value = 1, message = "Supplier ID must be a positive number")
    private Integer supplierId;

    @NotBlank(message = "Service availability is required")
    private String availabilityStatus;
}