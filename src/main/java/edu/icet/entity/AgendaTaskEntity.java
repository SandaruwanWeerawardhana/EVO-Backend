//package edu.icet.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalTime;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "agenda_task")
//public class AgendaTaskEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer taskId;
//
//    @Column(nullable = false)
//    private String taskName;
//
//    @Column(name = "start_time")
//    private LocalTime startTime;
//
//    @Column(name = "end_time")
//    private LocalTime endTime;
//
//    @ManyToOne
//    @JoinColumn(name = "agenda_id", nullable = false)
//    private AgendaEntity agenda;
//}