package com.telemune.marketplace.rest.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telemune.marketplace.rest.entity.RevenueReport;
import com.telemune.marketplace.rest.entity.embedded.RevenueReportIds;

public interface IRevenueRepository extends JpaRepository<RevenueReport, RevenueReportIds> {

	List<RevenueReport> findByRevenueReportIdsReportDateBetween(Timestamp startDateInTimSta, Timestamp endDateInTimSta);

	List<RevenueReport> findByRevenueReportIdsRequestTypeAndRevenueReportIdsReportDateBetween(Integer requestType,
			Timestamp startDateInTimSta, Timestamp endDateInTimSta);

	Page<RevenueReport> findByRevenueReportIdsReportDateBetween(Timestamp startDateInTimSta, Timestamp endDateInTimSta,Pageable paging);

	Page<RevenueReport> findByRevenueReportIdsRequestTypeAndRevenueReportIdsReportDateBetween(Integer requestType,
			Timestamp startDateInTimSta, Timestamp endDateInTimSta, Pageable paging);

	@Query("SELECT rp.revenueReportIds.requestType , rp.revenueReportIds.requestName FROM RevenueReport rp  group by rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	List<Object[]> findDistinctRequestTypeAndRequestType();

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2 AND rp.revenueReportIds.requestType=?3  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	Page<Object[]> findByRevenueReportWithMonthlyDateAndRequestType(Timestamp startDate, Timestamp endDate, Integer requestType,
			Pageable paging);

	@Query("SELECT rp.revenueReportIds.requestType ,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2 AND rp.revenueReportIds.requestType=?3  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	Page<Object[]> findByRevenueReportWithDaysDateAndRequestType(Timestamp startDate, Timestamp endDate, Integer requestType,
			Pageable paging);

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2 AND rp.revenueReportIds.requestType=?3  group by date_format(rp.revenueReportIds.reportDate,'%Y'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	Page<Object[]> findByRevenueReportWithYearlyDateAndRequestType(Timestamp startDate, Timestamp endDate, Integer requestType,
			Pageable paging);
	
	@Query("SELECT rp.revenueReportIds.requestType ,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d %H:%i:%s') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2 AND rp.revenueReportIds.requestType=?3  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d %H:%i:%s'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	Page<Object[]> findByRevenueReportWithHourlyDateAndRequestType(Timestamp startDateInFormat, Timestamp endDateInFormat,
			Integer requestType, Pageable paging);

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	Page<Object[]> findByRevenueReportWithMonthlyDate(Timestamp startDate, Timestamp endDate, Pageable paging);

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d')  FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	Page<Object[]> findByRevenueReportWithDaysDate(Timestamp startDate, Timestamp endDate, Pageable paging);

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2 group by date_format(rp.revenueReportIds.reportDate,'%Y'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	Page<Object[]> findByRevenueReportWithYearlyDate(Timestamp startDate, Timestamp endDate, Pageable paging);
	
	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d %H:%i:%s')  FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d %H:%i:%s'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	Page<Object[]> findByRevenueReportWithHourlyDate(Timestamp startDate, Timestamp endDate, Pageable paging);

   @Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2 AND rp.revenueReportIds.requestType=?3  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	List<Object[]> findByRevenueReportWithDaysDateAndRequestTypeWithOutPage(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta, Integer requestType);
	
	 @Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d%H:%i:%s') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
				+ " ?1 AND  ?2 AND rp.revenueReportIds.requestType=?3  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d%H:%i:%s'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
		List<Object[]> findByRevenueReportWithHourlyDateAndRequestTypeWithOutPage(Timestamp startDateInTimSta,
				Timestamp endDateInTimSta, Integer requestType);

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName ,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m')FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2 AND rp.revenueReportIds.requestType=?3  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	List<Object[]> findByRevenueReportWithMonthlyDateAndRequestTypeWithOutPage(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta, Integer requestType);

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2 AND rp.revenueReportIds.requestType=?3  group by date_format(rp.revenueReportIds.reportDate,'%Y'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	List<Object[]> findByRevenueReportWithYearlyDateAndRequestTypeWithOutPage(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta, Integer requestType);

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	List<Object[]> findByRevenueReportWithDaysDateWithOutPage(Timestamp startDateInTimSta, Timestamp endDateInTimSta);

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d%H:%i:%s') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m-%d%H:%i:%s'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	List<Object[]> findByRevenueReportWithHourlyDateWithOutPage(Timestamp startDateInTimSta, Timestamp endDateInTimSta);
	
	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y-%m') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2  group by date_format(rp.revenueReportIds.reportDate,'%Y-%m'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	List<Object[]> findByRevenueReportWithMonthlyDateWithOutPage(Timestamp startDateInTimSta, Timestamp endDateInTimSta);

	@Query("SELECT rp.revenueReportIds.requestType,rp.revenueReportIds.requestName,sum(rp.chargeCount),sum(rp.chargeAmount),date_format(rp.revenueReportIds.reportDate,'%Y') FROM RevenueReport rp WHERE rp.revenueReportIds.reportDate between  "
			+ " ?1 AND  ?2 group by date_format(rp.revenueReportIds.reportDate,'%Y'),rp.revenueReportIds.requestType,rp.revenueReportIds.requestName")
	List<Object[]> findByRevenueReportWithYearlyDateWithOutPage(Timestamp startDateInTimSta, Timestamp endDateInTimSta);



}
