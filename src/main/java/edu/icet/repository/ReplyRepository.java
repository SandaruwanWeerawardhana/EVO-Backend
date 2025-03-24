package edu.icet.repository;

import edu.icet.dto.Reply;
import edu.icet.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
    List<ReplyEntity> findByUserId(Long userId);
}
