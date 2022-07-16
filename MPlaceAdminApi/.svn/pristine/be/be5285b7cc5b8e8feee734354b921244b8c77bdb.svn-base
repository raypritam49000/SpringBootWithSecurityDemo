package com.telemune.marketplace.rest.entity;
/**
 * @author mayank
 *
 */
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.PromoPackIds;

@Entity
@Table(name = "promo_pack_details ")
public class PromoPack implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PromoPackIds promoPackIds;
		
   
	@Column(name = "Sub_Type", nullable = false)
	private String subType;
	
	@Column(name = "Product_Code", nullable = false)
	private String productCode;
	
	@Column(name = "Pack_Type", nullable = false)
	private Integer packType;
	
	@Column(name = "Status", nullable = false)
	private String status;
	
	@Column(name = "Create_Date", nullable = false)
	private Date createDate;
	
	@Column(name = "Other", nullable = false)
	private String other;
	
	
	public String getSubType() {
		return subType;
	}


	public void setSubType(String subType) {
		this.subType = subType;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getOther() {
		return other;
	}


	public void setOther(String other) {
		this.other = other;
	}


	public PromoPackIds getPromoPackIds() {
		return promoPackIds;
	}


	public void setPromoPackIds(PromoPackIds promoPackIds) {
		this.promoPackIds = promoPackIds;
	}


	public Integer getPackType() {
		return packType;
	}

	public void setPackType(Integer packType) {
		this.packType = packType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "PromoPack [promoPackIds=" + promoPackIds + ", packType=" + packType + ", status=" + status
				+ ", createDate=" + createDate + ", other=" + other + "]";
	}

  

	
	
}
