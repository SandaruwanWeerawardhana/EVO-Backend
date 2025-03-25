package edu.icet.dto.event;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetTogether {
    @NotNull(message = "eventID cannot be null")
    private Integer eventID;
    private String description;
    @NotNull(message = "title cannot be null")
    private String title;
}
