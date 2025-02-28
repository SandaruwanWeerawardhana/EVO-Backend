package edu.icet.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Agenda {
    @NotNull(message = "Id can't be null")
    private Integer id;
    @NotNull(message = "Date can't be null")
    private LocalDate date;
    @NotNull(message = "Time can't be null")
    private LocalTime time;
    @NotNull(message = "Agenda Detail can't be null")
    private String agendaDetail;
}