package edu.icet.entity.event;

import edu.icet.entity.customer.CustomerEntity;
import edu.icet.entity.supplier.ProfilePackagesEntity;
import edu.icet.entity.supplier.SupplierRequestEntity;
import edu.icet.entity.supplier.VenueEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "EventSummary")
public class EventSummaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventSummaryId;

    @OneToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private VenueEntity venue;

    @Column(name = "event_date",nullable = false)
    @Future
    private Date eventDate;

    @Column(name = "start_time",nullable = false)
    private Time startTime;

    @Column(name = "end_time",nullable = false)
    private Time endTime;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerId;

    @Column(name = "head_count",nullable = false)
    private Integer headCount;

    @ManyToMany
    private List<ProfilePackagesEntity> packagesList;

    @OneToMany(mappedBy = "eventSummaryEntity", cascade = CascadeType.ALL)
    private List<SupplierRequestEntity> requests;

    @Column(name = "total_price")
    private Double totalPrice;
}
