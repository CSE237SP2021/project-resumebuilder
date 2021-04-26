package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class UndergradResearchResume implements Resume {
	ContactInformation contactInfo;
	private List<School> schools = new ArrayList<School>();
	private List<Job> jobs = new ArrayList<Job>();
	private List<Activity> activities = new ArrayList<Activity>();
	private List<String> skills = new ArrayList<String>();
	private List<Certification> certifications = new ArrayList<Certification>();
	private List<String> memberships = new ArrayList<String>();
	private List<String> conferences = new ArrayList<String>();
	
	public UndergradResearchResume () {}

	@Override
	public void setContactInfo(ContactInformation contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public ContactInformation getContactInfo() {
		return this.contactInfo;
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
	
	public void addActivity(Activity activity) {
		activities.add(activity);		
	}

	public List<Activity> getActivities() {
		return activities;
	}
	
	public void addSkill(String skill) {
		this.skills.add(skill);
	}
	
	public List<String> getSkills() {
		return this.skills;
	}
	
	public void addCertification(Certification certification) {
		this.certifications.add(certification);
	}
	
	public List<Certification> getCertifications(){
		return this.certifications;
	}
	
	public void addMemberships(String membership) {
		this.memberships.add(membership);
	}
	
	public List<String> getMemberships() {
		return this.memberships;
	}
	
	public void addConferences(String conference) {
		this.conferences.add(conference);
	}
	
	public List<String> getConferences() {
		return this.conferences;
	}
	

}
