package edu.icet.entity;

import edu.icet.util.HallAvailability;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "hall")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long hallId;

    @Column(nullable = false)
    private Long propertyId;

    @Column(nullable = false)
    @Min(1)
    private Integer count;

    @Column(nullable = false)
    private HallAvailability availability;
}
