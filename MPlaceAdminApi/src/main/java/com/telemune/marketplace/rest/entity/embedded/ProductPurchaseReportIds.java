package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

public class ProductPurchaseReportIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "REPORT_DATE")
	private Timestamp reportDate;

	@Column(name = "PRODUCT_CODE")
	private String productCode;

	ProductPurchaseReportIds() {

	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ProductPurchaseReportIds that = (ProductPurchaseReportIds) o;

		if (!reportDate.equals(that.reportDate))
			return false;
		return productCode.equals(that.productCode);
	}

	/**
	 * @return the reportDate
	 */
	public Timestamp getReportDate() {
		return reportDate;
	}

	/**
	 * @param reportDate the reportDate to set
	 */
	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductPurchaseReportIds [reportDate=" + reportDate + ", productCode=" + productCode + "]";
	}

}
