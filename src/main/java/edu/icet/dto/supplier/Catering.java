package edu.icet.dto.supplier;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catering {
    @NotNull(message = "Catering ID cannot be null")
    private Long cateringId;

    private Boolean isAvailable;

    private List<Meal> meals;
}