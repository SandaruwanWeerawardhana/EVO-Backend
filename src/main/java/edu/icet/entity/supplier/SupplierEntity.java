package edu.icet.entity.supplier;


import edu.icet.util.SupplierCategoryType;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String businessName;

    private String businessContactNumber;

    private String businessEmail;

    private String description;

    private Boolean availability;

    @Enumerated(EnumType.STRING)
    private SupplierCategoryType category;

    private String profileImageUrl;
}
