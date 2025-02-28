package edu.icet.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnniversariesDto {
    private Integer eventId;
    @NotNull(message = "anniversaryYear cannot be null")
    private String anniversaryYear;
    @NotNull(message = "wifeName cannot be null")
    private String wifeName;
    @NotNull(message = "husbandName cannot be null")
    private String husbandName;
    private String description;
}
