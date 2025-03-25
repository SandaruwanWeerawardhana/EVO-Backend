//package edu.icet.dto.event;
//
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Agenda {
//    @NotNull(message = "Agenda ID cannot be null")
//    private Integer id;
//
//    @NotNull(message = "Date cannot be null")
//    private LocalDate date;
//
//    @NotNull(message = "Time cannot be null")
//    private LocalTime time;
//
//    @NotNull(message = "Tasks cannot be null")
//    private List<AgendaTask> tasks;
//}