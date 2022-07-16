package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;

public class PackagesPurchaseReportIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "report_date")
	private Date reportDate;

	@Column(name = "short_code")
	private String shortCode;
	
	@Column(name = "product_code")
	private String productCode;


	public PackagesPurchaseReportIds() {
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PackagesPurchaseReportIds that = (PackagesPurchaseReportIds) o;

		if (!reportDate.equals(that.reportDate))
			return false;
		return shortCode.equals(that.shortCode);
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the shortCode
	 */
	public String getShortCode() {
		return shortCode;
	}

	/**
	 * @param shortCode the shortCode to set
	 */
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	/**
	 * @return the reportDate
	 */
	public Date getReportDate() {
		return reportDate;
	}

	/**
	 * @param reportDate the reportDate to set
	 */
	public void setReportDate(Date reportDate) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackagesPurchaseReportIds [reportDate=" + reportDate + ", shortCode=" + shortCode + ", productCode="
				+ productCode + "]";
	}

	
	
}
