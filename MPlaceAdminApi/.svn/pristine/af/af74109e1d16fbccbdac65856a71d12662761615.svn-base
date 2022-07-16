package com.telemune.marketplace.rest.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "web_access")
public class WebAccess {
	
	@Column(name = "HTTP_ID", nullable = false)
	private Integer httpId;
	
	@Column(name = "ROlE_ID", nullable = false)
	private Integer  roleId;
	
	@Column(name = "IS_ALLOWED", nullable = false, columnDefinition = "A")
	private String isAllowed;

	/**
	 * @return the httpId
	 */
	public Integer getHttpId() {
		return httpId;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @return the isAllowed
	 */
	public String getIsAllowed() {
		return isAllowed;
	}

	/**
	 * @param httpId the httpId to set
	 */
	public void setHttpId(Integer httpId) {
		this.httpId = httpId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @param isAllowed the isAllowed to set
	 */
	public void setIsAllowed(String isAllowed) {
		this.isAllowed = isAllowed;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WebAccess [httpId=" + httpId + ", roleId=" + roleId + ", isAllowed=" + isAllowed + "]";
	}

}
