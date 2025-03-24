package edu.icet.repository.supplier;

import edu.icet.entity.supplier.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity,Long> {

}
