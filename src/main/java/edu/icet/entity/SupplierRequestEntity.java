package edu.icet.entity;

import edu.icet.dto.Location;
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

    @Column(nullable = false)
    private Long supplierId;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private LocalDateTime requestDate;

    @Column(nullable = false)
    private Boolean isApproved;

    @Column(nullable = false)
    private Location location;

    @Column(nullable = false)
    private LocalDateTime dueDateTime;
}
