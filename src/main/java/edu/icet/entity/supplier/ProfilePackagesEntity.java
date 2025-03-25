package edu.icet.entity.supplier;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="profile_packages")
public class ProfilePackagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long profileId;

    @NotNull
    @Column(nullable = false)
    private String description;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(nullable = false, length = 150)
    private String packageName;

    @NotNull
    @DecimalMax("10.0") @DecimalMin("0.0")
    @Column(nullable = false)
    private Double price;

    @NotNull
    @Column(nullable = false)
    private String status;

}
