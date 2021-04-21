package resumeBuilder;

import java.util.ArrayList;
import java.util.List;

public class TechnicalResume implements Resume {
	
	ContactInformation contactInfo;
	private List<School> schools = new ArrayList<School>();
	private List<Job> jobs = new ArrayList<Job>();
	private List<Project> projects = new ArrayList<Project>();
	private List<String> softwareSkills = new ArrayList<String>();
	private List<String> programmingLanguageSkills = new ArrayList<String>();
	private List<String> softSkills = new ArrayList<String>();
	private List<Certification> certifications = new ArrayList<Certification>();

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

	public void addSoftSkill(String softSkill){
		softSkills.add(softSkill);
	}
	
	public List<String> getSoftSkills(){
		return softSkills;
	}
	
	public void addCertification(Certification certification) {
		certifications.add(certification);
	}
	
	public List<Certification> getCertifications(){
		return certifications;
	}
}
