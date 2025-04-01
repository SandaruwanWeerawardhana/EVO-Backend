package edu.icet.entity.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "birthday_party")
public class BirthdayPartyEntity {
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;
}
