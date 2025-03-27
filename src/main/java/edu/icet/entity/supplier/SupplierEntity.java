package edu.icet.entity.supplier;

import edu.icet.entity.event.EventSupplierEntity;
import edu.icet.entity.system.TermsEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Suppliers")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToOne
    @JoinColumn(name = "terms_id")
    private TermsEntity terms;

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
    @OneToOne
    @JoinColumn(name = "location_id")
    private LocationEntity location;

    private String profilePictureImageUrl;

    private Boolean availability;

}
