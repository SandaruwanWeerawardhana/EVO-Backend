package edu.icet.entity.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "birthday_party")
public class BirthdayPartyEntity {
    @Id
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "event_id")
    private EventEntity event;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthday_date", nullable = false)
    private Date birthday;
}
