package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Room {
    private Long roomId;

    @NotNull
    @NotBlank(message = "PropertyId may not be empty")
    private Long propertyId;

    @NotNull
    @NotBlank
    private Integer beds;
}
