package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class FederalResume implements Resume{
	
	private ContactInformation contactInfo;
	private String citizenshipStatus;
	private String federalExperience;
	private String clearance;
	private String purposeStatement;
	private List<School> schools = new ArrayList<School>();
	private List<Activity> activities = new ArrayList<Activity>();
	private List<FederalJob> federalJobs = new ArrayList<FederalJob>();
	private List<Job> jobs = new ArrayList<Job>();
	private List<String> skills = new ArrayList<String>();
	private List<References> references = new ArrayList<References>();
	
	public FederalResume() {}

	@Override
	public void setContactInfo(ContactInformation contactInfo) {
		this.contactInfo = contactInfo;		
	}

	@Override
	public ContactInformation getContactInfo() {
		return this.contactInfo;
	}
	
	public void setCitizenshipStatus(String citizenshipStatus) {
		this.citizenshipStatus = citizenshipStatus;
	}
	
	public String getCitizenshipStatus() {
		return this.citizenshipStatus;
	}
	
	public void setFederalExperience(String federalExperience) {
		this.federalExperience = federalExperience;
	}
	
	public String getFederalExperience() {
		return this.federalExperience;
	}
	
	public void setClearance(String clearance) {
		this.clearance = clearance;
	}
	
	public String getClearance() {
		return this.clearance;
	}
	
	public void setPurposeStatement(String purposeStatement) {
		this.purposeStatement = purposeStatement;
	}
	
	public String getPurposeStatement() {
		return this.purposeStatement;
	}

	@Override
	public void addSchool(School school) {
		this.schools.add(school);
	}

	@Override
	public List<School> getSchools() {
		return schools;
	}
	
	public void addActivity(Activity activity) {
		this.activities.add(activity);
	}
	
	public List<Activity> getActivity() {
		return this.activities;
	}

	public void addFederalJob(FederalJob federalJob) {
		federalJobs.add(federalJob);		
	}

	public List<FederalJob> getFederalJobs() {
		return federalJobs;
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
		this.skills.add(skill);
	}
	
	public List<String> getSkills() {
		return this.skills;
	}
	
	public void addReference(References reference) {
		this.references.add(reference);
	}

	public List<References> getReferences() {
		return this.references;
	}

}
