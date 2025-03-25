package edu.icet.repository.customer;

import edu.icet.entity.customer.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
