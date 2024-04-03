package api.endpoints;

// https://qa.immesign.com/TEAASP/esignapi/v1/login   											POST
// https://qa.immesign.com/TEAASP/esignapi/v1/session/rts/create								POST
// https://qa.immesign.com/TEAASP/esignapi/v1/session/{{HostSessionId}}/rts/document			POST
// https://qa.immesign.com/TeAASP/esignapi/v1/session/{{HostSessionId}}/rts/attachment			POST
// https://qa.immesign.com/TEAASP/esignapi/v1/session/{{HostSessionId}}/rts/remoteattachment	POST
// https://qa.immesign.com/TEAASP/esignapi/v1/session/{{HostSessionId}}/commit					PUT
// https://qa.immesign.com/TEAASP/esignapi/v1/remote/{{HostSessionId}}  -Remote Signature		PUT

public class Routes {

	public static String base_url = "https://qa.immesign.com/TEAASP/esignapi/v1" ;
	
	public static String rtsEPLogin = base_url + "/login" ;
	public static String rtsCreate = base_url + "/session/rts/create" ;
	public static String rtsDocument = base_url + "/session/{HostSessionId}/rts/document" ;
	public static String rtsAttachment = base_url + "/session/{HostSessionId}/rts/attachment" ;
	public static String rtsRemoteAttachment = base_url + "/session/{HostSessionId}/rts/remoteattachment" ;
    public static String rtsSendtoRemote = base_url + "/remote/{HostSessionId}" ;
    public static String rtsEPHostSessionId = base_url + "/session/{HostSessionId}" ;
    public static String rtsEPDocumentId = base_url + "/session/{HostSessionId}/document/{DocID}" ;
    public static String rtsAuditDownload = base_url + "/session/{HostSessionId}/audit" ;
	public static String rtsCommit = base_url + "/session/{HostSessionId}/commit" ;
	public static String rtsArchive = base_url + "/session/{HostSessionId}/archive" ;
	
	public static String XMLEPLogin = base_url + "/login" ;
	public static String XMLCreate = base_url + "/session/xml/create" ;
	public static String XMLAttachment = base_url + "/session/{HostSessionId}/xml/attachment" ;
	public static String XMLRemoteAttachment = base_url + "/session/{HostSessionId}/xml/remoteattachment" ;
	public static String XMLSendtoRemote = base_url + "/remote/{HostSessionId}" ;
    public static String XMLEPHostSessionId = base_url + "/session/{HostSessionId}" ;
    public static String XMLEPDocumentId = base_url + "/session/{HostSessionId}/document/{DocID}" ;
    public static String XMLAuditDownload = base_url + "/session/{HostSessionId}/audit" ;
	public static String XMLCommit = base_url + "/session/{HostSessionId}/commit" ;
	public static String XMLArchive = base_url + "/session/{HostSessionId}/archive" ;
	
}
