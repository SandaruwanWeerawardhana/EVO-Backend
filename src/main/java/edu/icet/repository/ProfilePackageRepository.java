package edu.icet.repository;

import edu.icet.dto.ProfilePackages;
import edu.icet.entity.ProfilePackagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePackageRepository extends JpaRepository<ProfilePackagesEntity,Long> {

}
