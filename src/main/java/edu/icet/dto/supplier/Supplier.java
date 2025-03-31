package edu.icet.dto.supplier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import edu.icet.dto.system.Terms;
import edu.icet.util.SupplierCategoryType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supplier {

    private Long id;

    @NotEmpty(message = "Business Name is required")
    private String businessName;

    private String businessContactNumber;

    @Email(message = "Email should be valid")
    private String businessEmail;

    @NotEmpty(message = "Description is required")
    private String description;

    private Boolean availability;

    @NotNull(message = "Location is required")
    private Location location;

    private ProfileImage profileImage;

    @Enumerated(EnumType.STRING)
    private SupplierCategoryType category;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BeautySaloon beautySaloon;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Catering catering;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Venue venue;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Music music;

    private List<SupplierRequest> requests;

    private List<ProfilePackage> packages;

    private List<ProfilePreviousWork> previousWorks;

    private List<ProfileImage> images;

    private List<Inventory> inventories;
}
