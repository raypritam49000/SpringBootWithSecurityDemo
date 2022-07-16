package com.telemune.marketplace.rest.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.PackIds;

@Entity
@Table(name = "pack_master")
public class Pack implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PackIds packIds;

	@Column(name = "PACK_NAME", nullable = false)
	private String packName;

	/**
	 * @return the packIds
	 */
	public PackIds getPackIds() {
		return packIds;
	}

	/**
	 * @param packIds the packIds to set
	 */
	public void setPackIds(PackIds packIds) {
		this.packIds = packIds;
	}

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;

	@Column(name = "END_DATE", nullable = false)
	private Date endDate;

	@Column(name = "AMOUNT_REQUIRED", nullable = false)
	private Float amountRequired;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "PRIORITY", nullable = false,columnDefinition = "-99")
	private Integer priority;

	@Column(name = "sub_type", nullable = false)
	private String subType;

	@Column(name = "SUPER_PACK_TYPE", nullable = false,columnDefinition = "-1")
	private Integer subPackType;

	@Column(name = "REMINDER_TEMP_ID", nullable = false)
	private Integer reminderTempId;

	@Column(name = "IS_RENEW_ENABLE", nullable = false)
	private Integer isRenewEnable;

	@Column(name = "VIEW_ENABLE", nullable = false)
	private Integer viewEnable;

	@Column(name = "SPECIAL_PACK_TYPE", nullable = false ,columnDefinition = "-1")
	private Integer specialPackType;

	@Column(name = "PROMPT_FILE", nullable = false)
	private String promptFile;

	@Column(name = "other", nullable = false)
	private String other;

	// @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinColumn(name = "PACK_TYPE")
	/// private List<PackType> packType;

	@Column(name = "PACK_TYPE", nullable = false)
	private Integer packType;

	/**
	 * @return the packName
	 */
	public String getPackName() {
		return packName;
	}

	/**
	 * @param packName the packName to set
	 */
	public void setPackName(String packName) {
		this.packName = packName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the amountRequired
	 */
	public Float getAmountRequired() {
		return amountRequired;
	}

	/**
	 * @param amountRequired the amountRequired to set
	 */
	public void setAmountRequired(Float amountRequired) {
		this.amountRequired = amountRequired;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * @return the subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * @param subType the subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	/**
	 * @return the subPackType
	 */
	public Integer getSubPackType() {
		return subPackType;
	}

	/**
	 * @param subPackType the subPackType to set
	 */
	public void setSubPackType(Integer subPackType) {
		this.subPackType = subPackType;
	}

	/**
	 * @return the reminderTempId
	 */
	public Integer getReminderTempId() {
		return reminderTempId;
	}

	/**
	 * @param reminderTempId the reminderTempId to set
	 */
	public void setReminderTempId(Integer reminderTempId) {
		this.reminderTempId = reminderTempId;
	}

	/**
	 * @return the isRenewEnable
	 */
	public Integer getIsRenewEnable() {
		return isRenewEnable;
	}

	/**
	 * @param isRenewEnable the isRenewEnable to set
	 */
	public void setIsRenewEnable(Integer isRenewEnable) {
		this.isRenewEnable = isRenewEnable;
	}

	/**
	 * @return the viewEnable
	 */
	public Integer getViewEnable() {
		return viewEnable;
	}

	/**
	 * @param viewEnable the viewEnable to set
	 */
	public void setViewEnable(Integer viewEnable) {
		this.viewEnable = viewEnable;
	}

	/**
	 * @return the specialPackType
	 */
	public Integer getSpecialPackType() {
		return specialPackType;
	}

	/**
	 * @param specialPackType the specialPackType to set
	 */
	public void setSpecialPackType(Integer specialPackType) {
		this.specialPackType = specialPackType;
	}

	/**
	 * @return the promptFile
	 */
	public String getPromptFile() {
		return promptFile;
	}

	/**
	 * @param promptFile the promptFile to set
	 */
	public void setPromptFile(String promptFile) {
		this.promptFile = promptFile;
	}

	/**
	 * @return the other
	 */
	public String getOther() {
		return other;
	}

	/**
	 * @param other the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * @return the packType
	 */
	public Integer getPackType() {
		return packType;
	}

	/**
	 * @param packType the packType to set
	 */
	public void setPackType(Integer packType) {
		this.packType = packType;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pack [packIds=" + packIds + ", packName=" + packName + ", description=" + description + ", startDate="
				+ startDate + ", createDate=" + createDate + ", endDate=" + endDate + ", amountRequired="
				+ amountRequired + ", status=" + status + ", priority=" + priority + ", subType=" + subType
				+ ", subPackType=" + subPackType + ", reminderTempId=" + reminderTempId + ", isRenewEnable="
				+ isRenewEnable + ", viewEnable=" + viewEnable + ", specialPackType=" + specialPackType
				+ ", promptFile=" + promptFile + ", other=" + other + ", packType=" + packType + "]";
	}

	
}