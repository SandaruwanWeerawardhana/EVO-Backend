package edu.icet.repository;

import edu.icet.entity.QuickRepliesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuickReplyRepository extends JpaRepository<QuickRepliesEntity,Long> {

}
