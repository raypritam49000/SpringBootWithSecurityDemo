package com.telemune.marketplace.rest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.MplaceCustCareTotalUsageReportIds;

@Entity
@Table(name = "mplace_custcare_total_usage_report")
public class MplaceCustCareTotalUsageReport {

	@EmbeddedId
	MplaceCustCareTotalUsageReportIds mplaceCustCareTotalUsageReportIds;

	@Column(name = "TOTAL_CALLS_COUNT")
	private Integer totalCallsCount;

	@Column(name = "TOTAL_CALL_DURATION_IN_MINUTES")
	private Float totalCallDurationInMintes;

	/**
	 * @return the mplaceCustCareTotalUsageReportIds
	 */
	public MplaceCustCareTotalUsageReportIds getMplaceCustCareTotalUsageReportIds() {
		return mplaceCustCareTotalUsageReportIds;
	}

	/**
	 * @return the totalCallsCount
	 */
	public Integer getTotalCallsCount() {
		return totalCallsCount;
	}

	/**
	 * @return the totalCallDurationInMintes
	 */
	public Float getTotalCallDurationInMintes() {
		return totalCallDurationInMintes;
	}

	/**
	 * @param mplaceCustCareTotalUsageReportIds the
	 *                                          mplaceCustCareTotalUsageReportIds to
	 *                                          set
	 */
	public void setMplaceCustCareTotalUsageReportIds(
			MplaceCustCareTotalUsageReportIds mplaceCustCareTotalUsageReportIds) {
		this.mplaceCustCareTotalUsageReportIds = mplaceCustCareTotalUsageReportIds;
	}

	/**
	 * @param totalCallsCount the totalCallsCount to set
	 */
	public void setTotalCallsCount(Integer totalCallsCount) {
		this.totalCallsCount = totalCallsCount;
	}

	/**
	 * @param totalCallDurationInMintes the totalCallDurationInMintes to set
	 */
	public void setTotalCallDurationInMintes(Float totalCallDurationInMintes) {
		this.totalCallDurationInMintes = totalCallDurationInMintes;
	}

}
