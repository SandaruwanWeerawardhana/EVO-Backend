package edu.icet.service.supplier.impl;

import edu.icet.dto.PackageFeatureDetail;
import edu.icet.entity.PackageFeatureDetailEntity;
import edu.icet.repository.PackageFeatureDetailRepository;
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
    public List<PackageFeatureDetailEntity> getAll() {
        return packageFeatureDetailRepository.findAll();
    }

    @Override
    public void add(PackageFeatureDetail packageFeatureDetail) {
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