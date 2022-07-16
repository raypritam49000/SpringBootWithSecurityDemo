package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

public class MplaceCustcareTpsReportIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "REPORT_DATE")
	private Timestamp reportDate;

	MplaceCustcareTpsReportIds() {

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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MplaceCustcareTpsReportIds [reportDate=" + reportDate + "]";
	}

}