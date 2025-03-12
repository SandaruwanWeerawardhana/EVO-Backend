package edu.icet.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supplier {

    @NotEmpty(message = "User ID required")
    @PositiveOrZero(message = "ID must be positive")
    private long userId;

    @NotEmpty(message = "Category ID required")
    @PositiveOrZero(message = "ID must be positive")
    private Long categoryId;

    @NotEmpty(message = "Profile ID is required")
    @PositiveOrZero(message = "ID must be positive")
    private long profileId;

    @NotEmpty(message = "Terms ID is required")
    @PositiveOrZero(message = "ID must be positive")
    private long termsId;

    @NotEmpty(message = "Business Name is required")
    private String businessName;

    @Email
    @NotEmpty(message = "Email is required")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @NotEmpty(message = "Description is required")
    private String description;

    @NotNull(message = "Location is required")
    private Location location;

    private String profilePictureImageUrl;

    private Boolean availability;
}
