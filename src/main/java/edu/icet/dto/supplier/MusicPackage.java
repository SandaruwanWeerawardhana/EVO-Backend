package edu.icet.dto.supplier;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicPackage {
    private Integer id;

    @NotEmpty
    private String description;

    @NotEmpty
    @Positive
    private Double price_per_hour;
}
