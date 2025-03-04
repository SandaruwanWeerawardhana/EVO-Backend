package edu.icet.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @NotNull
    @NotBlank(message = "Content may not be empty")
    private String content;

    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalDateTime sendTime;
}
