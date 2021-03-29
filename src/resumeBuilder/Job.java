package resumeBuilder;
import java.util.ArrayList;
import java.util.List;

//TODO uncomment descriptions stuff once continuous prompt is set up in Menu
public class Job {
	String startDate;
	String endDate;
	String jobTitle;
	String company;
	//List<String> descriptions;
	
	public Job(String job, String start, String end, String company) {
		startDate = start;
		endDate = end;
		jobTitle = job;
		this.company = company;
		//descriptions = new ArrayList<String>();
	}
	
	public Job() {}
	
	/*
	public void addBullet(String s) {
		descriptions.add(s);
	}
	*/

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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	/*
	public List<String> getDescriptions() {
		return descriptions;
	}
	*/	 
}