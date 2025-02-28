package edu.icet.dto;

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
    private String eventType;
    private LocalDate date;
    private LocalTime time;
    private String status;
}
