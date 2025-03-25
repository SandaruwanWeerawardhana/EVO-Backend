package edu.icet.dto.supplier;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageFeatureDetail {
    private Long packageFeatureDetailId;
    @NotNull(message = "Package ID cannot be null")
    @Positive(message = "Package ID must be a positive number")
    private Long packageId;
    @NotNull(message = "Feature ID cannot be null")
    @Positive(message = "Feature ID must be a positive number")
    private Long featureId;
}
