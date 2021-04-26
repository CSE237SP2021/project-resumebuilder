package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class TechnicalResume implements Resume {
	
	ContactInformation contactInfo = new ContactInformation();
	private List<School> schools = new ArrayList<School>();
	private List<Job> jobs = new ArrayList<Job>();
	private List<Project> projects = new ArrayList<Project>();
	private List<String> softwareSkills = new ArrayList<String>();
	private List<String> programmingLanguageSkills = new ArrayList<String>();
	private List<Certification> certifications = new ArrayList<Certification>();

	public TechnicalResume() {}
	
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
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
	public List<Project> getProjects(){
		return projects;
	}
	
	public void addSoftwareSkill(String softwareSkill){
		softwareSkills.add(softwareSkill);
	}
	
	public List<String> getSoftwareSkills(){
		return softwareSkills;
	}
	
	public void addProgrammingLanguageSkill(String programmingLanguageSkill){
		programmingLanguageSkills.add(programmingLanguageSkill);
	}
	
	public List<String> getProgrammingLanguageSkills(){
		return programmingLanguageSkills;
	}
	
	public void addCertification(Certification certification) {
		certifications.add(certification);
	}
	
	public List<Certification> getCertifications(){
		return certifications;
	}
	
	public void printContactInfo() {
		System.out.println("Contact Information");
		System.out.println("-------------");
		
		this.contactInfo.toString();
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
	
	public void printProjects() {
		System.out.println("Projects");
		System.out.println("-------------");
		
		for(Project currentProject : this.getProjects()) {
			System.out.println("* "+currentProject.toString());
		}
	}
	
	public void printSoftwareSkills() {
		System.out.println("Software Skills");
		System.out.println("-------------");
		
		for(String currentSkill : this.getSoftwareSkills()) {
			System.out.println("* "+currentSkill);
		}
	}
	
	public void printProgrammingLanguageSkills() {
		System.out.println("Programming Language Skills");
		System.out.println("-------------");
		
		for(String currentSkill : this.getProgrammingLanguageSkills()) {
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
	
	public void printTechnicalResume() {
		System.out.println();
		System.out.println("YOUR CURRENT TECHNICAL RESUME CONTENT: ");
		
		System.out.println();
		this.printContactInfo();
		
		System.out.println();
		this.printSchools();
		
		System.out.println();
		this.printJobs();
		
		System.out.println();
		this.printProjects();
		
		System.out.println();
		this.printSoftwareSkills();
		
		System.out.println();
		this.printProgrammingLanguageSkills();
		
		System.out.println();
		this.printCertifications();
		
		System.out.println();
		System.out.println("END OF CONTENT");
		System.out.println();
	}
	
}
