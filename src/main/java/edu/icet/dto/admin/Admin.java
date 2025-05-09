package edu.icet.dto.admin;

import edu.icet.util.AdminType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class Admin {
    private Long adminId;

    private AuditHistory auditHistory;

    @Enumerated(EnumType.STRING)
    private AdminType type;
}
