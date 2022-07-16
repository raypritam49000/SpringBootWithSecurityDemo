package com.telemune.marketplace.rest.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.telemune.marketplace.rest.entity.ProductPurchaseReport;

public interface ProductPurchaseReportRepository extends JpaRepository<ProductPurchaseReport, Integer> {

	List<ProductPurchaseReport> findByProductPurchaseReportIdsReportDateBetween(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta);

	Page<ProductPurchaseReport> findByProductPurchaseReportIdsReportDateBetween(Timestamp startDateInTimSta,
			Timestamp endDateInTimSta, Pageable paging);
	
	
}
