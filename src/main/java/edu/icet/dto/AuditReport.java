package edu.icet.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditReport {

    @NotNull
    @NotEmpty(message = "ID should not be blank")
    private Integer adminId;
    @NotNull
    @NotEmpty(message = "ID should not be blank")
    private Long reportId;

}
