package api.test;

import static io.restassured.RestAssured.given;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Routes;
import api.endpoints.UserEndPoints_RTS;
import api.endpoints.UserEndPoints_XML;
import api.payload.RTSDocumentData;
import api.payload.UserLoginData;
import api.utilities.DataContents;
import api.utilities.DataProviderLogin2;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserLoginTest_XML extends api.utilities.DataContents {
	
	static UserLoginData UserPayLoad ;
	protected static String vToken=null ;
	protected static String vHostSessionId=null;
	protected static String vDocID=null;
	
	@BeforeClass
	public static String UserLoginTest()
	{
		UserPayLoad = new UserLoginData();
		
		UserPayLoad.setHostFIID("TestLD");
		UserPayLoad.setUserID("itadmin@testfi2.onmicrosoft.com");
		UserPayLoad.setBusinessAppUserID("itadmin@testfi2.onmicrosoft.com");
		UserPayLoad.setPartnerID("XP");
		UserPayLoad.setAPIKey("P@ssword1");			
		Response response = UserEndPoints_XML.UserLogin(UserPayLoad);
		return vToken = response.headers().getValue("access-token");
	}
	
	@Test(priority=1)
	public void TestUserLogin()
	{
		Response response = UserEndPoints_XML.UserLogin(UserPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority=3)
	public void TestXMLCreate() {
		Response response = UserEndPoints_XML.XMLCreate();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		vHostSessionId = response.jsonPath().get("HostSessionId");
	}
	
	@Test(priority=3, enabled=false)
	public void TestXMLAttachment() {
		Response response = UserEndPoints_XML.XMLAttachment();  //comment added by dilip - XMLAttachment.txt file to be rectified 
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}
	@Test(priority=12)
	public void TestCommit() {
		Response response = UserEndPoints_XML.dCommit();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}	
}
