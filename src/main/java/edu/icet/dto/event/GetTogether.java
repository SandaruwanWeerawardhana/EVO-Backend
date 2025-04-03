package edu.icet.dto.event;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetTogether {
    private Long id;
    private String description;

    @NotNull(message = "title cannot be null")
    private String title;
}
