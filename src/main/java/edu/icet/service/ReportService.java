package edu.icet.service;

import edu.icet.dto.Report;
import edu.icet.util.ReportType;

import java.util.List;

public interface ReportService {
    boolean saveReport(Report report);
    boolean updateReport(Report report);
    boolean deleteReportById(Long reportId);
    Report searchReport(long reportId);
    List<Report> getAllReports();
    List<Report> getFillterReports(ReportType reportType);
}
