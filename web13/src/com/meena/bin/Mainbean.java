package com.meena.bin;

public class Mainbean
{
    private String returnUrl;
    private String applicationUuid;

    private String flag;

    private Payload payload;

    private String[] links;

    private Marketplace marketplace;

    private String type;

    private Creator creator;
   
  
    public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public void setApplicationUuid(String applicationUuid) {
		this.applicationUuid = applicationUuid;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public void setLinks(String[] links) {
		this.links = links;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public String getApplicationUuid() {
		return applicationUuid;
	}

	public String getFlag() {
		return flag;
	}

	public Payload getPayload() {
		return payload;
	}

	public String[] getLinks() {
		return links;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public String getType() {
		return type;
	}

	public Creator getCreator() {
		return creator;
	}

	
}