package me.model;

public class ObjResponse 
{
private boolean success;
private String acctIdentifier;

public ObjResponse(boolean success, String accountIdentifier) {
	
	this.success = success;
	this.acctIdentifier = accountIdentifier;
}
public boolean getSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public String getAccountIdentifier() {
	return acctIdentifier;
}
public void setAccountIdentifier(String accountIdentifier) {
	this.acctIdentifier = accountIdentifier;
}


}
