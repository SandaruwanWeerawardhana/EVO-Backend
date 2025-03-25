package edu.icet.dto.supplier;


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

    @NonNull
    private String mealType;

}
