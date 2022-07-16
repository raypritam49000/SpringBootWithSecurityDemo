package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;

import javax.persistence.Column;
/**
 * @author mayank
 *
 */
public class PromoPackIds  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	@Column(name = "Language_Id", nullable = false)
	private String languageId;
	
	
	
	@Column(name = "Pack_Id", nullable = false)
    private Integer packId;

	
	
	
	public Integer getPackId() {
		return packId;
	}

	public void setPackId(Integer packId) {
		this.packId = packId;
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	
	public PromoPackIds(){
	}
	
	
	public PromoPackIds(Integer packId,String languageId) {
		this.languageId = languageId;
		this.packId = packId;
	}
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromoPackIds that = (PromoPackIds) o;

        if (!packId.equals(that.packId)) return false;
        return languageId.equals(that.languageId);
    }

	@Override
	public String toString() {
		return "PromoPackIds [ languageId=" + languageId + ", packId=" + packId +" getLanguage_id()="+ getLanguageId() + ", getPackId()=" + getPackId() + ", getClass()=" + getClass() + ", hashCode()="
						+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

	/*public PromoPackIds(String productCode,  String subType, Integer packId) {
		
		this.productCode = productCode;
		
		this.subType = subType;
		this.packId = packId;
	}*/

	
	
}
