package edu.icet.entity.event;

import edu.icet.entity.supplier.SupplierEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Entity
@Data
@Builder
public class EventSummarySuppliersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @OneToOne
    @JoinColumn(name = "event_summary_id")
    private EventSummaryEntity eventSummary;

    @OneToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;
}
