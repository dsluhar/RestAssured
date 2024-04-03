package api.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVDataTest {
	
	protected static String vUname1;
	protected static String vPasword1;
	public static String vRTSRemoteAttachment1 ;

	@Test
	public void testCSV() throws IOException, CsvException {

		CSVReader reader = new CSVReader(new FileReader("./test_data.csv"));
		
		List<String[]> data = reader.readAll();
		
		 for (String[] row : data) {

//			 	String vUname1 = row[0];
//	            String vPassword1  = row[1];
			 
			 	vUname1=row[0];
			 	vPasword1=row[1];
	            
	            System.out.println("User Name is := > " +vUname1);
	            System.out.println("Passowrd is := > " +vPasword1);
		 }
	}
		 
//			public String testCSV1() throws IOException, CsvException {
//
//			CSVReader reader1 = new CSVReader(new FileReader("./PDFContents.csv"));
//
//			List<String[]> data1 = reader1.readAll();
//			
//			 for (String[] row : data1) {
//
//				 vRTSRemoteAttachment1=row[0];
//		            
//	            System.out.println("vRemote Attachment is := > " +vRTSRemoteAttachment1);
//			 }
//			 return vRTSRemoteAttachment1;
//	}
}