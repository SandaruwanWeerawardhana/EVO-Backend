package edu.icet.entity.supplier;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Builder
@Data
public class SupplierExtraFeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "extra_feature_supplier_id")
    private List<PackageFeatureEntity> extraFeatures;
}
