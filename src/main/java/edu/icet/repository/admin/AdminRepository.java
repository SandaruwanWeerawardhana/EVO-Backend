package edu.icet.repository.admin;

import edu.icet.entity.admin.AdminEntity;
import edu.icet.entity.customer.CustomerEntity;
import edu.icet.util.AdminType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
     Optional<CustomerEntity> findByEmail(String email);
     boolean existsByEmail(String email);
     Iterable<Object> findAllByType(AdminType type);

}
