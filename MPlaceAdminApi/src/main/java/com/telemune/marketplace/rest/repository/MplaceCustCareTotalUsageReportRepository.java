package com.telemune.marketplace.rest.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telemune.marketplace.rest.entity.MplaceCustCareTotalUsageReport;

public interface MplaceCustCareTotalUsageReportRepository
		extends JpaRepository<MplaceCustCareTotalUsageReport, Integer> {

	List<MplaceCustCareTotalUsageReport> findByMplaceCustCareTotalUsageReportIdsReportDateBetween(
			Timestamp startDateInTimSta, Timestamp endDateInTimSta);

	Page<MplaceCustCareTotalUsageReport> findByMplaceCustCareTotalUsageReportIdsReportDateBetween(
			Timestamp startDateInTimSta, Timestamp endDateInTimSta, Pageable paging);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes),date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m-%d') FROM MplaceCustCareTotalUsageReport mcctur WHERE  mcctur.mplaceCustCareTotalUsageReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m-%d-%h')")
	Page<Object[]> findByProductMplaceCustCareTotalUsageReportHourly(Timestamp startDate, Timestamp endDate,
			Pageable paging);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes),date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m') FROM MplaceCustCareTotalUsageReport mcctur WHERE mcctur.mplaceCustCareTotalUsageReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m')")
	Page<Object[]> findByProductMplaceCustCareTotalUsageReportMonthlyDate(Timestamp startDate, Timestamp endDate,
			Pageable paging);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes),date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m-%d') FROM MplaceCustCareTotalUsageReport mcctur WHERE  mcctur.mplaceCustCareTotalUsageReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m-%d')")
	Page<Object[]> findByMplaceCustCareTotalUsageReportDailyDate(Timestamp startDate, Timestamp endDate,
			Pageable paging);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes),date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y') FROM MplaceCustCareTotalUsageReport mcctur WHERE  mcctur.mplaceCustCareTotalUsageReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y')")
	Page<Object[]> findByMplaceCustCareTotalUsageReportWithYearlyDate(Timestamp startDate, Timestamp endDate,
			Pageable paging);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes),date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m') FROM MplaceCustCareTotalUsageReport mcctur WHERE  mcctur.mplaceCustCareTotalUsageReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m-%d')")
	List<Object[]> findByMplaceCustCareTotalUsageReportMonthlyDateWithOutPage(Timestamp startDate, Timestamp endDate);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes),date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m-%d') FROM MplaceCustCareTotalUsageReport mcctur WHERE  mcctur.mplaceCustCareTotalUsageReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m-%d')")
	List<Object[]> findByMplaceCustCareTotalUsageReportDailyDateWithOutPage(Timestamp startDate, Timestamp endDate);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes),date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y') FROM MplaceCustCareTotalUsageReport mcctur WHERE mcctur.mplaceCustCareTotalUsageReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y')")
	List<Object[]> findByMplaceCustCareTotalUsageReportWithYearlyDateWithOutPage(Timestamp startDate,
			Timestamp endDate);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes), date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%d-%m-%Y %H:%i:%s') FROM MplaceCustCareTotalUsageReport mcctur WHERE mcctur.mplaceCustCareTotalUsageReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by  mcctur.mplaceCustCareTotalUsageReportIds.reportDate")
	Page<Object[]> findByMplaceCustCareTotalUsageReportWithoutAggregateTypes(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta, Pageable paging);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes), date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%d-%m-%Y %H:%i:%s') FROM MplaceCustCareTotalUsageReport mcctur WHERE mcctur.mplaceCustCareTotalUsageReportIds.reportDate between "
			+ " ?1 AND  ?2  group by  mcctur.mplaceCustCareTotalUsageReportIds.reportDate")
	List<Object[]> findByMplaceCustCareTotalUsageReportWithoutAggregateTypesAndPage(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta);

	@Query("SELECT sum(mcctur.totalCallsCount), sum(mcctur.totalCallDurationInMintes),date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m-%d') FROM MplaceCustCareTotalUsageReport mcctur WHERE mcctur.mplaceCustCareTotalUsageReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(mcctur.mplaceCustCareTotalUsageReportIds.reportDate,'%Y-%m-%d-%h')")
	List<Object[]> findByProductMplaceCustCareTotalUsageReportHourlyWithOutPage(Timestamp startDate, Timestamp endDate);

}
