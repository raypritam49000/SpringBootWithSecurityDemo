package com.telemune.marketplace.rest.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telemune.marketplace.rest.entity.MplaceCustcareRetReportCurrent;
import com.telemune.marketplace.rest.entity.embedded.MplaceCustcareRetReportCurrentIds;

public interface MplaceCustcareRetReportCurrentRepository
		extends JpaRepository<MplaceCustcareRetReportCurrent, MplaceCustcareRetReportCurrentIds> {

	List<MplaceCustcareRetReportCurrent> findByMplaceCustcareRetReportCurrentIdsReportDateBetween(
			Timestamp startDateInTimSta, Timestamp endDateInTimSta);

}

