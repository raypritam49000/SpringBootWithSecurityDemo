package com.telemune.marketplace.rest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.RevenueReportIds;

@Entity
@Table(name = "revenue_report")
public class RevenueReport {

	@EmbeddedId
	private RevenueReportIds revenueReportIds;

	@Column(name = "charge_count")
	private Integer  chargeCount;

	@Column(name = "charge_amount")
	private Integer  chargeAmount;
	
	

	/**
	 * @return the revenueReportIds
	 */
	public RevenueReportIds getRevenueReportIds() {
		return revenueReportIds;
	}

	/**
	 * @return the chargeCount
	 */
	public Integer getChargeCount() {
		return chargeCount;
	}

	/**
	 * @return the chargeAmount
	 */
	public Integer getChargeAmount() {
		return chargeAmount;
	}

	/**
	 * @param revenueReportIds the revenueReportIds to set
	 */
	public void setRevenueReportIds(RevenueReportIds revenueReportIds) {
		this.revenueReportIds = revenueReportIds;
	}

	/**
	 * @param chargeCount the chargeCount to set
	 */
	public void setChargeCount(Integer chargeCount) {
		this.chargeCount = chargeCount;
	}

	/**
	 * @param chargeAmount the chargeAmount to set
	 */
	public void setChargeAmount(Integer chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RevenueReport [revenueReportIds=" + revenueReportIds + ", chargeCount=" + chargeCount
				+ ", chargeAmount=" + chargeAmount + "]";
	}

	

}
