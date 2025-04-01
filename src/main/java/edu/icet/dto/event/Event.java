package edu.icet.dto.event;

import edu.icet.util.BudgetType;
import edu.icet.util.EventStatusType;
import edu.icet.util.EventType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Long eventId;
    @NotNull
    private Long userId;
    @NotNull
    private Date eventDate;
    @NotNull
    private Time startTime;
    @NotNull
    private Time endTime;
    private Integer locationId;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @NotNull
    private Integer capacity;
    @NotNull
    @Enumerated(EnumType.STRING)
    private BudgetType budgetType;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private EventStatusType eventStatus;
    @NotNull
    private List<EventSupplier> suppliers;

    private Anniversary anniversary;
    private Wedding wedding;
    private GetTogether getTogether;
    private BirthdayParty birthdayParty;
}
