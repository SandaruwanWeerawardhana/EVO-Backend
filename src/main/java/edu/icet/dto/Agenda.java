package edu.icet.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Agenda {
    @NotBlank
    private Integer id;
    @NotBlank
    private LocalDate date;
    @NotBlank
    private LocalTime time;
    @NotBlank
    private String agendaDetail;
}