package edu.icet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "event_supplier")
public class EventSupplierEntity {
    @Id
    @Column(name = "event_id", nullable = false)
    private Integer eventId;
    @Id
    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;
}
