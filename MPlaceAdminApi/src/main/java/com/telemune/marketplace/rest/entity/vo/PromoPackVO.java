package com.telemune.marketplace.rest.entity.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telemune.marketplace.rest.entity.Others;
/**
 * @author mayank
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PromoPackVO {
	
	private Integer packId;
	
	private String status;
	
	private Integer packType;
	
	private String productCode;

	private String createDate;
	
	private String languageId;
	
	private String subType;
	
  // private Others other;
	
	private String other;
	
	private List<PromoPackDetail> promoPackDetails;
	
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

//	public Others getOther() {
//		return other;
//	}
//
//	public void setOther(Others other) {
//		this.other = other;
//	}

	public List<PromoPackDetail> getPromoPackDetails() {
		return promoPackDetails;
	}

	public void setPromoPackDetails(List<PromoPackDetail> promoPackDetails) {
		this.promoPackDetails = promoPackDetails;
	}

	public Integer getPackType() {
		return packType;
	}

	public void setPackType(Integer packType) {
		this.packType = packType;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public Integer getPackId() {
		return packId;
	}

	public void setPackId(Integer packId) {
		this.packId = packId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PromoPackVO [packId=" + packId + ", status=" + status + ", packType=" + packType + ", productCode="
				+ productCode + ", createDate=" + createDate + ", languageId=" + languageId + ", subType=" + subType
				+ ", other=" + other + ", promoPackDetails=" + promoPackDetails + "]";
	}
	
	

}
