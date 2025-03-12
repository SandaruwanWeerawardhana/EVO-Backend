package edu.icet.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "birthdayparty")
public class BirthdayPartyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "birthdaypartyid", nullable = false)
    private Integer birthdayPartyId;

    @Column(name = "ownername", nullable = false)
    private String ownerName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthdaydate", nullable = false)
    private Date birthday;
}
