package edu.icet.repository.supplier;

import edu.icet.entity.supplier.ProfilePackagesEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfilePackageRepository extends JpaRepository<ProfilePackagesEntity,Long> {
    List<ProfilePackagesEntity> getAllByPackageId(Long id);
    ProfilePackagesEntity findByPackageName(String name);
    boolean existsByPackageName(String name);
}
