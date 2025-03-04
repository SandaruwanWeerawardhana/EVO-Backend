package edu.icet.dto;

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

    @NotBlank(message = "Catering service name is required")
    @Size(min = 3, max = 100, message = "Catering service name must be between 3 and 100 characters")
    private String serviceName;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;

    @NotNull(message = "Price per person is required")
    @DecimalMin(value = "1.0", message = "Price per person must be at least 1.0")
    private Double pricePerPerson;

    @NotNull(message = "Minimum order quantity is required")
    @Min(value = 10, message = "Minimum order quantity must be at least 10")
    private Integer minOrderQuantity;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Address is required")
    @Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters")
    private String address;

    @NotBlank(message = "Service availability is required")
    private String availabilityStatus;
}