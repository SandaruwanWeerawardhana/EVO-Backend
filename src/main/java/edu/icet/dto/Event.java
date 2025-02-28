package edu.icet.dto;

import edu.icet.utill.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Event {
    private Long eventId;

    @NotNull(message = "event_name cannot be null")
    private String eventName;

    @NotNull(message = "event_type cannot be null")
    private EventType eventType;

    @NotBlank(message = "Location cannot be empty")
    private String location;

    @PastOrPresent(message = "Event date must be in the Past")
    @NotNull(message = "Date cannot be null")
    private LocalDate date;

}