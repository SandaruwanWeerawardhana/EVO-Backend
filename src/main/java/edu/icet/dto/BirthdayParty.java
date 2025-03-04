package edu.icet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class BirthdayParty {
    @NotNull(message = "birthdayPartyID cannot be null")
    private Integer birthdayPartyId;
    @NotNull(message = "ownerName cannot be null")
    private String ownerName;
    @Email
    private String email;
    @NotNull(message = "birthday cannot be null")
    private Date birthday;
}