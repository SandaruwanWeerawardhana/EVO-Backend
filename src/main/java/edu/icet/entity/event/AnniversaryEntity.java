package edu.icet.entity.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "anniversary")
public class AnniversaryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long eventId;

    @Column(name = "anniversary_year", nullable = false)
    private Integer anniversaryYear;

    @Column(name = "wife_name", nullable = false)
    private String wifeName;

    @Column(name = "husband_name", nullable = false)
    private String husbandName;

    @Column(name = "description")
    private String description;}
