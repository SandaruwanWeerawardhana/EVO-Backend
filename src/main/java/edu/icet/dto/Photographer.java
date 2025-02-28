package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Photographer {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String contactNumber;

    @NotBlank
    private String email;

    public void setContactNumber(String contactNumber) {
        if(contactNumber!=null && contactNumber.length()==10 & contactNumber.chars().allMatch(Character::isDigit)){
            this.contactNumber=contactNumber;
        }else{
            throw new IllegalArgumentException("Contact number must be exactly 10 digits.");
        }

    }

    public void setEmail(String email) {
        if(email!=null && email.endsWith(".com") && email.contains("@") && email.indexOf("@")>0 && email.indexOf("@")<email.lastIndexOf(".")){
            this.email=email;
        }else{
            throw new IllegalArgumentException("Email Must be valid .com address .");
        }
    }
}
