package edu.icet.service.supplier;

import edu.icet.dto.supplier.PackageFeature;

import java.util.List;

public interface ProfileExtraFeatureService {
    List<PackageFeature> getAll();
    Boolean save(PackageFeature packageFeature);
    Boolean delete(Long id);
    Boolean update(Long id, PackageFeature packageFeature);
    PackageFeature searchById(Long id);
}
