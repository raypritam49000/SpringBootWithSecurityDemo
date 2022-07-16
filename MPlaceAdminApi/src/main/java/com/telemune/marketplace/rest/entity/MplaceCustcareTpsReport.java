package com.telemune.marketplace.rest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.MplaceCustcareTpsReportIds;

@Entity
@Table(name="mplace_custcare_tps_report")
public class MplaceCustcareTpsReport {
	
	@EmbeddedId
	MplaceCustcareTpsReportIds mplaceCustcareTpsReportIds;
	
	@Column(name="TOTAL_CALLS_PER_HOUR")
	private Integer totalCallsPerHour;

	/**
	 * @return the mplaceCustcareTpsReportIds
	 */
	public MplaceCustcareTpsReportIds getMplaceCustcareTpsReportIds() {
		return mplaceCustcareTpsReportIds;
	}

	/**
	 * @return the totalCallsPerHour
	 */
	public Integer getTotalCallsPerHour() {
		return totalCallsPerHour;
	}

	/**
	 * @param mplaceCustcareTpsReportIds the mplaceCustcareTpsReportIds to set
	 */
	public void setMplaceCustcareTpsReportIds(MplaceCustcareTpsReportIds mplaceCustcareTpsReportIds) {
		this.mplaceCustcareTpsReportIds = mplaceCustcareTpsReportIds;
	}

	/**
	 * @param totalCallsPerHour the totalCallsPerHour to set
	 */
	public void setTotalCallsPerHour(Integer totalCallsPerHour) {
		this.totalCallsPerHour = totalCallsPerHour;
	}
}
