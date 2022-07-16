package com.telemune.marketplace.rest.entity.vo;

import javax.persistence.Lob;
/**
 * @author mayank
 *
 */
public class PromoServiceMapVO {

	
	
	
	private String scope;
	
	private String oldScope;
	
	private long count;
	
	private String msisdn;
	
	
    @Lob
    private byte[] data;

	public PromoServiceMapVO(){
		
	}
	
	public PromoServiceMapVO(String scope,long count) {
		this.scope=scope;
		this.count=count;
	}
	public PromoServiceMapVO(String scope, String msisdn) {
        this.scope = scope;
        this.msisdn = msisdn;
      
    }
	
	
	
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getOldScope() {
		return oldScope;
	}

	public void setOldScope(String oldScope) {
		this.oldScope = oldScope;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "PromoServiceMapVO [  scope= " + scope + ", count=" + count + ",msisdn= " +msisdn+ "oldScope= " + oldScope +"]";
	}

	
	
	
	
	
}
