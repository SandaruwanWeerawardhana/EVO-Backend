package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply {
    @NotBlank
    @Size(min = 1, max = 10)
    private Long replyId;

    @NotBlank
    @Size(min = 1, max = 10)
    private Long reviewId;

    @NotBlank
    @Size(min = 1, max = 10)
    private Long userId;

    @NotBlank
    private String content;

}
