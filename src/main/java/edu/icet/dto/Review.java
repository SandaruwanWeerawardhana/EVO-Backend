package edu.icet.dto;

import edu.icet.util.Rating;
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

    private long reviewId;
    @NotNull(message = "Rating cannot be Null")
    private Rating rating;
    @PastOrPresent
    @NotNull(message = "Date cannot be Null")
    private LocalDate date;
    @NotNull(message = "comment can not be null")
    private String comment;

}
