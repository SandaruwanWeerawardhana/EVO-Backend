package edu.icet.service;

import edu.icet.dto.Report;
import java.util.List;

public interface ReportService {
    boolean saveReport(Report report);
    boolean updateReport(Report report);
    boolean deleteReport(Report report);
    Report searchReport(long reportId);
    Report getReportById(long reportId);
    List<Report> getAllReports();
    List<Report> getFillterReports();
}
