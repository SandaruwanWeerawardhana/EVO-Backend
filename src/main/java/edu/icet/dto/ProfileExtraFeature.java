package edu.icet.dto;

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

public class ProfileExtraFeature {
    private Long featureID;
    private Long profileID;
    @NotBlank
    @NotNull(message="featureName cannot be null")
    private String featureName;

    @NotNull(message ="featurePrice cannot be null" )
    private Double featurePrice;
}
