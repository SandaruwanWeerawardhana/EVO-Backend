package edu.icet.service.supplier;

import edu.icet.dto.supplier.PackageFeature;

import java.util.List;

public interface PackageFeatureService {
    List<PackageFeature> getAll();
    PackageFeature save(PackageFeature packageFeature);
    Boolean delete(Long id);
    PackageFeature update(PackageFeature packageFeature);
    PackageFeature searchById(Long id);
}
