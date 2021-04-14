package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class StandardResume implements Resume {
	private ContactInformation contactInfo;
	private List<School> schools = new ArrayList<School>();
	private List<Job> jobs = new ArrayList<Job>();
	private List<String> skills = new ArrayList<String>();
	
	public StandardResume() {
		
	}
	
	@Override
	public void setContactInfo(ContactInformation contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public ContactInformation getContactInfo() {
		return contactInfo;
	}

	@Override
	public void addSchool(School school) {
		schools.add(school);
	}

	@Override
	public List<School> getSchools() {
		return schools;
	}

	@Override
	public void addJob(Job job) {
		jobs.add(job);
	}

	@Override
	public List<Job> getJobs() {
		return jobs;
	}
	
	public void addSkill(String skill) {
		skills.add(skill);
	}
	
	public List<String> getSkills() {
		return skills;
	}

}
