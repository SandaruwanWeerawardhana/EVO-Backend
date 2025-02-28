package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Music {
    private Long supplierId;

    @NotBlank(message = "Team Size may not be empty")
    private Integer teamSize;
}
