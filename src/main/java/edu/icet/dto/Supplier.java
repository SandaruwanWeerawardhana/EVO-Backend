package edu.icet.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Supplier {

    @NotNull(message = "User ID required")
    @PositiveOrZero(message = "ID must be possitive")
    private long userId;

    @NotNull(message = "Profile ID is required")
    @PositiveOrZero(message = "ID must be possitive")
    private long profileId;

    @NotEmpty(message = "Business Name is required")
    private String businessName;

    @Email
    @NotEmpty(message = "E - mail is required")
    private String email;

    @Size(max = 10)
    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @NotEmpty(message = "Description is required")
    private String description;

    @URL(protocol = "https" , message = "Must be HTTPS")
    private String website;

}
