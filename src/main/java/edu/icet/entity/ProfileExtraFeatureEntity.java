package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProfileExtraFeature")

public class ProfileExtraFeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featureID;
    private Long profileID;
    @Column(nullable = false)
    private String featureName;
    @Column(nullable = false)
    private Double featurePrice;
}
