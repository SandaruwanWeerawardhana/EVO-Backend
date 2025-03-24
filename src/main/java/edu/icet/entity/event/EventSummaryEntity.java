package edu.icet.entity.event;
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

    @Column(nullable = false)
    private Integer eventId;

    @Column(nullable = false)
    private Long venueId;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    @OneToMany
    private List<SupplierEntity> supplierList;

    @Column(nullable = false)
    private Double totalPrice;
}
