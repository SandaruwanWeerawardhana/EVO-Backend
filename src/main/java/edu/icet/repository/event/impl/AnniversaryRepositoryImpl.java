package edu.icet.repository.event.impl;

import edu.icet.entity.event.AnniversaryEntity;
import edu.icet.entity.event.BirthdayPartyEntity;
import edu.icet.repository.event.AnniversaryRepository;
import edu.icet.util.DBConnection;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Primary
@Repository
@RequiredArgsConstructor
public class AnniversaryRepositoryImpl implements AnniversaryRepository {
    private final DBConnection dbConnection;
    private final Logger logger;

    @Override
    public AnniversaryEntity add (AnniversaryEntity entity) {
        try {
            return (Integer) this.dbConnection.execute(
                    "INSERT INTO anniversary (event_id, event_summary_id, anniversary_year, wife_name, husband_name, description) VALUES (?, ?, ?, ?, ?, ?)",
                    entity.getEventId(),
                    entity.getEventSummaryId(),
                    entity.getAnniversaryYear(),
                    entity.getWifeName(),
                    entity.getHusbandName(),
                    entity.getDescription()
            ) == 0 ? null : entity;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public AnniversaryEntity update (AnniversaryEntity entity) {
        try {
            return (Integer) this.dbConnection.execute(
                    "UPDATE SET anniversary event_id = ?, event_summary_id = ?, anniversary_year = ?, wife_name = ?, husband_name = ?, description = ? WHERE event_id = ? OR event_summary_id = ?",
                    entity.getEventId(),
                    entity.getEventSummaryId(),
                    entity.getAnniversaryYear(),
                    entity.getWifeName(),
                    entity.getHusbandName(),
                    entity.getDescription(),
                    entity.getEventId(),
                    entity.getEventSummaryId()
            ) == 0 ? null : entity;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public AnniversaryEntity getByEventId (Long eventId) {
        try (final ResultSet resultSet = this.dbConnection.execute("SELECT event_summary_id, anniversary_year, wife_name, husband_name, description FROM get_together WHERE event_id = ?", eventId)) {
            return resultSet.next() ?
                    AnniversaryEntity.builder()
                            .eventId(eventId)
                            .eventSummaryId(resultSet.getLong(1))
                            .anniversaryYear(resultSet.getInt(2))
                            .wifeName(resultSet.getString(3))
                            .husbandName(resultSet.getString(4))
                            .description(resultSet.getString(5))
                            .build() :
                    null;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }
}