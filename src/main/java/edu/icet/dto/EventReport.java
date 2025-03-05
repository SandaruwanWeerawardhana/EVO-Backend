package edu.icet.dto;

import edu.icet.util.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventReport {
    private Long eventId;

    @NotNull(message = "event_name cannot be null")
    private String eventName;

    @NotNull(message = "event_type cannot be null")
    private EventType eventType;

    @NotNull
    @NotBlank(message = "Location cannot be empty")
    private String location;

    @PastOrPresent(message = "Event date must be in the Past")
    @NotNull(message = "Date cannot be null")
    private LocalDate date;
}
