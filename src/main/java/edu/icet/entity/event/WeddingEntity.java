package edu.icet.entity.event;

import edu.icet.util.WeddingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wedding")
public class WeddingEntity {
    @Id
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "event_id")
    private EventEntity event;

    @Column(name = "wedding_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private WeddingType weddingType;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}
