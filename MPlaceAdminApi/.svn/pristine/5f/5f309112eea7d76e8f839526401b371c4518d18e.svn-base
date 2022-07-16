package com.telemune.marketplace.rest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.MplaceCustcareRetReportCurrentIds;

@Entity
@Table(name = "mplace_custcare_ret_report_current")
public class MplaceCustcareRetReportCurrent {

	@EmbeddedId
	MplaceCustcareRetReportCurrentIds mplaceCustcareRetReportCurrentIds;

	@Column(name = "TOTAL_CALLS_COUNT")
	private Integer totalCallsCount;

	@Column(name = "TOTAL_UNIQUE_CALL_COUNT")
	private Integer totalUniqueCallCount;

	@Column(name = "CALL_BACK_COUNTS")
	private Integer callBackCounts;

	@Column(name = "CALL_BACK_PERCENTAGE")
	private Double callBackPercentage;

	/**
	 * @return the mplaceCustcareRetReportCurrentIds
	 */
	public MplaceCustcareRetReportCurrentIds getMplaceCustcareRetReportCurrentIds() {
		return mplaceCustcareRetReportCurrentIds;
	}

	/**
	 * @return the totalCallsCount
	 */
	public Integer getTotalCallsCount() {
		return totalCallsCount;
	}

	/**
	 * @return the totalUniqueCallCount
	 */
	public Integer getTotalUniqueCallCount() {
		return totalUniqueCallCount;
	}

	/**
	 * @return the callBackCounts
	 */
	public Integer getCallBackCounts() {
		return callBackCounts;
	}

	/**
	 * @return the callBackPercentage
	 */
	public Double getCallBackPercentage() {
		return callBackPercentage;
	}

	/**
	 * @param mplaceCustcareRetReportCurrentIds the
	 *                                          mplaceCustcareRetReportCurrentIds to
	 *                                          set
	 */
	public void setMplaceCustcareRetReportCurrentIds(
			MplaceCustcareRetReportCurrentIds mplaceCustcareRetReportCurrentIds) {
		this.mplaceCustcareRetReportCurrentIds = mplaceCustcareRetReportCurrentIds;
	}

	/**
	 * @param totalCallsCount the totalCallsCount to set
	 */
	public void setTotalCallsCount(Integer totalCallsCount) {
		this.totalCallsCount = totalCallsCount;
	}

	/**
	 * @param totalUniqueCallCount the totalUniqueCallCount to set
	 */
	public void setTotalUniqueCallCount(Integer totalUniqueCallCount) {
		this.totalUniqueCallCount = totalUniqueCallCount;
	}

	/**
	 * @param callBackCounts the callBackCounts to set
	 */
	public void setCallBackCounts(Integer callBackCounts) {
		this.callBackCounts = callBackCounts;
	}

	/**
	 * @param callBackPercentage the callBackPercentage to set
	 */
	public void setCallBackPercentage(Double callBackPercentage) {
		this.callBackPercentage = callBackPercentage;
	}

}