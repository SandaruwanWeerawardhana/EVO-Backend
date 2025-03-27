package edu.icet.entity.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anniversary")
public class AnniversaryEntity {
    @Id
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "event_id")
    private EventEntity event;

    @Column(name = "anniversary_year", nullable = false)
    private Integer anniversaryYear;

    @Column(name = "wife_name", nullable = false)
    private String wifeName;

    @Column(name = "husband_name", nullable = false)
    private String husbandName;

    @Column(name = "description")
    private String description;
}
