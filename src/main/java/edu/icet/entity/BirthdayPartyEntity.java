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
@Table(name = "birthday_party")
public class BirthdayPartyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long birthdayPartyId;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthday_date", nullable = false)
    private Date birthday;
}
