package com.telemune.marketplace.rest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.PackTypeIds;

@Entity
@Table(name = "pack_type_master ")
public class PackType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PackTypeIds packTypeIds;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackType [packTypeIds=" + packTypeIds + ", STATUS=" + STATUS + ", packTypeName=" + packTypeName
				+ ", parentPackType=" + parentPackType + ", parallelPackEnable=" + parallelPackEnable
				+ ", packTypePrompt=" + packTypePrompt + ", priority=" + priority + ", basePackType=" + basePackType
				+ ", superPackType=" + superPackType + ", description=" + description + "]";
	}

	@Column(name = "STATUS", nullable = false, columnDefinition = "A")
	private String STATUS;

	@Column(name = "PACK_TYPE_NAME")
	private String packTypeName;
	
	@Column(name = "PARENT_PACK_TYPE", nullable = false, columnDefinition = "0")
	private Integer parentPackType;

	@Column(name = "PARALLEL_PACK_ENABLE")
	private Integer parallelPackEnable;

	@Column(name = "PACK_TYPE_PROMPT_FILE", nullable = false, columnDefinition = "0")
	private String packTypePrompt;

	
	@Column(name = "PRIORITY", nullable = false, columnDefinition = "1")
	private Integer priority;

	@Column(name = "BASE_PACK_TYPE", nullable = false, columnDefinition = "NA")
	private String basePackType;

	@Column(name = "SUPER_PACK_TYPE", nullable = false, columnDefinition = "-1")
	private Integer superPackType;
	
	@Column (name= "DESCRIPTION")
	private String description;
	

	/**
	 * @return the sTATUS
	 */
	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	/**
	 * @return the packTypeName
	 */
	public String getPackTypeName() {
		return packTypeName;
	}

	

	/**
	 * @param packTypeName the packTypeName to set
	 */
	public void setPackTypeName(String packTypeName) {
		this.packTypeName = packTypeName;
	}

	/**
	 * @return the parentPackType
	 */
	public Integer getParentPackType() {
		return parentPackType;
	}

	/**
	 * @param parentPackType the parentPackType to set
	 */
	public void setParentPackType(Integer parentPackType) {
		this.parentPackType = parentPackType;
	}

	/**
	 * @return the parallelPackEnable
	 */
	public Integer getParallelPackEnable() {
		return parallelPackEnable;
	}

	/**
	 * @param parallelPackEnable the parallelPackEnable to set
	 */
	public void setParallelPackEnable(Integer parallelPackEnable) {
		this.parallelPackEnable = parallelPackEnable;
	}

	

	/**
	 * @return the packTypePrompt
	 */
	public String getPackTypePrompt() {
		return packTypePrompt;
	}

	/**
	 * @param packTypePrompt the packTypePrompt to set
	 */
	public void setPackTypePrompt(String packTypePrompt) {
		this.packTypePrompt = packTypePrompt;
	}

	
	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


	/**
	 * @return the packTypeIds
	 */
	public PackTypeIds getPackTypeIds() {
		return packTypeIds;
	}

	/**
	 * @param packTypeIds the packTypeIds to set
	 */
	public void setPackTypeIds(PackTypeIds packTypeIds) {
		this.packTypeIds = packTypeIds;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * @return the basePackType
	 */
	public String getBasePackType() {
		return basePackType;
	}

	/**
	 * @param basePackType the basePackType to set
	 */
	public void setBasePackType(String basePackType) {
		this.basePackType = basePackType;
	}

	/**
	 * @return the superPackType
	 */
	public Integer getSuperPackType() {
		return superPackType;
	}

	/**
	 * @param superPackType the superPackType to set
	 */
	public void setSuperPackType(Integer superPackType) {
		this.superPackType = superPackType;
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

	

}
