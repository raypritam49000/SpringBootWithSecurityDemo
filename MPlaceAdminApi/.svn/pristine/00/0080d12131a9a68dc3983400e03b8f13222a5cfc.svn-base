package com.telemune.marketplace.rest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.MplaceCustCareCdrReportIds;

@Entity
@Table(name = "mplace_custcare_cdr_report")
public class MplaceCustCareCdrReport {

	@EmbeddedId
	MplaceCustCareCdrReportIds mplaceCustCareCdrReportIds;

	@Column(name = "MSISDN")
	private String MSISDN;

	@Column(name = "CALL_DURATION")
	private int callDuration;

	/**
	 * @return the mplaceCustCareCdrReportIds
	 */
	public MplaceCustCareCdrReportIds getMplaceCustCareCdrReportIds() {
		return mplaceCustCareCdrReportIds;
	}

	/**
	 * @param mplaceCustCareCdrReportIds the mplaceCustCareCdrReportIds to set
	 */
	public void setMplaceCustCareCdrReportIds(MplaceCustCareCdrReportIds mplaceCustCareCdrReportIds) {
		this.mplaceCustCareCdrReportIds = mplaceCustCareCdrReportIds;
	}

	/**
	 * @return the mSISDN
	 */
	public String getMSISDN() {
		return MSISDN;
	}

	/**
	 * @param mSISDN the mSISDN to set
	 */
	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	/**
	 * @return the callDuration
	 */
	public int getCallDuration() {
		return callDuration;
	}

	/**
	 * @param callDuration the callDuration to set
	 */
	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}

}
