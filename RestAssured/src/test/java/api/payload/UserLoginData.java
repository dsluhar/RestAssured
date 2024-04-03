package api.payload;

public class UserLoginData {
	
	  String HostFIID;
	  String UserID;
	  String BusinessAppUserID;
	  String PartnerID;
	  String APIKey;
	
	public String getHostFIID() {
		return HostFIID;
	}
	public void setHostFIID(String hostFIID) {
		HostFIID = hostFIID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getBusinessAppUserID() {
		return BusinessAppUserID;
	}
	public void setBusinessAppUserID(String businessAppUserID) {
		BusinessAppUserID = businessAppUserID;
	}
	public String getPartnerID() {
		return PartnerID;
	}
	public void setPartnerID(String partnerID) {
		PartnerID = partnerID;
	}
	public String getAPIKey() {
		return APIKey;
	}
	public void setAPIKey(String aPIKey) {
		APIKey = aPIKey;
	}
}
