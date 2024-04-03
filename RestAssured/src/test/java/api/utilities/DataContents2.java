package api.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class DataContents2 {
	
	//static String vLocalPDFFileContents = "\";
	
	//public static String vRemoteSignBodyPayLoad = "{\"RedirectURL\": \"\",  \"RedirectDelay\": 0,  \"RemotePartyDetails\": [ { \"FullName\": \"John Smith\", \"Email\": \"dilip.luhar@kinective.io\", \"Details\": \"\", \"RemoteAuthenticationType\": \"Email\",      \"RemoteSigningOrder\": 0 }, { \"FullName\": \"Johnny's Rockets\", \"Email\": \"dilip.luhar@kinective.io\", \"Details\": \"\", \"RemoteAuthenticationType\": \"Email\",\"RemoteSigningOrder\": 1 }],  \"MessageDetails\": {\"SenderEmail\": \"employee1@immonline.com\",\"CCEmails\": [ \"\"],\"TemplateName\": \"Default Template\", \"Subject\": \"Test Subject\",\"Message\": \"Test Message\" }}";
   
	//public static String vRTSAttachment = "{ \"AttachmentName\": \"RTS-Attach1\",  \"PDFFileContents\":" +vLocalPDFFileContents+"\"" +"," +"\"DocumentIndex\": 0,  \"Vendor\": \"\",  \"Parties\": [ { \"Action\": \"Sign\", \"FullName\": \"V Saxena\"}]}";

  // public static String vRTSRemoteAttachment = "{ \"AttachmentTemplateName\": \"RemoteRTSAttach1\", \"RemotePartyDetails\": [{ \"DocumentIndex\": \"0\",\"FullName\": \"John Smith\"}]}";

	protected static String vRTSRemoteAttachment;
	
	protected static String vRTSAttachment;
	
	protected static String vRemoteSignBodyPayLoad ;
	
	@Test
	public void testCSV1() throws IOException, CsvException {

		CSVReader reader1 = new CSVReader(new FileReader("./PDFContents.csv"));

		List<String[]> data1 = reader1.readAll();
		
		 for (String[] row : data1) {
			 vRTSRemoteAttachment=row[0];
		 }
	}
	@Test
	public void ReadFromTextFile() throws IOException {
//		FileReader reader = new FileReader("./PDFContents.txt");
//		int character;
//		while ((character = reader.read()) != -1) {
//			vLocalPDFFileContents = (char)(character);
//			System.out.println("Strinig is : > " +(char)character);
//		}
		FileReader reader1 = new FileReader("./PDFContents.txt");
		BufferedReader file = new BufferedReader(reader1);
		
		String line;
		
		while ((line = file.readLine()) != null) {
			vRTSAttachment = vRTSAttachment + line;
			vRTSAttachment = vRTSAttachment.replace("null", "");
		}

		reader1.close();

		FileReader reader2 = new FileReader("./RemoteSignBody.txt");
		BufferedReader file2 = new BufferedReader(reader2);
		
		String line2;
		
		while ((line2 = file2.readLine()) != null) {
			vRemoteSignBodyPayLoad = vRemoteSignBodyPayLoad + line2;
			vRemoteSignBodyPayLoad = vRemoteSignBodyPayLoad.replace("null", "");
		}
		reader2.close();

	}
}
