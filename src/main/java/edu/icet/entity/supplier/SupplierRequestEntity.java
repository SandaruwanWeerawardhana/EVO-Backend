package edu.icet.entity.supplier;

import edu.icet.dto.customer.Customer;
import edu.icet.dto.supplier.Location;
import edu.icet.dto.supplier.PackageFeature;
import edu.icet.dto.supplier.ProfilePackage;
import edu.icet.entity.customer.CustomerEntity;
import edu.icet.entity.event.EventSummaryEntity;
import edu.icet.util.SupplerRequestStatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SupplierRequest")

public class SupplierRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime requestDate;

    private LocalDateTime dueDateTime;

    @Enumerated(EnumType.STRING)
    private SupplerRequestStatusType requestStatus;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToOne
    @JoinColumn(name = "profile_package_id")
    private ProfilePackageEntity selectedPackage;

    @OneToMany
    @JoinColumn(name = "supplier_request_id")
    private List<PackageFeatureEntity> extraFeatures;

    @OneToOne
    @JoinColumn(name = "location_id")
    private LocationEntity location;
}
