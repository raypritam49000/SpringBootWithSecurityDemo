package com.telemune.marketplace.rest.entity.vo;

public class MplaceCustCareCdrReportVO {

	private String MSISDN;

	private int call_duration;

	private String report_date;

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
	 * @return the call_duration
	 */
	public int getCall_duration() {
		return call_duration;
	}

	/**
	 * @param call_duration the call_duration to set
	 */
	public void setCall_duration(int call_duration) {
		this.call_duration = call_duration;
	}

	/**
	 * @return the report_date
	 */
	public String getReport_date() {
		return report_date;
	}

	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

	@Override
	public String toString() {
		return "MplaceCustCareCdrReportVO [MSISDN=" + MSISDN + ", call_duration=" + call_duration + ", report_date="
				+ report_date + "]";
	}

}
