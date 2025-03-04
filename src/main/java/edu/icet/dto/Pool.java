package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Pool {
    private long id;

    @NotBlank
    private String size;

    @NotBlank
    private Double Depth;
}
