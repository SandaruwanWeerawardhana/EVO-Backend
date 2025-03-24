package edu.icet.dto.event;

import edu.icet.util.WeddingType;
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
    private Long weddingID;
    private WeddingType weddingType;
    @NotBlank(message = "Date can't be null")
    private LocalDate date;
}
