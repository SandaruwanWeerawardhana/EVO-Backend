package edu.icet.dto.event;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anniversary {
    private Long eventId;
    private Event event;

    @NotNull(message = "anniversaryYear cannot be null")
    private Integer anniversaryYear;

    @NotNull(message = "wifeName cannot be null")
    private String wifeName;

    @NotNull(message = "husbandName cannot be null")
    private String husbandName;

    private String description;
}
