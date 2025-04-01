package edu.icet.dto.supplier;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.icet.entity.supplier.PropertyEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Property property;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private LocalDateTime startTime;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private LocalDateTime endTime;

}
