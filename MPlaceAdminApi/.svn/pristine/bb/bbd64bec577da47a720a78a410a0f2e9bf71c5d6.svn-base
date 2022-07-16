package com.telemune.marketplace.rest.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telemune.marketplace.rest.entity.ProductPurchaseReport;
import com.telemune.marketplace.rest.entity.embedded.ProductPurchaseReportIds;

public interface MplaceCustCareProductPurchaseReportRepository
		extends JpaRepository<ProductPurchaseReport, ProductPurchaseReportIds> {

	@Query(value = "CALL custcare_product_purchase_dash(:startDateInTimSta,:endDateInTimSta,:startDate,:endDate)", nativeQuery = true)
	List<Object[]> custcareProductPurchaseDash(@Param("startDateInTimSta") Timestamp startDateInTimSta,
			@Param("endDateInTimSta") Timestamp endDateInTimSta, @Param("startDate") int startDate,
			@Param("endDate") int endDate);

	@Query("SELECT DISTINCT ppr.productName FROM  ProductPurchaseReport ppr WHERE ppr.productPurchaseReportIds.reportDate between ?1 AND  ?2  order by ppr.productName")
	List<String> findDistinctProductName(Timestamp startDateInTimSta, Timestamp endDateInTimSta);

}