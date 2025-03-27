package edu.icet.repository.supplier;

import edu.icet.entity.supplier.ProfileExtraFeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileExtraFeatureRepository extends JpaRepository<ProfileExtraFeatureEntity,Long> {
    void deleteByFeaturePriceAndFeatureName(double featurePrice,String featureName);
}
