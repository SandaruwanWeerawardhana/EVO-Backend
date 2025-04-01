package edu.icet.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.icet.util.SupplierType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaTask {
    private Long taskId;

    @NotBlank(message = "Task name is required")
    private String taskName;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    private Long supplierId;

    @Enumerated(EnumType.STRING)
    private SupplierType supplierType;

    private Agenda agenda;
}