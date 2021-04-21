package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class FederalJob {
	String startDate;
	String endDate;
	String jobTitle;
	String GSLevel;
	String salary;
	String company;
	List<String> descriptions;
	
	public FederalJob(String jobTitle, String startDate, String endDate, String company, String GSLevel, String salary) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobTitle = jobTitle;
		this.company = company;
		this.GSLevel = GSLevel;
		this.salary = salary;
		this.descriptions = new ArrayList<String>();
	}
	
	public FederalJob() {}
	
	public void addBullet(String s) {
		this.descriptions.add(s);
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getGSLevel() {
		return this.GSLevel;
	}
	
	public void setGSLevel(String GSLevel) {
		this.GSLevel = GSLevel;
	}
	
	public String getSalary() {
		return this.salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public List<String> getDescriptions() {
		return this.descriptions;
	}
}
