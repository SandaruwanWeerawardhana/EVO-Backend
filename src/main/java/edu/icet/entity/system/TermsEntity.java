package edu.icet.entity.system;

import edu.icet.dto.supplier.Supplier;
import edu.icet.entity.supplier.CategoryEntity;
import edu.icet.entity.supplier.SupplierEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "terms")
@Data
public class TermsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @NotBlank
    @Size(min = 100)
    private String content;

    @NotNull
    private Boolean isActive;

    @NotNull
    private LocalDateTime lastUpdated;
}
