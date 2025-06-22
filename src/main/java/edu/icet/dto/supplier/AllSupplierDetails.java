package edu.icet.dto.supplier;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AllSupplierDetails {
    private Supplier supplier;
    private ImageGallery imageGallery;
    private List<ProfilePackage> packages;
    private List<PackageFeature> extraFeatures;
}
