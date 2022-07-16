package com.telemune.marketplace.rest.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Manjeet Kumar
 *
 */
@Entity
@Table(name = "charging_logs")
public class ChargingLogs implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRANSACTION_ID", nullable = false)
	private String transactionId;

	@Column(name = "MSISDN", nullable = false)
	private String msisdn;

	@Column(name = "FMSISDN", nullable = false)
	private String FMSISDN;

	@Column(name = "CREATE_DATE", nullable = false)
	private String createDate;

	@Column(name = "TYPE", nullable = false)
	private Integer type;

	@Column(name = "PRODUCT_CODE", nullable = false)
	private String productCode;

	@Column(name = "SERVICE_CHARGE", nullable = false)
	private Float serviceCharge;

	@Column(name = "VOLUME", nullable = false)
	private Integer volume;

	@Column(name = "VALIDITY_DAYS", nullable = false)
	private Integer validityDays;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "SUB_TYPE", nullable = false)
	private String subType;

	@Column(name = "RESPONSE_STATUS", nullable = false)
	private Integer reponseStatus;

	@Column(name = "PACK_ID", nullable = false)
	private Long packId;

	@Column(name = "VALIDITY_TYPE", nullable = false)
	private String validityType;

	@Column(name = "VOLUME_TYPE", nullable = false)
	private String volumeType;

	@Column(name = "SHORT_CODE", nullable = false)
	private String shortCode;
	
	@Column(name = "LANGUAGE_ID", nullable = false)
	private String languageId;



	@Column(name = "Interface", nullable = false)
	private String userInterface;

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the fMSISDN
	 */
	public String getFMSISDN() {
		return FMSISDN;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	

	/**
	 * @return the volume
	 */
	public Integer getVolume() {
		return volume;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the validityDays
	 */
	public Integer getValidityDays() {
		return validityDays;
	}

	/**
	 * @return the subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * @return the reponseStatus
	 */
	public Integer getReponseStatus() {
		return reponseStatus;
	}
	
	/**
	 * @return the serviceCharge
	 */
	public Float getServiceCharge() {
		return serviceCharge;
	}
	/**
	 * @return the packId
	 */
	public Long getPackId() {
		return packId;
	}

	/**
	 * @return the validityType
	 */
	public String getValidityType() {
		return validityType;
	}

	/**
	 * @return the volumeType
	 */
	public String getVolumeType() {
		return volumeType;
	}

	/**
	 * @return the shortCode
	 */
	public String getShortCode() {
		return shortCode;
	}

	/**
	 * @return the languageId
	 */
	public String getLanguageId() {
		return languageId;
	}
	/**
	 * @return the userInterface
	 */
	public String getUserInterface() {
		return userInterface;
	}

	/**
	 * @param fMSISDN the fMSISDN to set
	 */
	public void setFMSISDN(String fMSISDN) {
		FMSISDN = fMSISDN;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @param serviesCharge the serviesCharge to set
	 */
	
	public void setServiceCharge(Float serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	/**
	 * @param validityDays the validityDays to set
	 */
	public void setValidityDays(Integer validityDays) {
		this.validityDays = validityDays;
	}

	/**
	 * @param subType the subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param reponseStatus the reponseStatus to set
	 */
	public void setReponseStatus(Integer reponseStatus) {
		this.reponseStatus = reponseStatus;
	}

	/**
	 * @param packId the packId to set
	 */
	public void setPackId(Long packId) {
		this.packId = packId;
	}

	/**
	 * @param validityType the validityType to set
	 */
	public void setValidityType(String validityType) {
		this.validityType = validityType;
	}

	/**
	 * @param volumeType the volumeType to set
	 */
	public void setVolumeType(String volumeType) {
		this.volumeType = volumeType;
	}

	/**
	 * @param shortCode the shortCode to set
	 */
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	/**
	 * @param languageId the languageId to set
	 */

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	/**
	 * @param userInterface the userInterface to set
	 */
	public void setUserInterface(String userInterface) {
		this.userInterface = userInterface;
	}

}
