package edu.icet.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetTogetherDto {
    @NotNull(message = "eventID cannot be null")
    private Integer eventID;
    private String description;
    private String title;
}
