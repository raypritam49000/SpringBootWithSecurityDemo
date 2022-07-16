package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;

public class RevenueReportIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "report_date")
	private Date reportDate;

	@Column(name = "request_type")
	private Integer requestType;
	
	@Column(name = "request_name")
	private String requestName;

	@Column(name = "service_charge")
	private Integer serviceCharge;

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
	 * @return the requestType
	 */
	public Integer getRequestType() {
		return requestType;
	}

	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(Integer requestType) {
		this.requestType = requestType;
	}

	/**
	 * @return the requestName
	 */
	public String getRequestName() {
		return requestName;
	}

	/**
	 * @param requestName the requestName to set
	 */
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	/**
	 * @return the serviceCharge
	 */
	public Integer getServiceCharge() {
		return serviceCharge;
	}

	/**
	 * @param serviceCharge the serviceCharge to set
	 */
	public void setServiceCharge(Integer serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RevenueReportIds() {
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RevenueReportIds that = (RevenueReportIds) o;

		if (!reportDate.equals(that.reportDate))
			return false;
		return requestType.equals(that.requestType);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RevenueReportIds [reportDate=" + reportDate + ", requestType=" + requestType + ", requestName="
				+ requestName + ", serviceCharge=" + serviceCharge + "]";
	}

	
}
