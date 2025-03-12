package edu.icet.entity;

import edu.icet.dto.Location;
import edu.icet.util.BudgetType;
import edu.icet.util.EventStatusType;
import edu.icet.util.EventType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer eventId;

    @NotNull
    private Long userId;

    @NotNull 
    @Future
    private Date eventDate;

    @NotNull
    private Time startTime;

    @NotNull
    private Time endTime;

    private Location location;

    @NotNull
    private EventType eventType;

    @NotNull 
    @Min(1)
    private Integer capacity;

    @NotNull
    private BudgetType budgetType;

    @NotNull
    private EventStatusType eventStatus;
}
