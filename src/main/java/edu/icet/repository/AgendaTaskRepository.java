package edu.icet.repository;

import edu.icet.entity.AgendaTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaTaskRepository extends JpaRepository<AgendaTaskEntity, Integer> {
}