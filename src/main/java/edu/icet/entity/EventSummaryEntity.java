package edu.icet.entity;
import edu.icet.dto.Supplier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    private List<Supplier> supplierList;

    @Column(nullable = false)
    private Double totalPrice;
}
