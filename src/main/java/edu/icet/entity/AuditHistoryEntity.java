package edu.icet.entity;

import edu.icet.util.AuditActionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AuditHistory")
public class AuditHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false )
    private Long adminId;
    @Column(nullable = false)
    private String reasonForChange;
    @Column(nullable = false)
    private Timestamp timestamp;
    @Column(nullable = false)
    private AuditActionType actionType;
    @Column(nullable = false)
    private String affectedEntity;
    @Column(nullable = false)
    private String newData;
    @Column(nullable = false)
    private String oldData;
}
