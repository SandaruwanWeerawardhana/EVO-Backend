package edu.icet.entity.supplier;

import edu.icet.entity.event.EventEntity;
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
    private Long supplierId;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String eventType;
    @Column(nullable = false)
    private Long capacity;

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    private List<EventEntity> events;
}
