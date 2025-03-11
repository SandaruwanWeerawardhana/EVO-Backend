package edu.icet.dto;

import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Supplier {

    @NotNull(message = "User ID required")
    @PositiveOrZero(message = "ID must be possitive")
    private Long userId;

    @NotNull(message = "Profile ID is required")
    @PositiveOrZero(message = "ID must be possitive")
    private Long profileId;

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

    private String website;

}
