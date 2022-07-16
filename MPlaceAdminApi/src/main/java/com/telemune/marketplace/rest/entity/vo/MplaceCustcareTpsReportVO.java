package com.telemune.marketplace.rest.entity.vo;

public class MplaceCustcareTpsReportVO {
	
	private String reportDate;
	
	private Integer totalCallsPerHour;

	/**
	 * @return the reportDate
	 */
	public final String getReportDate() {
		return reportDate;
	}

	/**
	 * @return the totalCallsPerHour
	 */
	public final Integer getTotalCallsPerHour() {
		return totalCallsPerHour;
	}

	/**
	 * @param reportDate the reportDate to set
	 */
	public final void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	/**
	 * @param totalCallsPerHour the totalCallsPerHour to set
	 */
	public final void setTotalCallsPerHour(Integer totalCallsPerHour) {
		this.totalCallsPerHour = totalCallsPerHour;
	}

}
