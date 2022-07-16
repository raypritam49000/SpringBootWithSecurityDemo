package com.telemune.marketplace.rest.entity.embedded;

import java.io.Serializable;

import javax.persistence.Column;

public class TransferValidityConfigIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MIN_VOLUME")
	private Integer minVolume;

	@Column(name = "MAX_VOLUME")
	private Integer maxVolume;

	@Column(name = "TYPE")
	private Integer type;

	public TransferValidityConfigIds() {
	}

	public TransferValidityConfigIds(Integer minVolume, Integer maxVolume, Integer type) {
		this.minVolume = minVolume;
		this.maxVolume = maxVolume;
		this.type = type;

	}

	/**
	 * @return the minVolume
	 */
	public Integer getMinVolume() {
		return minVolume;
	}

	/**
	 * @param minVolume the minVolume to set
	 */
	public void setMinVolume(Integer minVolume) {
		this.minVolume = minVolume;
	}

	/**
	 * @return the maxVolume
	 */
	public Integer getMaxVolume() {
		return maxVolume;
	}

	/**
	 * @param maxVolume the maxVolume to set
	 */
	public void setMaxVolume(Integer maxVolume) {
		this.maxVolume = maxVolume;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TransferValidityConfigIds that = (TransferValidityConfigIds) o;

		if (!minVolume.equals(that.minVolume))
			return false;
		if (!maxVolume.equals(that.maxVolume))
			return false;
		return type.equals(that.type);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransferValidityConfigIds [minVolume=" + minVolume + ", maxVolume=" + maxVolume + ", type=" + type
				+ "]";
	}

}
