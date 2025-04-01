package edu.icet.repository.event;

import edu.icet.entity.event.AgendaTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaTaskRepository extends JpaRepository<AgendaTaskEntity, Integer> {
    @Query("SELECT t FROM AgendaTaskEntity t WHERE t.agenda.id = :agendaId AND t.taskId = :taskId")
    AgendaTaskEntity findByAgendaIdAndTaskId(@Param("agendaId") Integer agendaId,
                                             @Param("taskId") Integer taskId);
}