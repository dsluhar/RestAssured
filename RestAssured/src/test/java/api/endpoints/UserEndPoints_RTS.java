package api.endpoints;
import static io.restassured.RestAssured.given;

import api.test.UserLoginTest_RTS;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints_RTS extends UserLoginTest_RTS {

	public static Response UserLogin(api.payload.UserLoginData Payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.body(Payload)
		
		.when()
			.post(Routes.rtsEPLogin);
		
		return response;
	}
	
	// EndPoint Processing for RTS Sessions
	public static Response RTSCreate()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.body("{}")
			
			.when()
				.post(Routes.rtsCreate);
			
			return response;
	}
	
	public static Response RTSDocument(api.payload.RTSDocumentData Payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.header("access-token",vToken)
		.pathParam("HostSessionId", vHostSessionId)
		.body(Payload)
		
		.when()
			.post(Routes.rtsDocument);
		
		return response;
	}
	public static Response rtsAttachment()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				.body(vRTSAttachment)
				
			.when()
			.post(Routes.rtsAttachment);

		return response;
	}
	public static Response rtsRemoteAttachment()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				.body(vRTSRemoteAttachment)
				
			.when()
			.post(Routes.rtsRemoteAttachment);

		return response;
	}
	public static Response dCommit()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				
			.when()
				.put(Routes.rtsCommit);

		return response;
	}

	public static Response rtsRemoteSign()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				.body(vRemoteSignBodyPayLoad)
				
			.when()
				.put(Routes.rtsSendtoRemote);
		
		return response;
	}
	
	public static Response rtsHostSessionId()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				
			.when()
				.get(Routes.rtsEPHostSessionId);
		
		return response;
	}
	public static Response rtsDocumentId()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				.pathParam("DocID", vDocID)
				
			.when()
				.get(Routes.rtsEPDocumentId);
		
		return response;
	}
	// EndPoint Processing for XML Sessions
	public static Response XMLCreate()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.body(vDataXML)
			
			.when()
				.post(Routes.XMLCreate);
			
			return response;
	}
}
