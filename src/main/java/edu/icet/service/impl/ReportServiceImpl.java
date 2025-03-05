package edu.icet.service.impl;

import edu.icet.dto.Report;
import edu.icet.service.ReportService;
import edu.icet.util.ReportType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    final ModelMapper mapper;

    List<Report> dataBase = new ArrayList<>();

    @Override
    public boolean saveReport(Report report) {

        return dataBase.add(report);
    }

    @Override
    public boolean updateReport(Long reportId, Report report) {

        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i).getReportId().equals(reportId)) {
                dataBase.set(i, report);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteReportById(Long reportId) {
        return dataBase.removeIf(report -> report.getReportId().equals(reportId));
    }

    @Override
    public Report searchReport(long reportId) {
        return dataBase.stream()
                .filter(report -> report.getReportId().equals(reportId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Report> getAllReports() {
        return dataBase;
    }

    @Override
    public List<Report> getFillterReports(ReportType reportType) {
        List<Report> filteredReports = new ArrayList<>();
        for (Report report : dataBase) {
            if (report.getReportType().equals(reportType)) {
                filteredReports.add(report);
            }
        }
        return filteredReports;
    }
}
