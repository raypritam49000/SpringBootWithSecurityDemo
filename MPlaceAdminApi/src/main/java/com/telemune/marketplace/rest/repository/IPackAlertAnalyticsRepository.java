package com.telemune.marketplace.rest.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telemune.marketplace.rest.entity.PackAlertAnalytics;
import com.telemune.marketplace.rest.entity.embedded.PackAlertAnalyticsIds;

public interface IPackAlertAnalyticsRepository extends JpaRepository<PackAlertAnalytics, PackAlertAnalyticsIds> {

	Page<PackAlertAnalytics> findByPackAlertAnalyticsIdsAlertDateBetween(Date startDateInFromat, Date endDate2InFromat,
			Pageable paging);

	@Query(value = "select m.msisdn, m.PACK_ID as PACK_ID,m.request_date as ALERT_DATE, t.create_date as PURCHASED_DATE from "
			+ "mplace_pack_expiry_alert_details as "
			+ "m JOIN transaction_cdrs as t ON m.msisdn=t.msisdn where m.PACK_ID=t.PACK_ID "
			+ "and m.REQUEST_DATE between ?1  and (?1+ interval 1 day) "
			+ "and t.create_date between ?1 and (?1+ interval 1 day)", nativeQuery = true)
	List<Object[]> AlertDetail(String alertDate);

}
