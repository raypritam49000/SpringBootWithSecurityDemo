package com.telemune.marketplace.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "marketplace_adminuser")
public class MarketPlaceAdminUser {

	@Id
	@Column(name = "USER_NAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOBILE_NUM")
	private String mobileNumber;

	@Column(name = "FIRST_LOGIN")
	private String firstLogin;

	@Column(name = "USER_TYPE", unique = true, nullable = false, columnDefinition = "0")
	private String userType;

	@Column(name = "CREATED_BY", unique = true, nullable = false, columnDefinition = "NA")
	private String createdBy;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ROLE_ID")
	private MarketPlaceRoles marketPlaceRoles;


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @return the firstLogin
	 */
	public String getFirstLogin() {
		return firstLogin;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return the marketPlaceRoles
	 */
	public MarketPlaceRoles getMarketPlaceRoles() {
		return marketPlaceRoles;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @param firstLogin the firstLogin to set
	 */
	public void setFirstLogin(String firstLogin) {
		this.firstLogin = firstLogin;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @param marketPlaceRoles the marketPlaceRoles to set
	 */
	public void setMarketPlaceRoles(MarketPlaceRoles marketPlaceRoles) {
		this.marketPlaceRoles = marketPlaceRoles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MarketPlaceAdminUser [username=" + username + ", password=" + password + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", firstLogin=" + firstLogin + ", userType=" + userType
				+ ", createdBy=" + createdBy + ", marketPlaceRoles=" + marketPlaceRoles + "]";
	}

}
