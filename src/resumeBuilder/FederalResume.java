package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class FederalResume implements Resume{
	
	private ContactInformation contactInfo = new ContactInformation();
	private String citizenshipStatus = "";
	private String federalExperience = "";
	private String clearance = "";
	private String purposeStatement = "";
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
		return this.schools;
	}
	
	public boolean removeSchool(String schoolName) {
		for(School currentSchool : this.getSchools()) {
			String currentSchoolName = currentSchool.getSchoolName();
			if(currentSchoolName.equals(schoolName)) {
				this.schools.remove(currentSchool);
				return true;
			}
		}
		return false;
	}
	
	public void eraseSchools() {
		this.schools = new ArrayList<School>();
	}
	
	public void addActivity(Activity activity) {
		this.activities.add(activity);
	}
	
	public List<Activity> getActivities() {
		return this.activities;
	}
	
	public boolean removeActivity(String organization) {
		for(Activity currentActivity : this.getActivities()) {
			String currentOrganization = currentActivity.getOrganization();
			if(currentOrganization.equals(organization)) {
				this.activities.remove(currentActivity);
				return true;
			}
		}
		return false;
	}
	
	public void eraseActivities() {
		this.activities = new ArrayList<Activity>();
	}

	public void addFederalJob(FederalJob federalJob) {
		this.federalJobs.add(federalJob);		
	}

	public List<FederalJob> getFederalJobs() {
		return this.federalJobs;
	}
	
	public boolean removeFederalJob(String companyName) {
		for(FederalJob currentJob : this.getFederalJobs()) {
			String currentCompanyName = currentJob.getCompany();
			if(currentCompanyName.equals(companyName)) {
				this.federalJobs.remove(currentJob);
				return true;
			}
		}
		return false;
	}
	
	public void eraseFederalJobs() {
		this.federalJobs = new ArrayList<FederalJob>();
	}
	
	@Override
	public void addJob(Job job) {
		this.jobs.add(job);
	}

	@Override
	public List<Job> getJobs() {
		return this.jobs;
	}
	
	public boolean removeJob(String companyName) {
		for(Job currentJob : this.getJobs()) {
			String currentCompanyName = currentJob.getCompany();
			if(currentCompanyName.equals(companyName)) {
				this.jobs.remove(currentJob);
				return true;
			}
		}
		return false;
	}
	
	public void eraseJobs() {
		this.jobs = new ArrayList<Job>();
	}
	
	public void addSkill(String skill) {
		this.skills.add(skill);
	}
	
	public List<String> getSkills() {
		return this.skills;
	}
	
	public boolean removeSkill(String skill) {
		return this.skills.remove(skill);
	}
	
	public void eraseSkills() {
		this.skills = new ArrayList<String>();
	}
	
	public void addReference(References reference) {
		this.references.add(reference);
	}

	public List<References> getReferences() {
		return this.references;
	}
	
	public boolean removeReference(String name) {
		for(References currentReference : this.getReferences()) {
			String currentName = currentReference.getReferenceName();
			if(currentName.equals(name)) {
				this.references.remove(currentReference);
				return true;
			}
		}
		return false;
	}
	
	public void eraseReferences() {
		this.references = new ArrayList<References>();
	}

	public void printContactInfo() {
		System.out.println("Contact Information");
		System.out.println("-------------");
		
		System.out.println(this.contactInfo.toString());
	}
	
	public void printCitizenshipStatus() {
		System.out.println("Citizenship Status");
		System.out.println("-------------");
		System.out.print(this.citizenshipStatus);
	}
	
	public void printFederalExperience() {
		System.out.println("Government or Military Experience");
		System.out.println("-------------");
		System.out.print(this.federalExperience);
	}
	
	public void printClearance() {
		System.out.println("Clearance");
		System.out.println("-------------");
		System.out.print(this.clearance);
	}
	
	public void printPurposeStatement() {
		System.out.println("Purpose Statement");
		System.out.println("-------------");
		System.out.print(this.purposeStatement);
	}
	
	public void printSchools() {
		System.out.println("Academic History");
		System.out.println("-------------");
		
		for(School currentSchool : this.getSchools()) {
			System.out.println("* "+currentSchool.toString());
		}
	}
	
	public void printActivities() {
		System.out.println("Volunteer Work and Community Involvement");
		System.out.println("-------------");
		
		for(Activity currentActivity : this.getActivities()) {
			System.out.println("* "+currentActivity.toString());
		}
	}
	
	public void printJobs() {
		System.out.println("Regular Work Experience");
		System.out.println("-------------");
		
		for(Job currentJob : this.getJobs()) {
			System.out.println("* "+currentJob.toString());
		}
	}
	
	public void printFederalJobs() {
		System.out.println("Federal Work Experience");
		System.out.println("-------------");
		
		for(FederalJob currentFederalJob : this.getFederalJobs()) {
			System.out.println("* "+currentFederalJob.toString());
		}
	}
	
	public void printSkills() {
		System.out.println("Skills");
		System.out.println("-------------");
		
		for(String currentSkill : this.getSkills()) {
			System.out.println("* "+currentSkill);
		}
	}
	
	public void printReferences() {
		System.out.println("References");
		System.out.println("-------------");
		
		for(References currentReference : this.getReferences()) {
			System.out.println("* "+currentReference.toString());
		}
	}
	
	public void printFederalResume() {
		System.out.println();
		System.out.println("YOUR CURRENT FEDERAL RESUME CONTENT: ");
		
		System.out.println();
		this.printContactInfo();
		
		System.out.println();
		this.printCitizenshipStatus();
		
		System.out.println();
		this.printFederalExperience();
		
		System.out.println();
		this.printClearance();
		
		System.out.println();
		this.printPurposeStatement();
		
		System.out.println();
		this.printSchools();
		
		System.out.println();
		this.printActivities();
		
		System.out.println();
		this.printJobs();
		
		System.out.println();
		this.printFederalJobs();
		
		System.out.println();
		this.printSkills();
		
		System.out.println();
		this.printReferences();
		
		System.out.println();
		System.out.println("END OF CONTENT");
		System.out.println();
	}
}
