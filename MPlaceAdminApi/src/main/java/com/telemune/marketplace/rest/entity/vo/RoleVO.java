package com.telemune.marketplace.rest.entity.vo;

import java.util.List;

public class RoleVO {

	private Integer roleId;

	private String roleName;

	private String description;

	private List<HttpLinksVO> httpLinkslst;

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the httpLinkslst
	 */
	public List<HttpLinksVO> getHttpLinkslst() {
		return httpLinkslst;
	}

	/**
	 * @param httpLinkslst the httpLinkslst to set
	 */
	public void setHttpLinkslst(List<HttpLinksVO> httpLinkslst) {
		this.httpLinkslst = httpLinkslst;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleVO [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description
				+ ", httpLinkslst=" + httpLinkslst + "]";
	}

}
