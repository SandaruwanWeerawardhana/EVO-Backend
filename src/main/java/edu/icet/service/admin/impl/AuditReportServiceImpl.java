package edu.icet.service.admin.impl;

import edu.icet.dto.AuditReport;
import edu.icet.service.admin.AuditReportService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AuditReportServiceImpl implements AuditReportService {

    List<AuditReport> auditReportList = new ArrayList<>();

    @Override
    public boolean saveAuditReport(AuditReport auditReport) {

        if (auditReport == null) {
            return false;
        } else {
            return auditReportList.add(auditReport);

        }
    }

    @Override
    public AuditReport getAuditReportById(Long id) {
        for (AuditReport report : auditReportList) {
            if (report.getReportId().equals(id)) {
                return report;
            }
        }
        return null;
    }

    @Override
    public List<AuditReport> getAllAuditReports() {
        if(auditReportList!=null){
            return new ArrayList<>(auditReportList);
        }
        return null;
    }

    @Override
    public boolean updateAuditReport(Long id, AuditReport auditReport) {
        for (int i = 0; i < auditReportList.size(); i++) {
            if (auditReportList.get(i).getReportId().equals(id)) {
                auditReportList.set(i, auditReport);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteAuditReportById(Long id) {
        if (id == null) {
            return false;
        } else {
            return auditReportList.removeIf(auditReport -> Objects.equals(auditReport.getReportId(), id));
        }
    }
}
