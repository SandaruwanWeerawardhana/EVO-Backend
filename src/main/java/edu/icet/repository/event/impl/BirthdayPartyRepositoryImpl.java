package edu.icet.repository.event.impl;

import edu.icet.entity.event.BirthdayPartyEntity;
import edu.icet.entity.event.GetTogetherEntity;
import edu.icet.repository.event.BirthdayPartyRepository;
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
public class BirthdayPartyRepositoryImpl implements BirthdayPartyRepository {
    private final DBConnection dbConnection;
    private final Logger logger;

    @Override
    public BirthdayPartyEntity add (BirthdayPartyEntity entity) {
        try {
            return (Integer) this.dbConnection.execute(
                    "INSERT INTO birthday_party (event_id, event_summary_id, owner_name) VALUES (?, ?, ?)",
                    entity.getEventId(),
                    entity.getEventSummaryId(),
                    entity.getOwnerName()
            ) == 0 ? null : entity;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public BirthdayPartyEntity update (BirthdayPartyEntity entity) {
        try {
            return (Integer) this.dbConnection.execute(
                    "UPDATE birthday_party SET event_id = ?, event_summary_id = ?, owner_name = ? WHERE event_id = ? OR event_summary_id = ?",
                    entity.getEventId(),
                    entity.getEventSummaryId(),
                    entity.getOwnerName(),
                    entity.getEventId(),
                    entity.getEventSummaryId()
            ) == 0 ? null : entity;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public BirthdayPartyEntity getByEventId (Long eventId) {
        try (final ResultSet resultSet = this.dbConnection.execute("SELECT event_summary_id, owner_name FROM get_together WHERE event_id = ?", eventId)) {
            return resultSet.next() ?
                    BirthdayPartyEntity.builder()
                            .eventId(eventId)
                            .eventSummaryId(resultSet.getLong(1))
                            .ownerName(resultSet.getString(2))
                            .build() :
                    null;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }
}