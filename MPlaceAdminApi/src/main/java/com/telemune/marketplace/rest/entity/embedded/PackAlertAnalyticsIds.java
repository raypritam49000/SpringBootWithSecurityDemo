package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PackAlertAnalyticsIds implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "alert_date")
	private Date alertDate;

	public PackAlertAnalyticsIds() {

	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the alertDate
	 */
	public Date getAlertDate() {
		return alertDate;
	}

	/**
	 * @param alertDate the alertDate to set
	 */
	public void setAlertDate(Date alertDate) {
		this.alertDate = alertDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackAlertAnalyticsIds [alertDate=" + alertDate + "]";
	}
	
	

}
