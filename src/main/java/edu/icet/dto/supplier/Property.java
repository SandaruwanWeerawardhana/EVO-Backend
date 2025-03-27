package edu.icet.dto.supplier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Property {
    private Long propertyId;

    @NotNull
    private Supplier supplier;

    @NotNull
    @NotBlank(message = "Name may not be empty!")
    private String name;
}
