package edu.icet.entity.supplier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProfileExtraFeature")

public class PackageFeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featureID;

    @Column(nullable = false, length = 500)
    private String featureName;

    @Column(nullable = false)
    private Double featurePrice;

    @ManyToOne
    @JoinColumn(name = "profile_package_id")
    private ProfilePackageEntity profilePackage;
}

