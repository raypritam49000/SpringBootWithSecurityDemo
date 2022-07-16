package com.telemune.marketplace.rest.entity.vo;


public class MplaceCustCareProductPurchaseReportVO {
	
	
	private String reportDate;
	
	private String productCode;	

	private String productName;
         
    private String totalCount;

	/**
	 * @return the reportDate
	 */
	public final String getReportDate() {
		return reportDate;
	}

	/**
	 * @return the productCode
	 */
	public final String getProductCode() {
		return productCode;
	}

	/**
	 * @return the productName
	 */
	public final String getProductName() {
		return productName;
	}

	/**
	 * @return the totalCount
	 */
	public final String getTotalCount() {
		return totalCount;
	}

	/**
	 * @param reportDate the reportDate to set
	 */
	public final void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public final void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @param productName the productName to set
	 */
	public final void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public final void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
