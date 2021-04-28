package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class UndergradResearchResume implements Resume {
	ContactInformation contactInfo = new ContactInformation();
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
		schools = new ArrayList<School>();
	}

	@Override
	public void addJob(Job job) {
		jobs.add(job);		
	}

	@Override
	public List<Job> getJobs() {
		return jobs;
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
		jobs = new ArrayList<Job>();
	}
	
	public void addActivity(Activity activity) {
		activities.add(activity);		
	}

	public List<Activity> getActivities() {
		return activities;
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
		activities = new ArrayList<Activity>();
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
		skills = new ArrayList<String>();
	}
	
	public void addCertification(Certification certification) {
		this.certifications.add(certification);
	}
	
	public List<Certification> getCertifications(){
		return this.certifications;
	}
	
	public boolean removeCertification(String certificationTitle) {
		for(Certification currentCertification : this.getCertifications()) {
			String currentCertTitle = currentCertification.getCertificationTitle();
			if(currentCertTitle.equals(certificationTitle)) {
				this.certifications.remove(currentCertification);
				return true;
			}
		}
		return false;
	}
	
	public void eraseCertifications() {
		this.certifications = new ArrayList<Certification>();
	}
	
	public void addMemberships(String membership) {
		this.memberships.add(membership);
	}
	
	public List<String> getMemberships() {
		return this.memberships;
	}
	
	public boolean removeMembership(String membership) {
		return this.memberships.remove(membership);
	}
	
	public void eraseMemberships() {
		this.memberships = new ArrayList<String>();
	}
	
	public void addConferences(String conference) {
		this.conferences.add(conference);
	}
	
	public List<String> getConferences() {
		return this.conferences;
	}
	
	public boolean removeConference(String conference) {
		return this.conferences.remove(conference);
	}
	
	public void eraseConferences() {
		this.conferences = new ArrayList<String>();
	}
	
	public void printContactInfo() {
		System.out.println("Contact Information");
		System.out.println("-------------");
		
		System.out.println(this.contactInfo.toString());
	}
	
	public void printSchools() {
		System.out.println("Academic History");
		System.out.println("-------------");
		
		for(School currentSchool : this.getSchools()) {
			System.out.println("* "+currentSchool.toString());
		}
	}
	
	public void printJobs() {
		System.out.println("Work Experience");
		System.out.println("-------------");
		
		for(Job currentJob : this.getJobs()) {
			System.out.println("* "+currentJob.toString());
		}
	}
	
	public void printActivities() {
		System.out.println("Activities");
		System.out.println("-------------");
		
		for(Activity currentActivity : this.getActivities()) {
			System.out.println("* "+currentActivity.toString());
		}
	}
	
	public void printSkills() {
		System.out.println("Skills");
		System.out.println("-------------");
		
		for(String currentSkill : this.getSkills()) {
			System.out.println("* "+currentSkill);
		}
	}
	
	public void printCertifications() {
		System.out.println("Certifications");
		System.out.println("-------------");
		
		for(Certification currentCertification : this.getCertifications()) {
			System.out.println("* "+currentCertification.toString());
		}
	}
	
	public void printMemberships() {
		System.out.println("Memberships");
		System.out.println("-------------");
		
		for(String currentMembership : this.getMemberships()) {
			System.out.println("* "+currentMembership);
		}
	}
	
	public void printConferences() {
		System.out.println("Conferences");
		System.out.println("-------------");
		
		for(String currentConference : this.getConferences()) {
			System.out.println("* "+currentConference);
		}
	}
	
	public void printUndergradResearchResume() {
		System.out.println();
		System.out.println("YOUR CURRENT UNDERGRADUATE RESEARCH RESUME CONTENT: ");
		
		System.out.println();
		this.printContactInfo();
		
		System.out.println();
		this.printSchools();
		
		System.out.println();
		this.printJobs();
		
		System.out.println();
		this.printActivities();
		
		System.out.println();
		this.printSkills();
		
		System.out.println();
		this.printCertifications();
		
		System.out.println();
		this.printMemberships();
		
		System.out.println();
		this.printConferences();
		
		System.out.println();
		System.out.println("END OF CONTENT");
		System.out.println();
	}
}
