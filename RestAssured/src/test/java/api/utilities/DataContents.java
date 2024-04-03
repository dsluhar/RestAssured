package api.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class DataContents {
	
	protected static String vPDFContents005BA1;
	protected static String vRTSRemoteAttachment;
	protected static String vRTSAttachment;
	protected static String vRemoteSignBodyPayLoad;
	
	protected static String vDataXML;
	protected static String vXMLAttachment;
	protected static String vXMLRemoteAttachment;
	protected static String vXMLRemoteSignBody;
	
	@Test
	public void testCSV1() throws IOException, CsvException {

		CSVReader reader1 = new CSVReader(new FileReader("./BodyContentFiles/PDFContents.csv"));

		List<String[]> data1 = reader1.readAll();
		
		 for (String[] row : data1) {
			 vRTSRemoteAttachment=row[0];
		 }
	}
	@Test
	public void ReadFromTextFile() throws IOException {

		Path filepath = Paths.get("./BodyContentFiles/", "RTSAttachment.txt");
		
		String contentRTSAttachment = Files.readString(filepath);
		
		//System.out.println("String Content is : > " +contentRTSAttachment);
		
		vRTSAttachment = contentRTSAttachment;
		
		FileReader reader2 = new FileReader("./BodyContentFiles/RTSRemoteSignBody.txt");
		BufferedReader file2 = new BufferedReader(reader2);
		
		String line2;
		
		while ((line2 = file2.readLine()) != null) {
			vRemoteSignBodyPayLoad = vRemoteSignBodyPayLoad + line2;
			vRemoteSignBodyPayLoad = vRemoteSignBodyPayLoad.replace("null", "");
		}
		reader2.close();
		
		Path filepath1 = Paths.get("./BodyContentFiles/", "PDFTemplate005BA1.txt");
		
			String contentPDFTemplate005BA1 = Files.readString(filepath1);
			
			vPDFContents005BA1 = contentPDFTemplate005BA1;

		Path XMLDataFilePC01 = Paths.get("./BodyContentFiles/", "DataFileDLFi3PC01.txt");
		
			String contentXMLDataFilePC01 = Files.readString(XMLDataFilePC01);
			
			vDataXML = contentXMLDataFilePC01;
			
		Path filepathXMLAttachment = Paths.get("./BodyContentFiles/", "XMLAttachment.txt");
			
			String contentXMLAttachment = Files.readString(filepathXMLAttachment);
				
			vXMLAttachment = contentXMLAttachment;	
			
		Path filepathXMLRemoteAttachment = Paths.get("./BodyContentFiles/", "XML-RemoteAttachment.txt");
			
			String contentRemoteXMLAttachment = Files.readString(filepathXMLRemoteAttachment);
				
			vXMLRemoteAttachment = contentRemoteXMLAttachment;				
			
		Path filepathXMLRemoteSign = Paths.get("./BodyContentFiles/", "XMLRemoteSignBody.txt");
			
			String contentXMLRemoteSign = Files.readString(filepathXMLRemoteSign);
				
			vXMLRemoteSignBody = contentXMLRemoteSign;							
	}
}
