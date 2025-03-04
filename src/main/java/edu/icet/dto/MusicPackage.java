package edu.icet.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicPackage {
    @NotEmpty
    private Integer id;
    @NotEmpty
    private String description;
    @NotEmpty
    @Positive
    private Double price_per_hour;
}
