package edu.icet.repository;

import edu.icet.entity.ReportEntity;
import edu.icet.util.ReportType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportEntity,Long> {
    Iterable<Object> findAllByReportType(ReportType reportType);
}
