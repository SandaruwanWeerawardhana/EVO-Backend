package edu.icet.repository.supplier;

import edu.icet.entity.supplier.PackageFeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileExtraFeatureRepository extends JpaRepository<PackageFeatureEntity,Long> {
    void deleteByFeaturePriceAndFeatureName(double featurePrice,String featureName);
}
