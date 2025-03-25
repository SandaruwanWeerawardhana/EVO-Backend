package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.PackageFeatureDetail;
import edu.icet.entity.supplier.PackageFeatureDetailEntity;
import edu.icet.repository.supplier.PackageFeatureDetailRepository;
import edu.icet.repository.supplier.ProfileExtraFeatureRepository;
import edu.icet.service.supplier.PackageFeatureDetailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageFeatureDetailServiceImpl implements PackageFeatureDetailService {
    final ModelMapper mapper;
    final PackageFeatureDetailRepository packageFeatureDetailRepository;

    @Override
    public List<PackageFeatureDetail> getAll() {
        return packageFeatureDetailRepository.findAll()
                .stream()
                .map(packageFeatureDetailEntity -> mapper.map(packageFeatureDetailEntity, PackageFeatureDetail.class))
                .toList();
    }

    @Override
    public void add(PackageFeatureDetail packageFeatureDetail) {

        boolean exists= packageFeatureDetailRepository.existsByPackageIdAndFeatureId(
                packageFeatureDetail.getPackageId(),
                packageFeatureDetail.getFeatureId()
        );
        if (exists){
            throw  new IllegalArgumentException("This Combination packageId and FeatureId already exists");

        }

        PackageFeatureDetailEntity entity = mapper.map(packageFeatureDetail, PackageFeatureDetailEntity.class);
        packageFeatureDetailRepository.save(entity);

    }

    @Override
    public PackageFeatureDetail search(PackageFeatureDetail query) {
        return packageFeatureDetailRepository.findById(query.getPackageFeatureDetailId())
                .map(entity -> mapper.map(entity, PackageFeatureDetail.class))
                .orElse(null);
    }

    @Override
    public void update(PackageFeatureDetail packageFeatureDetail) {
        if (packageFeatureDetailRepository.existsById(packageFeatureDetail.getPackageFeatureDetailId())) {
            PackageFeatureDetailEntity entity = mapper.map(packageFeatureDetail, PackageFeatureDetailEntity.class);
            packageFeatureDetailRepository.save(entity);
        }
    }

    @Override
    public void delete(Long id) {
        if (packageFeatureDetailRepository.existsById(id)) {
            packageFeatureDetailRepository.deleteById(id);
        }
    }

}