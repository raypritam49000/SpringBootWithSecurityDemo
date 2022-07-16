package com.telemune.marketplace.rest.entity;
import com.google.gson.Gson;
public class Others
{
	private Integer productCode;
	
	private  String packName;
	
	private String packDescription;
	
	private Integer amountRequired;
	
	private Integer priority;
	
	private Integer serviceCharge;
	
	private Integer volume;
	
	private String volumeType;
	
	private Integer validity;
	
	private String validityType;
	
	private String promptFile;
	
	private Integer packType;

	public Integer getProductCode() {
		return productCode;
	}

	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getPackDescription() {
		return packDescription;
	}

	public void setPackDescription(String packDescription) {
		this.packDescription = packDescription;
	}

	public Integer getAmountRequired() {
		return amountRequired;
	}

	public void setAmountRequired(Integer amountRequired) {
		this.amountRequired = amountRequired;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Integer serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getVolumeType() {
		return volumeType;
	}

	public void setVolumeType(String volumeType) {
		this.volumeType = volumeType;
	}

	public Integer getValidity() {
		return validity;
	}

	public void setValidity(Integer validity) {
		this.validity = validity;
	}

	public String getValidityType() {
		return validityType;
	}

	public void setValidityType(String validityType) {
		this.validityType = validityType;
	}

	public String getPromptFile() {
		return promptFile;
	}

	public void setPromptFile(String promptFile) {
		this.promptFile = promptFile;
	}

	public Integer getPackType() {
		return packType;
	}

	public void setPackType(Integer packType) {
		this.packType = packType;
	}

	@Override
	public String toString() {
		return "Others [productCode=" + productCode + ", packName=" + packName + ", packDescription=" + packDescription
				+ ", amountRequired=" + amountRequired + ", priority=" + priority + ", serviceCharge=" + serviceCharge
				+ ", volume=" + volume + ", volumeType=" + volumeType + ", validity=" + validity + ", validityType="
				+ validityType + ", promptFile=" + promptFile + ", packType=" + packType + "]";
	}
	
	
	public String toJson(Others other)
	{
		return new Gson().toJson(other);
		
	}
	

}
