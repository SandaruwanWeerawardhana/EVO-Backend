package edu.icet.dto.supplier;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Supplier {
    @PositiveOrZero(message = "ID must be positive")
    private long userId;

    @NotBlank(message = "First Name cannot be empty")
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",
            message = "Password must be at least 8 characters, contain a number, an uppercase letter, and a special character.")
    private String password;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String contactNumber;

    @NotBlank(message = "Business Name is required")
    private String businessName;

    private String category;

    @NotBlank(message = "Description is required")
    private String description;

    private String websiteURL;
    private String profilePictureImageUrl;
    private Boolean availability;

    @NotNull(message = "Terms must be accepted")
    private Long termsId;
}
