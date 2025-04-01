package edu.icet.dto.event;

import edu.icet.dto.supplier.Location;
import edu.icet.dto.supplier.Supplier;
import edu.icet.dto.supplier.Venue;
import edu.icet.util.BudgetType;
import edu.icet.util.EventStatusType;
import edu.icet.util.EventType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Long id;

    @NotNull(message = "User id can't be empty")
    private Long userId;

    @NotNull
    @Future
    private Date eventDate;

    @NotNull
    private Time startTime;

    @NotNull
    private Time endTime;

    private Venue venue;

    @NotNull
    private Location location;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @NotNull
    private Integer capacity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BudgetType budgetType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EventStatusType eventStatus;

    private List<Supplier> suppliers;
    private Agenda agenda;
    private Anniversary anniversary;
    private Wedding wedding;
    private GetTogether getTogether;
    private BirthdayParty birthdayParty;
}
