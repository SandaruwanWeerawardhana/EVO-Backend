package edu.icet.repository;

import edu.icet.dto.ProfilePreviousWorkImage;
import edu.icet.entity.ProfilePreviousWorkImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePreviousWorkImageRepository extends JpaRepository<ProfilePreviousWorkImageEntity,Long> {
}
