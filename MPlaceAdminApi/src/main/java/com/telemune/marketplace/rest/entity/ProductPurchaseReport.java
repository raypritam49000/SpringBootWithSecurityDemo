package com.telemune.marketplace.rest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.ProductPurchaseReportIds;

@Entity
@Table(name = "mplace_custcare_product_purchase_report")
public class ProductPurchaseReport {

	@EmbeddedId
	ProductPurchaseReportIds productPurchaseReportIds;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "TOTAL_COUNT")
	private String totalCount;

	/**
	 * @return the productPurchaseReportIds
	 */
	public ProductPurchaseReportIds getProductPurchaseReportIds() {
		return productPurchaseReportIds;
	}

	/**
	 * @param productPurchaseReportIds the productPurchaseReportIds to set
	 */
	public void setProductPurchaseReportIds(ProductPurchaseReportIds productPurchaseReportIds) {
		this.productPurchaseReportIds = productPurchaseReportIds;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the totalCount
	 */
	public String getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "ProductPurchaseReport [productPurchaseReportIds=" + productPurchaseReportIds + ", productName="
				+ productName + ", totalCount=" + totalCount + "]";
	}

}
