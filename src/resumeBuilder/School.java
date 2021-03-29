package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class School {

	private String startDate;
	private String endDate;
	private String schoolName;
	private String schoolLocation;
	private double gpa;
	private List<String> honors_awards; //Current config only includes honors and awards associated with a particular School obj
	
	public School (String startDate, String endDate, String schoolName, String schoolLocation, double gpa) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.schoolName = schoolName;
		this.schoolLocation = schoolLocation;
		this.gpa = gpa;
		this.honors_awards = new ArrayList<String>();
	}
	
	public void addHonorsAwards (String honor_award) {
		this.honors_awards.add(honor_award);
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
	
	public String getSchoolName() {
		return this.schoolName;
	}
	
	public String getSchoolLocation() {
		return this.schoolLocation;
	}
	
	public double getGPA() {
		return this.gpa;
	}
	
	public List<String> getHonorsAwards() {
		return this.honors_awards;
	}
}
