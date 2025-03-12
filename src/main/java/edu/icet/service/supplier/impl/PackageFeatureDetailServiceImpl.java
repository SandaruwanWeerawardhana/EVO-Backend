package edu.icet.service.supplier.impl;

import edu.icet.dto.PackageFeatureDetail;
import edu.icet.service.supplier.PackageFeatureDetailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PackageFeatureDetailServiceImpl implements PackageFeatureDetailService {
    final ModelMapper mapper;
    private final List<PackageFeatureDetail> detailList = new ArrayList<>();
    @Override
    public List<PackageFeatureDetail> getAll() {
        return new ArrayList<>(detailList);
    }

    @Override
    public void add(PackageFeatureDetail packageFeatureDetail) {
        Optional<PackageFeatureDetail> existingDetail = detailList.stream()
                .filter(d -> d.getPackageId().equals(packageFeatureDetail.getPackageId()) &&
                        d.getFeatureId().equals(packageFeatureDetail.getFeatureId()))
                .findFirst();

        if (existingDetail.isPresent()) {
            throw new IllegalArgumentException("This package-feature combination already exists.");
        }

        if (packageFeatureDetail.getPackageFeatureDetailId() == null) {
            packageFeatureDetail.setPackageFeatureDetailId((long) (detailList.size() + 1));
        }

        detailList.add(packageFeatureDetail);
    }

    @Override
    public PackageFeatureDetail search(PackageFeatureDetail query) {
        if (query.getPackageFeatureDetailId() != null) {
            return detailList.stream()
                    .filter(d -> d.getPackageFeatureDetailId().equals(query.getPackageFeatureDetailId()))
                    .findFirst()
                    .orElse(null);
        }

        if (query.getPackageId() != null && query.getFeatureId() != null) {
            return detailList.stream()
                    .filter(d -> d.getPackageId().equals(query.getPackageId()) &&
                            d.getFeatureId().equals(query.getFeatureId()))
                    .findFirst()
                    .orElse(null);
        }

        return null;
    }

    @Override
    public void update(PackageFeatureDetail packageFeatureDetail) {
        if (packageFeatureDetail.getPackageFeatureDetailId() == null) {
            throw new IllegalArgumentException("ID must be provided for updating a package feature detail.");
        }

        Optional<PackageFeatureDetail> existingDetail = detailList.stream()
                .filter(d -> d.getPackageFeatureDetailId().equals(packageFeatureDetail.getPackageFeatureDetailId()))
                .findFirst();

        if (existingDetail.isEmpty()) {
            throw new IllegalArgumentException("No package feature detail found with the provided ID.");
        }

        PackageFeatureDetail existing = existingDetail.get();
        existing.setPackageId(packageFeatureDetail.getPackageId());
        existing.setFeatureId(packageFeatureDetail.getFeatureId());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must be provided for deletion.");
        }

        boolean removed = detailList.removeIf(d -> d.getPackageFeatureDetailId().equals(id));

        if (!removed) {
            throw new IllegalArgumentException("No package feature detail found with the provided ID.");
        }
    }
}
