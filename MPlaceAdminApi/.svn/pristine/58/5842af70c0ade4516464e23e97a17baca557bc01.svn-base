package com.telemune.marketplace.rest.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telemune.marketplace.rest.entity.MplaceCustCareCdrReport;
import com.telemune.marketplace.rest.entity.embedded.MplaceCustCareCdrReportIds;

public interface MplaceCustCareCdrReportRepository
		extends JpaRepository<MplaceCustCareCdrReport, MplaceCustCareCdrReportIds> {

	Page<MplaceCustCareCdrReport> findByMplaceCustCareCdrReportIdsReportDateBetween(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta, Pageable paging);

	List<MplaceCustCareCdrReport> findByMplaceCustCareCdrReportIdsReportDateBetween(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta);

	@Query(value = "select date_format(REPORT_DATE,'%d-%m-%Y %H:%i:%s'),MSISDN,CALL_DURATION from mplace_custcare_cdr_report where REPORT_DATE between ?1 and ?2", nativeQuery = true)
	List<Object[]> getMplaceCustCareCdrReportList(Timestamp startDateInTimSta, Timestamp endDateInTimSta);

}
