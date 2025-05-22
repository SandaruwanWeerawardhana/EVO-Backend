package edu.icet.repository.event.impl;

import edu.icet.entity.event.GetTogetherEntity;
import edu.icet.entity.event.WeddingEntity;
import edu.icet.repository.event.GetTogetherRepository;
import edu.icet.util.DBConnection;
import edu.icet.util.WeddingType;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Primary
@Repository
@RequiredArgsConstructor
public class GetTogetherRepositoryImpl implements GetTogetherRepository {
    private final DBConnection dbConnection;
    private final Logger logger;

    @Override
    public GetTogetherEntity add (GetTogetherEntity entity) {
        try {
            return (Integer) this.dbConnection.execute(
                    "INSERT INTO get_together (event_id, event_summary_id, description, title) VALUES (?, ?, ?)",
                    entity.getEventId(),
                    entity.getEventSummaryId(),
                    entity.getDescription(),
                    entity.getTitle()
            ) == 0 ? null : entity;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public GetTogetherEntity update (GetTogetherEntity entity) {
        try {
            return (Integer) this.dbConnection.execute(
                    "UPDATE get_together SET event_id = ?, event_summary_id = ?, description = ?, title = ? WHERE event_id = ? OR event_summary_id = ?",
                    entity.getEventId(),
                    entity.getEventSummaryId(),
                    entity.getDescription(),
                    entity.getTitle(),
                    entity.getEventId(),
                    entity.getEventSummaryId()
            ) == 0 ? null : entity;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public GetTogetherEntity getByEventId (Long eventId) {
        try (final ResultSet resultSet = this.dbConnection.execute("SELECT event_summary_id, description, title FROM get_together WHERE event_id = ?", eventId)) {
            return resultSet.next() ?
                    GetTogetherEntity.builder()
                            .eventId(eventId)
                            .eventSummaryId(resultSet.getLong(1))
                            .description(resultSet.getString(2))
                            .title(resultSet.getString(3))
                            .build() :
                    null;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public GetTogetherEntity getByEventSummaryId (Long eventSummaryId) {
        try (final ResultSet resultSet = this.dbConnection.execute("SELECT event_id, description, title FROM get_together WHERE event_summary_id = ?", eventSummaryId)) {
            return resultSet.next() ?
                GetTogetherEntity.builder()
                    .eventSummaryId(eventSummaryId)
                    .eventId(resultSet.getLong(1))
                    .description(resultSet.getString(2))
                    .title(resultSet.getString(3))
                    .build() :
                null;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }
}