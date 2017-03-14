package com.meena.bin;

public class Order {
	private String pricingDuration;
	private String[] items;

    private String addonOfferingCode;

    private String[] customAttributes;

    private String editionCode;
	
    public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public void setAddonOfferingCode(String addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}

	public void setCustomAttributes(String[] customAttributes) {
		this.customAttributes = customAttributes;
	}

	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	public String getPricingDuration() {
		return pricingDuration;
	}

	public String[] getItems() {
		return items;
	}

	public String getAddonOfferingCode() {
		return addonOfferingCode;
	}

	public String[] getCustomAttributes() {
		return customAttributes;
	}

	public String getEditionCode() {
		return editionCode;
	}

	
    	

}
