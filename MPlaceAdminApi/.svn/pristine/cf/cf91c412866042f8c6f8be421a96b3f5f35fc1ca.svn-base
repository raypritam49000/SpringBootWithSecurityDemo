package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;

import javax.persistence.Column;

public class PackIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "PACK_ID", nullable = false)
	private Integer packId;
	@Column(name = "LANGUAGE_ID ", nullable = false)
	private String languageId;

	public PackIds() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackTypeIds [packId=" + packId + ", language_id=" + languageId + ", getLanguage_id()="
				+ getLanguageId() + ", getPackId()=" + getPackId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


	/**
	 * @return the description
	 */

	public PackIds(Integer packType, String languageId) {

		this.packId = packType;
		this.languageId = languageId;

	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PackIds that = (PackIds) o;

		if (!packId.equals(that.packId))
			return false;
		return languageId.equals(that.languageId);
	}

	/**
	 * @return the packId
	 */
	public Integer getPackId() {
		return packId;
	}

	/**
	 * @param packId the packId to set
	 */
	public void setPackId(Integer packId) {
		this.packId = packId;
	}

	/**
	 * @return the languageId
	 */
	public String getLanguageId() {
		return languageId;
	}

	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	
	

}
