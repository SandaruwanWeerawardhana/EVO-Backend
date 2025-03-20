package edu.icet.repository;

import edu.icet.entity.GetTogetherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GetTogetherRepository extends JpaRepository<GetTogetherEntity,Integer> {
    List<GetTogetherEntity> findAllByTitle(String title);
    List<GetTogetherEntity> findAllByDescription(String description);

}
