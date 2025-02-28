package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Message {
    private Long mid;

    @NotBlank(message = "Content may not be empty")
    private String content;

    @NotNull
    @DateTimeFormat(pattern = "HH,mm,ss")
    private LocalDateTime sendTime;
}
