package edu.icet.entity.supplier;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="profile_packages")

public class ProfilePackageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long packageId;

    @NotNull
    @Column(nullable = false, length = 500)
    private String description;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(nullable = false, length = 150)
    private String packageName;

    @NotNull
    @DecimalMax("10.0")
    @DecimalMin("0.0")
    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "profilePackage")
    private List<PackageFeatureEntity> features = new ArrayList<>();
}
