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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "wedding_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private WeddingType weddingType;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}
