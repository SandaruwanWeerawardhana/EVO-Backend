package edu.icet.entity;

import edu.icet.util.BudgetType;
import edu.icet.util.EventStatusType;
import edu.icet.util.EventType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

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

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "event_date",nullable = false)
    @Future
    private Date eventDate;

    @Column(name = "start_time",nullable = false)
    private Time startTime;

    @Column(name = "end_time",nullable = false)
    private Time endTime;

    @Column(name ="location_Id")
    private Integer locationId;

    @Column(name = "event_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "capacity",nullable = false)
    @Min(1)
    private Integer capacity;

    @Column(name = "budget_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BudgetType budgetType;

    @Column(name = "event_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStatusType eventStatus;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventSupplierEntity> eventSuppliers;
}
