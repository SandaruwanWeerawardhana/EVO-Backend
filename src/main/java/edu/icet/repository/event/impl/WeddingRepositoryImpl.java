package edu.icet.repository.event.impl;

import edu.icet.entity.event.WeddingEntity;
import edu.icet.repository.event.WeddingRepository;
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
public class WeddingRepositoryImpl implements WeddingRepository {
    private final DBConnection dbConnection;
    private final Logger logger;

    @Override
    public WeddingEntity add (WeddingEntity entity) {
        try {
            return (Integer) this.dbConnection.execute(
                    "INSERT INTO wedding (event_id, event_summary_id, wedding_type) VALUES (?, ?, ?)",
                    entity.getEventId(),
                    entity.getEventSummaryId(),
                    entity.getWeddingType().name()
            ) == 0 ? null : entity;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public WeddingEntity update (WeddingEntity entity) {
        try {
            return (Integer) this.dbConnection.execute(
                    "UPDATE wedding SET event_id = ?, event_summary_id = ?, wedding_type = ? WHERE event_id = ? OR event_summary_id = ?",
                    entity.getEventId(),
                    entity.getEventSummaryId(),
                    entity.getWeddingType().name(),
                    entity.getEventId(),
                    entity.getEventSummaryId()
            ) == 0 ? null : entity;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public WeddingEntity getByEventId (Long eventId) {
        try (final ResultSet resultSet = this.dbConnection.execute("SELECT event_summary_id, wedding_type FROM wedding WHERE event_id = ?", eventId)) {
            return resultSet.next() ?
                    WeddingEntity.builder()
                            .eventId(eventId)
                            .eventSummaryId(resultSet.getLong(1))
                            .weddingType(WeddingType.fromName(resultSet.getString(2)))
                            .build() :
                    null;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public WeddingEntity getByEventSummaryId (Long eventSummaryId) {
        try (final ResultSet resultSet = this.dbConnection.execute("SELECT event_id, wedding_type FROM wedding WHERE event_summary_id = ?", eventSummaryId)) {
            return resultSet.next() ?
                WeddingEntity.builder()
                    .eventSummaryId(eventSummaryId)
                    .eventId(resultSet.getLong(1))
                    .weddingType(WeddingType.fromName(resultSet.getString(2)))
                    .build() :
                null;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean setEventId (Long eventSummaryId, Long eventId) {
        try {
            return (Integer) this.dbConnection.execute(
                "UPDATE wedding SET event_id = ? WHERE event_summary_id = ?",
                eventId,
                eventSummaryId
            ) == 0;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return false;
        }
    }
}