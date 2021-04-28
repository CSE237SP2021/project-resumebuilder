package resumeBuilder;
//import java.util.ArrayList;
//import java.util.List;


public class References {
	String referenceName;
	String referenceEmail;
	String referencePhoneNumber;
	String referenceOrganization;
	
	public References() {}
	
	public void addReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	
	public void addReferenceEmail(String referenceEmail) {
		this.referenceEmail = referenceEmail;
	}
	
	public void addReferencePhoneNumber(String referencePhoneNumber) {
		this.referencePhoneNumber = referencePhoneNumber;
	}
	
	public void addReferenceOrganization(String referenceOrganization) {
		this.referenceOrganization = referenceOrganization;
	}
	
	public String getReferenceName() {
		return this.referenceName;
	}
	
	public String getReferenceEmail() {
		return this.referenceEmail;
	}
	
	public String getReferencePhoneNumber() {
		return this.referencePhoneNumber;
	}
	
	public String getReferenceOrganization() {
		return this.referenceOrganization;
	}
	
	public String toString() {
		return "Name: "+this.referenceName+", Organization: "+this.referenceOrganization+", Phone #: "+this.referencePhoneNumber+", Email: "+this.referenceEmail;
	}
}
