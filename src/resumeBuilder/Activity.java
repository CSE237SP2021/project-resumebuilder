package resumeBuilder;
import java.util.ArrayList;
import java.util.List;

public class Activity {
	String startDate;
	String endDate;
	String role;
	String organization;
	List<String> descriptions = new ArrayList<String>();
	
	public Activity(String start, String end, String role, String org) {
		startDate = start;
		endDate = end;
		this.role = role;
		organization = org;
	}
	
	public Activity() {}
	
	public void addDescription(String s) {
		descriptions.add(s);
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}
	
	public String toString() {
		return "Organization: "+this.organization+", Role: "+this.role+", Time: "+this.startDate+"-"+this.endDate+", Descriptions: "+this.descriptions.toString();

	}
}