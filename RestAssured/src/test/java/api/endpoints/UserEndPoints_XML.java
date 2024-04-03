package api.endpoints;
import static io.restassured.RestAssured.given;

import api.test.UserLoginTest_RTS;
import api.test.UserLoginTest_XML;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints_XML extends UserLoginTest_XML {

	public static Response UserLogin(api.payload.UserLoginData Payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.body(Payload)
		
		.when()
			.post(Routes.XMLEPLogin);
		
		return response;
	}
	
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
	
	public static Response XMLAttachment()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				.body(vXMLAttachment)
			
			.when()
				.post(Routes.XMLAttachment);
			
			return response;
	}
	
	public static Response XMLRemoteAttachment()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				.body(vXMLRemoteAttachment)
				
			.when()
			.post(Routes.XMLRemoteAttachment);

		return response;
	}
	
	public static Response dCommit()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				
			.when()
				.put(Routes.XMLCommit);

		return response;
	}
	
	public static Response XMLRemoteSign()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.header("access-token",vToken)
				.pathParam("HostSessionId", vHostSessionId)
				.body(vXMLRemoteSignBody)
				
			.when()
				.put(Routes.XMLSendtoRemote);
		
		return response;
	}

}
