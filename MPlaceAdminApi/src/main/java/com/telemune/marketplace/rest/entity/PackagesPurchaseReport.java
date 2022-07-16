package com.telemune.marketplace.rest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.PackagesPurchaseReportIds;

@Entity
@Table(name = "packages_purchase_report")
public class PackagesPurchaseReport {

	@EmbeddedId
	private PackagesPurchaseReportIds packagesPurchaseReportIds;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "totalCount")
	private String totalCount;

	@Column(name = "total_amount")
	private Integer totalAmount;

	/**
	 * 
	 * /**
	 * 
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

	/**
	 * @return the packagesPurchaseReportIds
	 */
	public PackagesPurchaseReportIds getPackagesPurchaseReportIds() {
		return packagesPurchaseReportIds;
	}

	/**
	 * @param packagesPurchaseReportIds the packagesPurchaseReportIds to set
	 */
	public void setPackagesPurchaseReportIds(PackagesPurchaseReportIds packagesPurchaseReportIds) {
		this.packagesPurchaseReportIds = packagesPurchaseReportIds;
	}

	/**
	 * @return the totalAmount
	 */
	public Integer getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackagesPurchaseReport [packagesPurchaseReportIds=" + packagesPurchaseReportIds + ", productName="
				+ productName + ", totalCount=" + totalCount + ", totalAmount=" + totalAmount + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	
	
}
