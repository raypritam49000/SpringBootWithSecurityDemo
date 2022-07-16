package com.telemune.marketplace.rest.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.telemune.marketplace.rest.entity.MplaceCustcareTpsReport;
import com.telemune.marketplace.rest.entity.embedded.MplaceCustcareTpsReportIds;

public interface MplaceCustCareTpsReportRepository extends JpaRepository<MplaceCustcareTpsReport, MplaceCustcareTpsReportIds> {

	List<MplaceCustcareTpsReport> findByMplaceCustcareTpsReportIdsReportDateBetween(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta);

	Page<MplaceCustcareTpsReport> findByMplaceCustcareTpsReportIdsReportDateBetween(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta, Pageable paging);
	
	
	
	
	
	
	
	
	

}
