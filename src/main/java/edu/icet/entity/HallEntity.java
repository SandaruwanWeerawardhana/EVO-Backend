package edu.icet.entity;

import edu.icet.util.HallAvailability;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    private Long hallId;

    @NotNull
    private Long propertyId;

    @NotNull
    @Min(1)
    private Integer count;

    @NotNull
    private HallAvailability availability;
}
