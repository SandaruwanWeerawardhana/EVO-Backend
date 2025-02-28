package edu.icet.dto;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Message {
    @NotNull
    private Integer messageId;
    @NotNull
    private String messageType;
    @NotNull
    private String timeStamp;
}

