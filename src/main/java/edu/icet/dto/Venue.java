package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "venue")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_type", nullable = false)
    @NotBlank(message = "Event type is required")
    private String eventType;

    @Column(name = "event_date", nullable = false)
    @NotNull(message = "Date is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Column(name = "event_type", nullable = false)
    @NotNull(message = "Time is required")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;

    @Column(name = "event_status", nullable = false)
    @NotNull(message = "Status is required")
    private String status;

    @PrePersist
    protected void onCreate() {
        if(this.status == null) {
            this.status = "Pending";
        }
    }
}
