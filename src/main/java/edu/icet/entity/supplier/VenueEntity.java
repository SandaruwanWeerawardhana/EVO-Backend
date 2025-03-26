package edu.icet.entity.supplier;

import edu.icet.util.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venue")

public class VenueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    @OneToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;

    @Column(nullable = false)
    private String location;
    @Column(nullable = false)

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(nullable = false)
    private Long capacity;
}
