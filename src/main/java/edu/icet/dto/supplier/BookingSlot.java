package edu.icet.dto.supplier;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingSlot {
    private Long bookingSlotId;

    @NotNull
    @NotBlank(message = "PropertyId may not be empty")
    private Long propertyId;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private LocalDateTime startTime;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private LocalDateTime endTime;

}
