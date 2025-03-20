package edu.icet.repository;

import edu.icet.entity.AdminEntity;
import edu.icet.util.AdminType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
     Iterable<Object> findAllByType(AdminType type);
}
