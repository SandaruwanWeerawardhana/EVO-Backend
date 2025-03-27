package edu.icet.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.icet.util.SupplierType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaTask {
    private Integer taskId;

    @NotBlank(message = "Task name is required")
    private String taskName;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    private Long supplierId;

    private SupplierType supplierType;


}