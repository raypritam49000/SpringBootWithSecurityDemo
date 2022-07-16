package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;

import javax.persistence.Column;
/**
 * @author mayank
 *
 */
public class PromoService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "MSISDN", nullable = false)
	private String msisdn;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public PromoService(String msisdn) {
		super();
		this.msisdn = msisdn;
	}
	public PromoService() {}

	@Override
	public String toString() {
		return "PromoServiceMap [msisdn=" + msisdn + ", getMsisdn()=" + getMsisdn() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
