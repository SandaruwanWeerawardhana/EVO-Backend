package edu.icet.entity.supplier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "venue_request")
public class VenueRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_id",nullable = false)
    private Long supplierId;

    @Column(name = "venue_id",nullable = false)
    private Long venueID;

    @Column(name = "created_datetime",nullable = false)
    private LocalDateTime createdDateTime;

    @Column(nullable = false)
    private String status;
}
