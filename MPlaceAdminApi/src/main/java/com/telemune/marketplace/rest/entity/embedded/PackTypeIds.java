package com.telemune.marketplace.rest.entity.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PackTypeIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "PACK_TYPE", nullable = false)
	private Integer  packTypeId;
	@Column(name = "LANGUAGE_ID ", nullable = false)
	private String languageId;
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
	public PackTypeIds(){
	}
	public PackTypeIds(Integer id, String languageId) {
	    this.languageId=languageId;
	    this.packTypeId=id;
	}
	    
	


	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackTypeIds that = (PackTypeIds) o;

        if (!packTypeId.equals(that.packTypeId)) return false;
        return languageId.equals(that.languageId);
    }
	/**
	 * @return the packTypeId
	 */
	public Integer getPackTypeId() {
		return packTypeId;
	}
	/**
	 * @param packTypeId the packTypeId to set
	 */
	public void setPackTypeId(Integer packTypeId) {
		this.packTypeId = packTypeId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackTypeIds [packTypeId=" + packTypeId + ", languageId=" + languageId + "]";
	}

	
}

