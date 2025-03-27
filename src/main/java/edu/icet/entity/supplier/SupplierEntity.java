package edu.icet.entity.supplier;

import edu.icet.dto.system.Category;
import edu.icet.entity.system.TermsEntity;
import edu.icet.util.CategoryType;
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

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String contactNumber;

    @NotBlank
    private String businessName;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @NotBlank
    private String description;

    private String websiteURL;
    private String profilePictureImageUrl;
    private Boolean availability;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id", referencedColumnName = "termId")
    private TermsEntity terms;
}
