package com.telemune.marketplace.rest.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_cdrs")
public class TransactionCdr {
	
	@Id
	@Column(name = "TRANSACTION_ID", nullable = false)
	private String transactionId;

	@Column(name = "MSISDN")
	private String msisdn;

	@Column(name = "FMSISDN", nullable = false)
	private String fmsisdn;

	@Column(name = "CREATE_DATE", nullable = false)
	private String createDate;

	@Column(name = "TYPE", nullable = false, columnDefinition = "A")
	private Integer type;

	@Column(name = "PRODUCT_CODE ", nullable = false, columnDefinition = "-1")
	private String productCode;

	@Column(name = "SERVICE_CHARGE", nullable = false, columnDefinition = "NA")
	private Float serviceCharge;

	@Column(name = "VOLUME ", nullable = false, columnDefinition = "NA")
	private Integer volume;

	@Column(name = "VALIDITY_DAYS ", nullable = false, columnDefinition = "NA")
	private Integer validityDays;

	@Column(name = "STATUS  ", nullable = false, columnDefinition = "NA")
	private String status;

	@Column(name = "SUB_TYPE  ", nullable = false, columnDefinition = "NA")
	private String subType;

	@Column(name = "PACK_ID  ", nullable = false, columnDefinition = "NA")
	private Integer packId;

	@Column(name = "VOLUME_TYPE  ", nullable = false, columnDefinition = "NA")
	private String volumeType;

	@Column(name = "VALIDITY_TYPE ", nullable = false, columnDefinition = "NA")
	private String validityType;

	@Column(name = "SHORT_CODE ", nullable = false, columnDefinition = "NA")
	private String shortCode;

	@Column(name = "LANGUAGE_ID  ", nullable = false, columnDefinition = "NA")
	private Integer languageId;

	@Column(name = "INTERFACE ", nullable = false, columnDefinition = "NA")
	private String Interface;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getFmsisdn() {
		return fmsisdn;
	}

	public void setFmsisdn(String fmsisdn) {
		this.fmsisdn = fmsisdn;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Float getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Float serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getValidityDays() {
		return validityDays;
	}

	public void setValidityDays(Integer validityDays) {
		this.validityDays = validityDays;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public Integer getPackId() {
		return packId;
	}

	public void setPackId(Integer packId) {
		this.packId = packId;
	}

	public String getVolumeType() {
		return volumeType;
	}

	public void setVolumeType(String volumeType) {
		this.volumeType = volumeType;
	}

	public String getValidityType() {
		return validityType;
	}

	public void setValidityType(String validityType) {
		this.validityType = validityType;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getInterface() {
		return Interface;
	}

	public void setInterface(String interface1) {
		Interface = interface1;
	}

}
