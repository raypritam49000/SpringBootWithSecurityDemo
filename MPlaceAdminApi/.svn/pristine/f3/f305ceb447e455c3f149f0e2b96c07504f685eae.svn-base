package com.telemune.marketplace.rest.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.telemune.marketplace.rest.entity.MplaceCustcareRetentionReport;
import com.telemune.marketplace.rest.entity.embedded.MplaceCustCareRetentionReportIds;;

public interface MplaceCustcareRetentionReportRepository extends JpaRepository<MplaceCustcareRetentionReport, MplaceCustCareRetentionReportIds> {

	List<MplaceCustcareRetentionReport> findByMplaceCustCareRetentionReportIdsReportDateBetween(
			Timestamp startDateInTimSta, Timestamp endDateInTimSta);

	Page<MplaceCustcareRetentionReport> findByMplaceCustCareRetentionReportIdsReportDateBetween(
			Timestamp startDateInTimSta, Timestamp endDateInTimSta, Pageable paging);

}
