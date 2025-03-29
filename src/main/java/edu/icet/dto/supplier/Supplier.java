package edu.icet.dto.supplier;

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

    @NotEmpty(message = "Description is required")
    private String description;

    private Boolean availability;

    @NotNull(message = "Location is required")
    private Location location;

    private ProfileImage profileImage;

    @Enumerated(EnumType.STRING)
    private SupplierCategoryType category;

    private BeautySaloon beautySaloon;

    private Catering catering;

    private Venue venue;

    private Music music;

    private List<SupplierRequest> requests;

    private List<ProfilePackage> packages;

    private List<ProfilePreviousWork> previousWorks;

    private List<ProfileImage> images;

    private List<Inventory> inventories;
}
