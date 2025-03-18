package edu.icet.dto;

import edu.icet.util.RatingType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @NotBlank(message = "Not be empty")
    private long reviewId;
    @NotBlank(message = "Not be empty")
    private long supplierId;
    @NotBlank(message = "Not be empty")
    private Long customerId;
    @NotNull(message = "Date cannot be Null")
    private LocalDate date;
    @NotNull(message = "comment can not be null")
    private String comment;
    @NotNull(message = "Rating cannot be Null")
    private RatingType rating;

}
