package edu.icet.repository;

import edu.icet.entity.ProfilePackagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfilePackageRepository extends JpaRepository<ProfilePackagesEntity,Long> {
    List<ProfilePackagesEntity> getAllByPackageId(Long id);
    ProfilePackagesEntity findByPackageName(String name);
}
