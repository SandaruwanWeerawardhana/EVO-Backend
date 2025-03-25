package edu.icet.entity.supplier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "package_feature_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageFeatureDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long packageFeatureDetailId;
    @Column(name = "package_id",nullable = false)
    private Long packageId;
    @Column(name = "feature_id",nullable = false)
    private Long featureId;
}
