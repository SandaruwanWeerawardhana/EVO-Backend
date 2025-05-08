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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;

    @Column(name = "wedding_type", nullable = true)
    @Enumerated(EnumType.STRING)
    private WeddingType weddingType = WeddingType.TRADITIONAL;

    @Column(name = "date", nullable = true)
    private LocalDate date= LocalDate.now();
}
