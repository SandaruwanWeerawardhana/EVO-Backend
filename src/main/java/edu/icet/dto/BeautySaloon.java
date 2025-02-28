package edu.icet.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class BeautySaloon {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String telNumber;

    @NotBlank
    private String email;

    public void setTelNumber(String telNumber) {
        if (telNumber != null && telNumber.length() == 10 && telNumber.chars().allMatch(Character::isDigit)) {
            this.telNumber = telNumber;
        } else {
            throw new IllegalArgumentException("Telephone number must be 10 digits");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.endsWith(".com") && email.contains("@") && email.indexOf("@") > 0 && email.indexOf("@") < email.indexOf(".")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email number must be a valid .com email address");
        }
    }
}
