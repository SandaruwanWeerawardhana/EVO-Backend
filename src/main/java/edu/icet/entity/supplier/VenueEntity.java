package edu.icet.entity.supplier;

import edu.icet.entity.event.EventEntity;
import edu.icet.util.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity location;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(nullable = false)
    private Long capacity;

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    private List<EventEntity> events;
}
