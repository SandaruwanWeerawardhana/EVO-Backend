package edu.icet.entity.supplier;


import edu.icet.util.MealType;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Meals")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "catering_id")
    private CateringEntity catering;

    @Column(nullable = false)
    private Double pricePerPerson;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

}
