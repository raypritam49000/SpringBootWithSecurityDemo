package com.telemune.marketplace.rest.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.telemune.marketplace.rest.entity.embedded.TransferValidityConfigIds;

@Entity
@Table(name = "transfer_validity_config")
public class TransferValidityConfig {

	@EmbeddedId
	private TransferValidityConfigIds transferValidityConfigIds;

	@Column(name = "VALIDITY_DAYS")
	private Integer validityDays;

	@CreationTimestamp
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;

	/**
	 * @return the validityDays
	 */
	public Integer getValidityDays() {
		return validityDays;
	}

	/**
	 * @param validityDays the validityDays to set
	 */
	public void setValidityDays(Integer validityDays) {
		this.validityDays = validityDays;
	}

	/**
	 * @return the createDate
	 */
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the transferValidityConfigIds
	 */
	public TransferValidityConfigIds getTransferValidityConfigIds() {
		return transferValidityConfigIds;
	}

	/**
	 * @param transferValidityConfigIds the transferValidityConfigIds to set
	 */
	public void setTransferValidityConfigIds(TransferValidityConfigIds transferValidityConfigIds) {
		this.transferValidityConfigIds = transferValidityConfigIds;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransferValidityConfig [transferValidityConfigIds=" + transferValidityConfigIds + ", validityDays="
				+ validityDays + ", createDate=" + createDate + "]";
	}

}
