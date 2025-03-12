package edu.icet.entity;

import edu.icet.dto.Location;
import edu.icet.util.BudgetType;
import edu.icet.util.EventStatusType;
import edu.icet.util.EventType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Date eventDate;

    @Column(nullable = false)
    private Time startTime;

    @Column(nullable = false)
    private Time endTime;

    private Location location;

    @Column(nullable = false)
    private EventType eventType;

    @Column(nullable = false)
    @Min(1)
    private Integer capacity;

    @Column(nullable = false)
    private BudgetType budgetType;

    @Column(nullable = false)
    private EventStatusType eventStatus;
}