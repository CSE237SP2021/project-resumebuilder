package resumeBuilder;

public class Certification {
	//Inspired https://www.indeed.com/career-advice/resumes-cover-letters/how-to-list-certifications-on-a-resume
	
	String title;
	String hostName;
	String dateEarned;
	String details; //e.g. expiration, relevant skills, etc.
	
	public Certification(String title, String hostName, String dateEarned, String details) {
		this.title = title;
		this.hostName = hostName;
		this.dateEarned = dateEarned;
		this.details = details;
	}
	
	public Certification() {}

	public String getDateEarned() {
		return dateEarned;
	}

	public void setDateEarned(String dateEarned) {
		this.dateEarned = dateEarned;
	}

	public String getCertificationTitle() {
		return title;
	}

	public void setCertificationTitle(String title) {
		this.title = title;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
