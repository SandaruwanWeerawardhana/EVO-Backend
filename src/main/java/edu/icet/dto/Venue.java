package edu.icet.dto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {

    private Long id;

    @NotBlank(message = "Event type is required")
    private String eventType;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Time is required")
    private LocalTime time;

    @NotNull(message = "Status is required")
    private String status;
    @PrePersist
    protected void onCreate() {
        if(this.status == null) {
            this.status = "Pending";
        }
    }
}
