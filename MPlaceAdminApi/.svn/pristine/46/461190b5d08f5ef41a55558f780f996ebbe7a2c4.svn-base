package com.telemune.marketplace.rest.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemune.marketplace.rest.entity.PackagesPurchaseReport;

@Repository
public interface ReportRepository extends JpaRepository<PackagesPurchaseReport, Integer> {

	Page<PackagesPurchaseReport> findByPackagesPurchaseReportIdsReportDateBetween(Date startDateInFromat,
			Date endDate2InFromat, Pageable paging);

	Page<PackagesPurchaseReport> findByPackagesPurchaseReportIdsShortCodeAndPackagesPurchaseReportIdsProductCodeInAndPackagesPurchaseReportIdsReportDateBetween(
			String fShortCode, List<Integer> packList, Date startDateInFromat, Date endDate2InFromat, Pageable paging);

	Page<PackagesPurchaseReport> findByPackagesPurchaseReportIdsProductCodeInAndPackagesPurchaseReportIdsReportDateBetween(
			List<Integer> packList, Date startDateInFromat, Date endDate2InFromat, Pageable paging);

	Page<PackagesPurchaseReport> findByPackagesPurchaseReportIdsShortCodeAndPackagesPurchaseReportIdsReportDateBetween(
			String fShortCode, Date startDateInFromat, Date endDate2InFromat, Pageable paging);

	List<PackagesPurchaseReport> findByPackagesPurchaseReportIdsReportDateBetween(Date startDateInFromat,
			Date endDate2InFromat);

	List<PackagesPurchaseReport> findByPackagesPurchaseReportIdsShortCodeAndPackagesPurchaseReportIdsProductCodeInAndPackagesPurchaseReportIdsReportDateBetween(
			String fShortCode, List<Integer> packList, Date startDateInFromat, Date endDate2InFromat);

	List<PackagesPurchaseReport> findByPackagesPurchaseReportIdsProductCodeInAndPackagesPurchaseReportIdsReportDateBetween(
			List<Integer> packList, Date startDateInFromat, Date endDate2InFromat);

	List<PackagesPurchaseReport> findByPackagesPurchaseReportIdsShortCodeAndPackagesPurchaseReportIdsReportDateBetween(
			String fShortCode, Date startDateInFromat, Date endDate2InFromat);

}
