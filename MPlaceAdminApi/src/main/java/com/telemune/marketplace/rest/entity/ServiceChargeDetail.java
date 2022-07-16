package com.telemune.marketplace.rest.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service_charge_detail")
public class ServiceChargeDetail {
	
	@Id
	@Column(name = "PACK_ID")
	private  Integer packId;
	
	@Column(name = "PRODUCT_CODE", nullable = false)
	private String  productCode ;
	
	@Column(name = "SERVICE_CHARGE", nullable = false)
	private String  serviceCharge;
	
	@Column(name = "VOLUME", nullable = false)
	private Integer volume;
	
	@Column(name = "CREATE_DATE ")
	private  Date  createDate;
	
	@Column(name = "STATUS", nullable = false, columnDefinition = "A")
	private String  status;
	
	@Column(name = "VALIDITY_DAYS", nullable = false , columnDefinition = "-1")
	private Integer  validityDays;
	
	@Column(name = "VOLUME_TYPE", nullable = false, columnDefinition = "NA")
	private String  volumeType;
	
	@Column(name = "VALIDITY_TYPE", nullable = false,  columnDefinition = "NA")
	private String  validityType;

	/**
	 * @return the packId
	 */
	public Integer getPackId() {
		return packId;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @return the serviceCharge
	 */
	public String getServiceCharge() {
		return serviceCharge;
	}

	/**
	 * @return the volume
	 */
	public Integer getVolume() {
		return volume;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the validityDays
	 */
	public Integer getValidityDays() {
		return validityDays;
	}

	/**
	 * @return the volumeType
	 */
	public String getVolumeType() {
		return volumeType;
	}

	/**
	 * @return the validityType
	 */
	public String getValidityType() {
		return validityType;
	}

	/**
	 * @param packId the packId to set
	 */
	public void setPackId(Integer packId) {
		this.packId = packId;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @param serviceCharge the serviceCharge to set
	 */
	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param validityDays the validityDays to set
	 */
	public void setValidityDays(Integer validityDays) {
		this.validityDays = validityDays;
	}

	/**
	 * @param volumeType the volumeType to set
	 */
	public void setVolumeType(String volumeType) {
		this.volumeType = volumeType;
	}

	/**
	 * @param validityType the validityType to set
	 */
	public void setValidityType(String validityType) {
		this.validityType = validityType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceChargeDetail [packId=" + packId + ", productCode=" + productCode + ", serviceCharge="
				+ serviceCharge + ", volume=" + volume + ", createDate=" + createDate + ", status=" + status
				+ ", validityDays=" + validityDays + ", volumeType=" + volumeType + ", validityType=" + validityType
				+ "]";
	}
	
	

}
