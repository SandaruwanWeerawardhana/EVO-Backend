package edu.icet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Suppliers")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Pattern(regexp = "^\\+?'[^0-9]'{10,15}$", message = "Invalid phone number")
    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @NotEmpty(message = "Description is required")
    private String description;

    @NotNull(message = "Location is required")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location",referencedColumnName = "locationId")
    private LocationEntity location;

    private String profilePictureImageUrl;

    private Boolean availability;
}
