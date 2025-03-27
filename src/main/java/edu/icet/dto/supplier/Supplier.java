package edu.icet.dto.supplier;

import edu.icet.dto.system.Category;
import edu.icet.dto.system.Terms;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Supplier {

    @PositiveOrZero(message = "ID must be positive")
    private long userId;

    @NotBlank(message = "firstName cannot be empty")
    @NotNull
    private String firstName;

    @NotBlank(message = "lastName cannot be empty")
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Email cannot be empty")
    @NotNull
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",
            message = "password must be at least 8 characters, contain a number, an uppercase letter, and a special character.")
    private String password;

    @NotBlank(message = "Phone number cannot be empty")
    @NotNull
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String contactNumber;

    @NotBlank(message = "Business Name is required")
    private String businessName;

    @Enumerated(EnumType.STRING)
    private Category category;

    @NotBlank(message = "Description is required")
    private String description;

    private String websiteURL;
    private String profilePictureImageUrl;
    private Boolean availability;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
    private Terms terms;
}
