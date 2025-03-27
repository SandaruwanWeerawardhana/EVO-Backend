package edu.icet.entity.event;
import edu.icet.entity.admin.SupplierRequestEntity;
import edu.icet.entity.supplier.ProfilePackagesEntity;
import edu.icet.entity.supplier.SupplierEntity;
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
    private Integer id;

//    @Column(nullable = false)
//    private EventSummaryEntity eventSummaryEntityId;
//
//    private EventEntity eventEntityId;

    private Long venueId;

    @Column(nullable = false)
    private Long customerId;

//    @Column(nullable = false)
//    @OneToMany
//    private List<ProfilePackagesEntity> packagesList;
//    private List<SupplierRequestEntity> RequestList;

    private Double totalPrice;
}
