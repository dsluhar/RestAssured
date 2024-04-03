package api.payload;

import io.restassured.http.Header;

public class RTSDocumentData {
	
	String ShortName;
	String LongName;
	String Description;
	String PDFFileContents;
	
	public String getShortName() {
		return ShortName;
	}
	public void setShortName(String shortName) {
		ShortName = shortName;
	}
	public String getLongName() {
		return LongName;
	}
	public void setLongName(String longName) {
		LongName = longName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPDFFileContents() {
		return PDFFileContents;
	}
	public void setPDFFileContents(String pDFFileContents) {
		PDFFileContents = pDFFileContents;
	}
		
}

