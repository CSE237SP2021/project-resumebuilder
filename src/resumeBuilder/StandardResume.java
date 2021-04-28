package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class StandardResume implements Resume {
	private ContactInformation contactInfo = new ContactInformation();
	private List<School> schools = new ArrayList<School>();
	private List<Job> jobs = new ArrayList<Job>();
	private List<String> skills = new ArrayList<String>();
	
	public StandardResume() {}
	
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
	
	public void addSkill(String skill) {
		skills.add(skill);
	}
	
	public List<String> getSkills() {
		return skills;
	}
	
	public boolean removeSkill(String skill) {
		return this.skills.remove(skill);
	}
	
	public void eraseSkills() {
		skills = new ArrayList<String>();
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
	
	public void printSkills() {
		System.out.println("Skills");
		System.out.println("-------------");
		
		for(String currentSkill : this.getSkills()) {
			System.out.println("* "+currentSkill);
		}
	}
	
	public void printStandardResume() {
		System.out.println();
		System.out.println("YOUR CURRENT STANDARD RESUME CONTENT: ");
		
		System.out.println();
		this.printContactInfo();
		
		System.out.println();
		this.printSchools();
		
		System.out.println();
		this.printJobs();
		
		System.out.println();
		this.printSkills();
		
		System.out.println();
		System.out.println("END OF CONTENT");
		
		System.out.println();
	}
}
