package edu.icet.dto.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilePackage {
    private Long packageId;

    private String description;

    private String packageName;

    private Double price;

    private List<PackageFeature> features;

}