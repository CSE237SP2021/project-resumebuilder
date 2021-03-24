package resumeBuilder;
import java.util.ArrayList;
import java.util.List;


public class Work {
	String startDate;
	String endDate;
	String jobTitle;
	String company;
	List<String> descriptions;
	
	public Work(String job, String start, String end, String company) {
		startDate = start;
		endDate = end;
		jobTitle = job;
		this.company = company;
		descriptions = new ArrayList<String>();
	}
	
	public void addBullet(String s) {
		descriptions.add(s);
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	 
}