package edu.icet.dto;

import edu.icet.util.BudgetType;
import edu.icet.util.EventType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Event {
    private Integer eventId;
    @NotNull
    private Date eventDate;
    @NotNull
    private Time startTime;
    @NotNull
    private Time endTime;
    private Location location;
    @NotNull
    private EventType eventType;
    @NotNull
    private Integer capacity;
    @NotNull
    private BudgetType budgetType;
}
