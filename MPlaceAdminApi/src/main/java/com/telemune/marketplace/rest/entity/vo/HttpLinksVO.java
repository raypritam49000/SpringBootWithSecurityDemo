package com.telemune.marketplace.rest.entity.vo;

public class HttpLinksVO {

	private Integer linkId;

	private String description;

	/**
	 * @return the linkId
	 */
	public Integer getLinkId() {
		return linkId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param linkId the linkId to set
	 */
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HttpLinksVO [linkId=" + linkId + ", description=" + description + "]";
	}

}
