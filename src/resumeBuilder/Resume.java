package resumeBuilder;

import java.util.List;

public interface Resume {
	public void setContactInfo(ContactInformation contactInfo);
	public ContactInformation getContactInfo();
	
	public void addSchool(School school);
	public List<School> getSchools();
	public boolean removeSchool(String schoolName);
	public void eraseSchools();
	
	public void addJob(Job job);
	public List<Job> getJobs();
	public boolean removeJob(String companyName);
	public void eraseJobs();
}
