package com.telemune.marketplace.rest.entity.vo;

import java.util.List;

public class PackPriority {
	
	private List<PackVO>  packLst;

	/**
	 * @return the packLst
	 */
	public List<PackVO> getPackLst() {
		return packLst;
	}

	/**
	 * @param packLst the packLst to set
	 */
	public void setPackLst(List<PackVO> packLst) {
		this.packLst = packLst;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackPriority [packLst=" + packLst + "]";
	}
	
	

}
