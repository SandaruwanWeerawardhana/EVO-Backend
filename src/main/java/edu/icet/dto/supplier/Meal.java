package edu.icet.dto.supplier;


import edu.icet.util.MealType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meal {
    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Positive
    private Double pricePerPerson;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

}
