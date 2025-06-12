package edu.icet.dto.supplier;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AllSupplierDetails {
    private Supplier supplier;
    private List<ProfilePackage> packages;
    private List<PackageFeature> extraFeatures;
}
