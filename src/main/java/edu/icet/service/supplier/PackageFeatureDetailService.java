package edu.icet.service.supplier;

import edu.icet.dto.supplier.PackageFeatureDetail;

import java.util.List;

public interface PackageFeatureDetailService {
    List<PackageFeatureDetail> getAll();
    void add(PackageFeatureDetail packageFeatureDetail);
    PackageFeatureDetail search(PackageFeatureDetail query);
    void update(PackageFeatureDetail packageFeatureDetail);
    void delete(Long id);
}
