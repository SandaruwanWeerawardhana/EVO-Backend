package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wedding {
    @NotBlank(message = "Id can't be null")
    private String weddingID;
    @NotBlank(message = "Traditional can't be null")
    private String traditional;
    @NotBlank(message = "PhotographerName can't be null")
    private String photographerName;
    @NotBlank(message = "Date can't be null")
    private LocalDate date;
}
