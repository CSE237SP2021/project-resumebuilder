package resumeBuilder;

import java.util.Scanner;

public class TechnicalResumeMenu implements Menu {
	
	public Scanner keyboardIn = new Scanner(System.in);

	@Override
	public void runMenu() {
		Resume currentTechnicalResume = new TechnicalResume();
		displayMenu();
		int technicalResumeOption = getMenuSelection();
		processMenu(technicalResumeOption, currentTechnicalResume);
	}

	@Override
	public void displayMenu() {
		System.out.println("Please select the information you would like to add next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Work Experience");
		System.out.println("4. Projects");
		System.out.println("5. Software Skills");
		System.out.println("6. Programming Language Skills");
		System.out.println("7. Soft Skills (e.g. Communication, Public speaking, Collaboration, etc.)");
		System.out.println("8. Certifications");
		System.out.println("9. Save as word document");
		System.out.println("10. Exit");
	}

	@Override
	public void displayExitMessage() {
		System.out.println("Exiting Resume Builder...");
		System.out.println("Goodbye!");
	}

	@Override
	public int getMenuSelection() {
		return Integer.parseInt(keyboardIn.nextLine());
	}

	@Override
	public void processMenu(int technicalResumeOption, Resume currentTechnicalResume) {
		if(technicalResumeOption==1) {
			currentTechnicalResume=processContactInformation(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==2) {
			currentTechnicalResume=processAcademicInformation(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==3) {
			currentTechnicalResume=processWorkExperience(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==4) {				
			currentTechnicalResume=processProjectHistory((TechnicalResume) currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==5) {				
			currentTechnicalResume=processSkills((TechnicalResume) currentTechnicalResume, "software");
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==6) {				
			currentTechnicalResume=processSkills((TechnicalResume) currentTechnicalResume, "programming language");
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==7) {				
			currentTechnicalResume=processSkills((TechnicalResume) currentTechnicalResume, "soft");
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==8) {				
			currentTechnicalResume=processVolunteerExperience((TechnicalResume) currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==9) {				
			currentTechnicalResume=processSkill((FederalResume) currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else {
			displayExitMessage();
			return;
		}
	}

	@Override
	public Resume processContactInformation(Resume currentTechnicalResume) {
		System.out.println("Please enter your full name.");
		String firstName = keyboardIn.nextLine(); 
		
		System.out.println("Please enter your email.");
		String email = keyboardIn.nextLine(); 
		
		System.out.println("Please enter your phone number (e.g. 'xxx-xxx-xxxx').");
		String phone_number = keyboardIn.nextLine(); 
		
		System.out.println("Please enter your address.");
		String address = keyboardIn.nextLine();
		
		ContactInformation currentContactInfo = new ContactInformation(firstName, email, phone_number, address);
		
		currentTechnicalResume.setContactInfo(currentContactInfo);
		
		return currentTechnicalResume;
	}

	@Override
	public Resume processAcademicInformation(Resume currentTechnicalResume) {
		System.out.println("Please enter your the name of the academic institution you would like to add.");
		String schoolName = keyboardIn.nextLine(); 
		
		System.out.println("Where is "+schoolName+" located? (e.g. 'St. Louis, MO')");
		String schoolLocation = keyboardIn.nextLine(); 
		
		System.out.println("What is/was your GPA at "+schoolName+"?");
		double gpa = Double.parseDouble(keyboardIn.nextLine()); 
		
		System.out.println("When did you start attending "+schoolName+"? (e.g. August 2018)");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop attending "+schoolName+"? (If still attending, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		School currentSchool = new School(startDate, endDate, schoolName, schoolLocation, gpa);
		
		currentSchool=promptForHonorsOrAwards(currentSchool);
		
		currentTechnicalResume.addSchool(currentSchool);
		
		return currentTechnicalResume;
	}

	@Override
	public Resume processWorkExperience(Resume currentTechnicalResume) {
		System.out.println("Please enter your the name of the company you would like to add.");
		String companyName = keyboardIn.nextLine(); 
		
		System.out.println("When did you start working at "+companyName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop working at "+companyName+"? (If still employed, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		System.out.println("What was your title at "+companyName+"?");
		String jobTitle = keyboardIn.nextLine(); 
		
		Job currentJob = new Job(jobTitle, startDate, endDate, companyName);
		
		currentJob=promptForResponsibilities(currentJob);
		
		currentTechnicalResume.addJob(currentJob);
		
		return currentTechnicalResume;
	}

	@Override
	public Job promptForResponsibilities(Job currentJob) {
		String userInput="";
		
		while(!userInput.equals("done")) {
			System.out.println("Please enter the next responsibility you have/had at "+currentJob.getCompany()+". Or, type 'done' if you are finished.");
			userInput=keyboardIn.nextLine();
			
			if(!userInput.equals("done")) {
				currentJob.addBullet(userInput);
			}
		}
		
		System.out.println("Exiting job responsibilities section...");
		
		return currentJob;
	}

	@Override
	public School promptForHonorsOrAwards(School currentSchool) {
		String userInput="";
		
		while(!userInput.equals("done")) {
			System.out.println("Please enter the next honor or award you received while attending "+currentSchool.getSchoolName()+". Or, type 'done' if you are finished.");
			userInput=keyboardIn.nextLine();
			
			if(!userInput.equals("done")) {
				currentSchool.addHonorsAwards(userInput);
			}
		}
		
		System.out.println("Exiting academic honors/awards section...");
		
		return currentSchool;
	}
	
	private TechnicalResume processProjectHistory(TechnicalResume currentTechnicalResume) {
		System.out.println("Please enter the name of the project.");
		String projectName = keyboardIn.nextLine(); 
		
		System.out.println("When did you start "+projectName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you finish "+projectName+"? (If still working on it, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		System.out.println("Please enter a brief summary of "+projectName+".");
		String projectSummary = keyboardIn.nextLine(); 
		
		Project currentProject = new Project(projectName, startDate, endDate, projectSummary);
		
		currentTechnicalResume.addProject(currentProject);
		
		return currentTechnicalResume;
	}
	
	private TechnicalResume processSkills(TechnicalResume currentTechnicalResume, String skillType) {
		String newSkill="";
		
		while(!newSkill.equals("done")) {
			System.out.println("Please enter the next "+skillType+" skill you would like to add. Or, type 'done' if you are finished.");
			
			newSkill=keyboardIn.nextLine();
			
			if(!newSkill.equals("done")) {
				if(skillType.equals("software")) {
					currentTechnicalResume.addSoftwareSkill(newSkill);
				} else if(skillType.equals("programming language")) {
					currentTechnicalResume.addProgrammingLanguageSkill(newSkill);
				} else if(skillType.equals("soft")) {
					currentTechnicalResume.addSoftSkill(newSkill);
				} else {
					System.out.println("Error: You are attempting to add a skill with an invalid type.");
				}
			}
		}
		
		System.out.println("Exiting "+skillType+" skills section...");
		
		return currentTechnicalResume;
	}

	@Override
	public void resetMenu(Resume currentTechnicalResume) {
		displayMenu();
		int technicalResumeOption = getMenuSelection();
		processMenu(technicalResumeOption, currentTechnicalResume);
	}

	@Override
	public String promptForDestination() {
		System.out.println("What file path do you want your resume stored at? (Give absolute path.)");
		return keyboardIn.nextLine();
	}

}
