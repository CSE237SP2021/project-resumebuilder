package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class School {

	private String startDate;
	private String endDate;
	private String schoolName;
	private String schoolLocation;
	private double gpa;
	private List<String> honorsAwards; 
	
	public School (String startDate, String endDate, String schoolName, String schoolLocation, double gpa) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.schoolName = schoolName;
		this.schoolLocation = schoolLocation;
		this.gpa = gpa;
		this.honorsAwards = new ArrayList<String>();
	}
	
	
	public void addHonorsAwards (String honor_award) {
		this.honorsAwards.add(honor_award);
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
		return this.honorsAwards;
	}
	
}
