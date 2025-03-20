package edu.icet.repository;

import edu.icet.entity.BeautySaloonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeautySaloonRepository extends JpaRepository<BeautySaloonEntity,Long> {
}
