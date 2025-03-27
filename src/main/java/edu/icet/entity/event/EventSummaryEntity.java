package edu.icet.entity.event;
import edu.icet.entity.admin.SupplierRequestEntity;
import edu.icet.entity.supplier.ProfilePackagesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "EventSummary")
public class EventSummaryEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long eventSummaryId;

    @OneToOne
    @JoinColumn(name = "event_id",nullable = false)
    private EventEntity event;

//    @ManyToOne
//    @JoinColumn(name = "venue_id",nullable = false)
//    private Long venue;

//    @ManyToOne
//    @JoinColumn(name = "customer_id",nullable = false)
//    private Long customerId;

    private Integer headCount;
//
//    @ManyToMany
//    private List<ProfilePackagesEntity> packagesList;

//    @OneToMany
//    private List<SupplierRequestEntity> RequestList;

    private Double totalPrice;
}
