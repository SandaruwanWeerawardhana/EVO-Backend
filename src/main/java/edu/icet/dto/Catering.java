package edu.icet.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catering {

    @NotNull
    private Integer cateringId;

    @NotNull
    private Integer supplierId;
}
