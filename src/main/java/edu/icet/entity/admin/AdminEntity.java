package edu.icet.entity.admin;

import edu.icet.util.AdminType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "admin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @OneToOne
    @JoinColumn(name = "audit_history_id")
    private AuditHistoryEntity auditHistory;
    @Enumerated(EnumType.STRING)
    private AdminType type;
}
