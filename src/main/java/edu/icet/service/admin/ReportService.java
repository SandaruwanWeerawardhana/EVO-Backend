package edu.icet.service.admin;

import edu.icet.dto.Report;
import edu.icet.util.ReportType;

import java.util.List;

public interface ReportService {
    boolean saveReport(Report report);
    boolean updateReport(Long reportId,Report report);
    boolean deleteReportById(Long reportId);
    Report searchReport(long reportId);
    List<Report> getAllReports();
    List<Report> getFillterReports(ReportType reportType);
}
