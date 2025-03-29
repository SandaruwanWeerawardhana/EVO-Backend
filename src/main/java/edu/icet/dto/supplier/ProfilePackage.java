package edu.icet.dto.supplier;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfilePackage {
    @NotNull
    @Min(1)
    private Long packageId;

    @NotNull
    private String description;

    @NotNull
    @Size(min = 1,max = 150)
    private String packageName;

    @NotNull
    @DecimalMax("10.0")@DecimalMin("0.0")
    private Double price;

    @NotNull
    private String status;

    private List<PackageFeature> features;

}
