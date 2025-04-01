package edu.icet.dto.supplier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PackageFeature {
    private Long featureID;

    private Supplier supplier;

    @NotBlank
    @NotNull(message="featureName cannot be null")
    private String featureName;

    @NotNull(message ="featurePrice cannot be null" )
    private Double featurePrice;
}
