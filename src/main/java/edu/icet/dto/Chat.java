package edu.icet.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @NotEmpty
    private Integer id;
    @NotEmpty
    @Positive
    private Integer customerId;
    @NotEmpty
    @Positive
    private Integer supplierId;
}



