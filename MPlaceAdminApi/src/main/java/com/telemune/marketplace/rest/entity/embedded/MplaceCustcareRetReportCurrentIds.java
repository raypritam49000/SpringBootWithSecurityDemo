package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

public class MplaceCustcareRetReportCurrentIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "REPORT_DATE")
	private Timestamp reportDate;

	MplaceCustcareRetReportCurrentIds() {

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

	@Override
	public String toString() {
		return "MplaceCustcareRetReportCurrentIds [reportDate=" + reportDate + "]";
	}

}
