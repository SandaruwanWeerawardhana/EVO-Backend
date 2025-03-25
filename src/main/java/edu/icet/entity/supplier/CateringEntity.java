package edu.icet.entity.supplier;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Catering")
public class CateringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer cateringId;
    @Column(nullable = false)
    private Integer supplierId;
    @Column(nullable = false)
    private String availabilityStatus;
}
