package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply {
    private Long id;

    @NotBlank(message = "Content cannot be blank")
    private String content;

    @NotNull(message = "ReviewId cannot be null")
    private Long reviewId;

    @NotNull(message = "UserID cannot be null")
    private Long userID;
}
