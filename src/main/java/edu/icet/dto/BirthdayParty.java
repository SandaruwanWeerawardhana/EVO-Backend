package edu.icet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BirthdayParty {
    @NotNull(message = "birthdayPartyID cannot be null")
    private Long birthdayPartyId;
    @NotNull(message = "OwnerName cannot be null")
    private String ownerName;
    @Email
    private String email;
    @NotNull(message = "birthday cannot be null")
    private Date birthday;
}