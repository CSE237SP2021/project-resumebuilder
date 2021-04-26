package resumeBuilder;

public class Project {
	String startDate;
	String endDate;
	String name;
	String summary;
	
	public Project(String name, String startDate, String endDate, String summary) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.summary = summary;
	}
	
	public Project() {}

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

	public String getProjectSummary() {
		return summary;
	}

	public void setProjectSummary(String summary) {
		this.summary = summary;
	}

	public String getProjectName() {
		return name;
	}

	public void setProjectName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name: "+this.name+", Time: "+this.startDate+"-"+this.endDate+", Summary: "+this.summary;

	}
}
