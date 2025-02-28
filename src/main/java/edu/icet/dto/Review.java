package edu.icet.dto;

import edu.icet.util.Rating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @NotBlank(message = "Review id cannot be Blank")
    private long reviewId;
    @NotNull(message = "Rating cannot be Null")
    private Rating rating;
    @PastOrPresent
    private LocalDate date;
    private String comment;

}
