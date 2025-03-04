package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @NotBlank
    private String size;
    @NotNull
    @NotBlank
    private Double depth;
}
