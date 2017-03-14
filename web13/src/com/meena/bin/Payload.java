package com.meena.bin;

public class Payload {
	private Order order;

    private Addoninstance addonInstance;

    private Company company;

    private Account account;

    private Addonbinding addonBinding;

    private Configuration configuration;

    private Notice notice;

    private User user;
    
    public void setOrder(Order order) {
		this.order = order;
	}

	public void setAddonInstance(Addoninstance addonInstance) {
		this.addonInstance = addonInstance;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setAddonBinding(Addonbinding addonBinding) {
		this.addonBinding = addonBinding;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public Addoninstance getAddonInstance() {
		return addonInstance;
	}

	public Company getCompany() {
		return company;
	}

	public Account getAccount() {
		return account;
	}

	public Addonbinding getAddonBinding() {
		return addonBinding;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public Notice getNotice() {
		return notice;
	}

	public User getUser() {
		return user;
	}

	

  
}
