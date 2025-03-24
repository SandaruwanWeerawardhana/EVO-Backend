package edu.icet.dto;

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
    private Integer eventId;
    @NotNull
    private Long userId;
    @NotNull
    private Date eventDate;
    @NotNull
    private Time startTime;
    @NotNull
    private Time endTime;
    private Location location;
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
}
