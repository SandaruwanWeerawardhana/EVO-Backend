package edu.icet.repository.admin;

import edu.icet.entity.admin.AdminEntity;
import edu.icet.util.AdminType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
     Iterable<Object> findAllByType(AdminType type);
}
