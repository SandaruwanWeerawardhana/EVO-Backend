package edu.icet.dto.admin;

import edu.icet.util.AdminType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
    private Long adminId;
    private AuditHistory auditHistory;
    @Enumerated(EnumType.STRING)
    private AdminType type;
}
