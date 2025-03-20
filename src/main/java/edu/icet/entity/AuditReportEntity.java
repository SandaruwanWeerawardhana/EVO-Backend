package edu.icet.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AuditReport")

public class AuditReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(nullable = false)
    private Integer adminId;
   @Column(nullable = false)
    private Long reportId;

}
