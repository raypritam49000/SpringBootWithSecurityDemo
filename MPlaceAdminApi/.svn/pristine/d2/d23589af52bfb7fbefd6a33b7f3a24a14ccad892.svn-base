package com.telemune.marketplace.rest.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.WhiteBlack;

@Entity
@Table(name = "system_list_master")
public class WhiteBlackList implements Serializable {
	/**
	 * @author mayank
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private WhiteBlack whiteBlack;
	
	@Column(name = "TYPE", nullable = false)
	private String type;
	
	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;
	
	public WhiteBlack getWhiteBlack() {
		return whiteBlack;
	}

	public void setWhiteBlack(WhiteBlack whiteBlack) {
		this.whiteBlack = whiteBlack;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "WhiteBlackList [whiteBlack=" + whiteBlack + ", type=" + type + ", createDate=" + createDate + "]";
	}


	

	
	
}
