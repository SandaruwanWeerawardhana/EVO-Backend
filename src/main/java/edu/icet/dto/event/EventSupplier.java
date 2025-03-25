package edu.icet.dto.event;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventSupplier {
    @NotNull
    private Integer eventId;
    @NotNull
    private Long supplierId;
}
