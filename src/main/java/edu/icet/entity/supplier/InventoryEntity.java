package edu.icet.entity.supplier;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @NotBlank(message = "cannot be empty")
    private Long supplierId;

    @NotBlank(message = "cannot be empty")
    private String imageURL;

    @NotBlank(message = "cannot be empty")
    private String description;

    @NotBlank(message = "cannot be empty")
    private String supplierCategory;
}
