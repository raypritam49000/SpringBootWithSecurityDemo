package com.telemune.marketplace.rest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.PackAlertAnalyticsIds;

@Entity
@Table(name = "pack_alert_analytics")
public class PackAlertAnalytics {

	@EmbeddedId
	private PackAlertAnalyticsIds packAlertAnalyticsIds;

	@Column(name = "alert_sent")
	private Integer alertSent;

	@Column(name = "pack_purchased")
	private Integer packPurchased;

	/**
	 * @return the packAlertAnalyticsIds
	 */
	public PackAlertAnalyticsIds getPackAlertAnalyticsIds() {
		return packAlertAnalyticsIds;
	}

	/**
	 * @param packAlertAnalyticsIds the packAlertAnalyticsIds to set
	 */
	public void setPackAlertAnalyticsIds(PackAlertAnalyticsIds packAlertAnalyticsIds) {
		this.packAlertAnalyticsIds = packAlertAnalyticsIds;
	}

	/**
	 * @return the alertSent
	 */
	public Integer getAlertSent() {
		return alertSent;
	}

	/**
	 * @param alertSent the alertSent to set
	 */
	public void setAlertSent(Integer alertSent) {
		this.alertSent = alertSent;
	}

	/**
	 * @return the packPurchased
	 */
	public Integer getPackPurchased() {
		return packPurchased;
	}

	/**
	 * @param packPurchased the packPurchased to set
	 */
	public void setPackPurchased(Integer packPurchased) {
		this.packPurchased = packPurchased;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackAlertAnalytics [packAlertAnalyticsIds=" + packAlertAnalyticsIds + ", alertSent=" + alertSent
				+ ", packPurchased=" + packPurchased + "]";
	}

}
