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

public class PopulateDataFromCSV {
	
	protected static String vName, vCity, vSal;
	protected static String vStudData, vStudData2;
	
	@Test(priority=1, alwaysRun=true)
	public void testCSV1() throws IOException, CsvException {

		CSVReader reader1 = new CSVReader(new FileReader("./src/DataContents.csv"));
		reader1.skip(1);  // skip first Row(header Row) in CSV
		List<String[]> data1 = reader1.readAll();
		
		System.out.println("Data From CSV Set is :");
		 for (String[] row : data1) {
			 vName=row[0];
			 vCity=row[1];
			 vSal=row[2];
			 System.out.println(vName + " "+ vCity + " " + vSal);
		 }
		 reader1.close();
	}
	
	@Test(priority=2, enabled=true)
	public void ReadFromTextFile() throws IOException {

		Path filepath = Paths.get("./src/", "ReadStudentData.txt");
		System.out.println();
		System.out.println("Complete Student Data02 From Text File is :  ");
		//vStudData = Files.readString(filepath);
		System.out.println();
		System.out.println(vStudData);
	}
	
	@Test(priority=3, enabled=true)
	public void ReadStudDataLineByLine() throws IOException {	
	
		FileReader reader2 = new FileReader("./src/ReadStudentData.txt");
		BufferedReader file2 = new BufferedReader(reader2);
		
		String line2;
			System.out.println("Student Data03 from TextFile, Line By Line is : ");
		while ((line2 = file2.readLine()) != null) {
			vStudData2 = line2;
			System.out.println(vStudData2);
		}
		reader2.close();
	}
}