package edu.icet.entity.event;

import edu.icet.entity.supplier.LocationEntity;
import edu.icet.entity.supplier.SupplierEntity;
import edu.icet.entity.supplier.VenueEntity;
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
import java.util.List;

@Entity
@Table(name = "event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "event_date", nullable = false)
    private Date eventDate;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    @Column(name = "end_time", nullable = false)
    private Time endTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "venue_id", nullable = true)
    private VenueEntity venue;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

    @Column(name = "event_type", nullable = false)
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private List<SupplierEntity> suppliers;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "agenda_id")
    private AgendaEntity agenda;

    @OneToOne
    @JoinColumn(name = "anniversary_id")
    private AnniversaryEntity anniversary;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "wedding_id")
    private WeddingEntity wedding;

    @OneToOne
    @JoinColumn(name = "get_together_id")
    private GetTogetherEntity getTogether;

    @OneToOne
    @JoinColumn(name = "birthday_party_id")
    private BirthdayPartyEntity birthdayParty;
}
