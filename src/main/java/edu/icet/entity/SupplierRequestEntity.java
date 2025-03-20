package edu.icet.entity;

import edu.icet.dto.Location;
import edu.icet.util.SupplerRequestStatusType;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SupplerRequestStatusType requestStatus;

    @Column(nullable = false)
    private Long locationID;

    @Column(nullable = false)
    private LocalDateTime dueDateTime;
}
