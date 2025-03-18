package edu.icet.entity;

import edu.icet.dto.EventSupplier;
import edu.icet.dto.Location;
import edu.icet.util.BudgetType;
import edu.icet.util.EventStatusType;
import edu.icet.util.EventType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Integer eventId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "event_date", nullable = false)
    private Date eventDate;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    @Column(name = "end_time", nullable = false)
    private Time endTime;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

    @Column(name = "event_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "capacity", nullable = false)
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
