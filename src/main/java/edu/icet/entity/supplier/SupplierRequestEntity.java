package edu.icet.entity.supplier;

import edu.icet.dto.supplier.Location;
import edu.icet.dto.supplier.ProfilePackages;
import edu.icet.entity.customer.CustomerEntity;
import edu.icet.util.SupplerRequestStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SupplierRequest")

public class SupplierRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToOne
    @JoinColumn(name = "package_id")
    private ProfilePackagesEntity packages;

    @Column(nullable = false)
    private LocalDateTime requestDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SupplerRequestStatusType requestStatus;

    @OneToOne
    @JoinColumn(name = "location_id")
    private LocationEntity location;

    @Column(nullable = false)
    private LocalDateTime dueDateTime;
}
