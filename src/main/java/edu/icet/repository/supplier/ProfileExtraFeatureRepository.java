package edu.icet.repository.supplier;

import edu.icet.entity.supplier.ProfileExtraFeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileExtraFeatureRepository extends JpaRepository<ProfileExtraFeatureEntity,Long> {
    boolean updateExtraFeaturesName(String featureName);
    boolean updateExtraFeaturesPrice(double featurePrice);
    void deleteExtraFeaturesPriceAndName(double featurePrice,String featureName);
}
