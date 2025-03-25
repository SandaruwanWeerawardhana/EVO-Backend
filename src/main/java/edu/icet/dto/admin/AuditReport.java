package edu.icet.dto.admin;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "audit_report")
public class AuditReport {
    private Long reportId;
    private Long eventId;
    private String timestamp;
    private String action;
    private String data;

}
