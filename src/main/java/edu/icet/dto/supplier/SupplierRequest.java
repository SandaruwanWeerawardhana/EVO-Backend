package edu.icet.dto.supplier;

import edu.icet.dto.customer.Customer;
import edu.icet.util.SupplerRequestStatusType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SupplierRequest {
    private Long id;

    @NotNull(message = "RequestDate not be empty")
    private LocalDateTime requestDate;

    @NotNull(message = "DueDate not be empty")
    private LocalDateTime dueDateTime;

    @NotNull(message = "Approve not be empty")
    @Enumerated(EnumType.STRING)
    private SupplerRequestStatusType requestStatus;

    @NotNull(message = "Customer not be empty")
    private Customer customer;

    @NotNull(message = "Profile Package not be empty")
    private ProfilePackage selectedPackage;

    private List<PackageFeature> extraFeatures;

    @NotNull(message = "Location not be empty")
    private Location location;

}
