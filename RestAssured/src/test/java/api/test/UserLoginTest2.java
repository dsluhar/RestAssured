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
import api.payload.RTSDocumentData;
import api.payload.UserLoginData;
import api.utilities.DataContents;
import api.utilities.DataProviderLogin2;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserLoginTest2<RTSCreate> extends api.utilities.DataContents {
	
	static UserLoginData UserPayLoad ;
	static RTSDocumentData RTSDataPayLoad ;
	protected static String vToken=null ;
	protected static String vHostSessionId=null;
	protected static String vDocID=null;
	
//	@Test(dataProvider="LoginData", dataProviderClass=dataProviderLogin2.class )
//	public void TestPrint(String FIID, String UserName, String Password)
//	{
//		System.out.println("FIID = " +FIID + "UserName = " +UserName + "Password = " +Password);
//		System.out.println("        ......          ");
//	}
	
	@BeforeClass
	public static String UserLoginTest()
	{
		UserPayLoad = new UserLoginData();
		
		UserPayLoad.setHostFIID("dlfi3");
		UserPayLoad.setUserID("itadmin@testfi2.onmicrosoft.com");
		UserPayLoad.setBusinessAppUserID("itadmin@testfi2.onmicrosoft.com");
		UserPayLoad.setPartnerID("tesign");
		UserPayLoad.setAPIKey("P@ssword1");			
		Response response = UserEndPoints_RTS.UserLogin(UserPayLoad);
		return vToken = response.headers().getValue("access-token");
	}
	
	@Test(priority=1)
	public void TestUserLogin()
	{
		Response response = UserEndPoints_RTS.UserLogin(UserPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority=3)
	public void TestRTSCreate() {
		Response response = UserEndPoints_RTS.RTSCreate();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		vHostSessionId = response.jsonPath().get("HostSessionId");
	}
	
	@Test(priority=5)
	public void TestRTSDocument() {
		
		RTSDataPayLoad = new RTSDocumentData();
		
		RTSDataPayLoad.setShortName("005BA1");
		RTSDataPayLoad.setLongName("005BA1");
		RTSDataPayLoad.setDescription("005BA1005BA1005BA1");
		RTSDataPayLoad.setPDFFileContents("vPDFContents_005BA1");
		
		Response response = UserEndPoints_RTS.RTSDocument(RTSDataPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
	}
    
	@Test(priority=7, enabled=true)
	public void TestrtsAttachment() {
		System.out.println(" Before vRTSattachment :" + DataContents.vRTSAttachment);
		Response response = UserEndPoints_RTS.rtsAttachment();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}	
//	@Test
//	public void Print1() {
//		System.out.println("value of remote attachment string is : > " + vRTSRemoteAttachment1);
//	}
	
	@Test(priority=8, enabled=true)
	public void TestRtsRemoteAttachment() {
		Response response = UserEndPoints_RTS.rtsRemoteAttachment();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}	
	
	@Test(priority=12)
	public void TestCommit() {
		Response response = UserEndPoints_RTS.dCommit();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}	
	
	@Test(priority=14, enabled=true)
	public void TestrtsRemoteSign() {
		Response response = UserEndPoints_RTS.rtsRemoteSign();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority=15, enabled=false)
	public void TestRTSHostSessionId() {
		Response response = UserEndPoints_RTS.rtsHostSessionId();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		vDocID = response.jsonPath().get("DocID");
		System.out.println("document Id is :+ " +vDocID);
	}
	
	@Test(priority=16, enabled=false)
	public void TestRTSDocumentId() {
		Response response = UserEndPoints_RTS.rtsDocumentId();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}	
}
