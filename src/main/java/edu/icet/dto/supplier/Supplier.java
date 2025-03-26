package edu.icet.dto.supplier;

import edu.icet.dto.system.Category;
import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supplier {

    @NotEmpty(message = "User ID required")
    @PositiveOrZero(message = "ID must be positive")
    private long userId;

    private Category category;

//    private Terms terms;

    // TODO: Implement TermsEntity by User Feature
    private Long terms;

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
