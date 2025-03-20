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
    private Long id;
    @NotEmpty
    @Positive
    private Long customerId;
    @NotEmpty
    @Positive
    private Long supplierId;
}



