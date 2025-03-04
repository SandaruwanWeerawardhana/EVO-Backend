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


public class OutdoorArea {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private double size;
    private Boolean seatingCapacity;
    private Boolean lighting;
    private Boolean weatherProtection;


}
