package edu.icet.entity;

import edu.icet.util.WeddingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "wedding")
public class WeddingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String weddingId;

    @Column(name = "wedding_type", nullable = false)
    private WeddingType weddingType;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}
