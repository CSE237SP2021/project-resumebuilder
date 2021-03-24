package resumeBuilder;
import java.util.ArrayList;
import java.util.List;

public class Activity {
	String startDate;
	String endDate;
	String role;
	String organization;
	List<String> descriptions;
	
	public Activity(String start, String end, String role, String org) {
		startDate = start;
		endDate = end;
		this.role = role;
		organization = org;
		descriptions = new ArrayList<String>();
	}
	
	public void addDescription(String s) {
		descriptions.add(s);
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getRole() {
		return role;
	}

	public String getOrganization() {
		return organization;
	}
}