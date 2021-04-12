package resumeBuilder;

import java.util.Scanner;

public class Menu {
	public Scanner keyboardIn;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Menu resumeTemplateMenu = new Menu();
		resumeTemplateMenu.runTemplateMenu();
	}
	
	private int getMenuSelection() {
		return Integer.parseInt(keyboardIn.nextLine());
	}
	
	
	private void runTemplateMenu() {
		displayTemplateMenu();
		
		int selectedTemplate = getMenuSelection();
		processTemplateMenu(selectedTemplate);
		
		keyboardIn.close();
	}
	
	private void processTemplateMenu(int selectedTemplate) { //see displayTemplateMenu for code correspondence
		//All templates require 
		if(selectedTemplate == 1) {
			
			StandardResume currentStandardResume = new StandardResume();
			
			displayStandardResumeMenu();
			int standardResumeOption = getMenuSelection();
			processStandardResumeMenu(standardResumeOption, currentStandardResume);
			
		} else if(selectedTemplate == 2) {
			
			//Instantiate CV
			
			displayCVMenu();
			int CVOption = getMenuSelection();
			processCVMenu(CVOption);
			
		} else if(selectedTemplate == 3) {
			
			//Instantiate Technical Resume
			
			displayTechnicalResumeMenu();
			
			int technicalResumeOption = getMenuSelection();
			
			processTechnicalResumeMenu(technicalResumeOption);
			
		} else if(selectedTemplate == 4) {
			
			//Instantiate Federal Resume
//			FederalResumeMenu federalResumeMenu = new FederalResumeMenu();
			
			FederalResume currentFederalResume = new FederalResume();
			
			displayFederalResumeMenu();
			
			int federalResumeOption = getMenuSelection();
			
			processFederalResumeMenu(federalResumeOption, currentFederalResume);
			
//			federalResumeMenu.processFederalResumeMenu(federalResumeOption, currentFederalResume);
			//Contact Info
			//Academic Info
			//Job
			
		} else {
			displayExitMessage();
			return;
		}
	}
	
	private void processStandardResumeMenu(int standardResumeOption, StandardResume currentStandardResume) {
		
		if(standardResumeOption==1) {
			currentStandardResume=processContactInformation(currentStandardResume);
			resetStandardResumeMenu(currentStandardResume);
		} else if (standardResumeOption==2) {
			currentStandardResume=processAcademicInformation(currentStandardResume);
			resetStandardResumeMenu(currentStandardResume);
		} else if (standardResumeOption==3) {
			currentStandardResume=processWorkExperience(currentStandardResume);
			resetStandardResumeMenu(currentStandardResume);
		} else if (standardResumeOption==4) {				
			currentStandardResume=processSkill(currentStandardResume);
			resetStandardResumeMenu(currentStandardResume);
		} else if (standardResumeOption==5) {
			String filePath = promptForDestination();
			WordCreator wordCreator = new WordCreator(currentStandardResume, filePath);
			wordCreator.createWordDocument();
		} else {
			displayExitMessage();
			// TODO update this else if standard resume menu changes (i expect it to)
			return;
		}
	}
	
	private void processCVMenu(int CVOption) {
		// TODO implement processCVMenu
	}
	
	private void processTechnicalResumeMenu(int technicalResumeOption) {
		// TODO implement processTechnicalResumeMenu
	}
	
	private void processFederalResumeMenu(int federalResumeOption, FederalResume currentFederalResume) {
		if(federalResumeOption==1) {
			currentFederalResume=processContactInformation(currentFederalResume);
			resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==2) {
			currentFederalResume=processAcademicInformation(currentFederalResume);
			resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==3) {
			currentFederalResume=processWorkExperience(currentFederalResume);
			resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==4) {				
			currentFederalResume=processCitizenshipStatus(currentFederalResume);
			resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==5) {				
			currentFederalResume=processFederalExperience(currentFederalResume);
			resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==6) {				
			currentFederalResume=processClearance(currentFederalResume);
			resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==7) {				
			currentFederalResume=processPurposeStatement(currentFederalResume);
			resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==8) {				
			currentFederalResume=processVolunteerExperience(currentFederalResume);
			resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==9) {				
			currentFederalResume=processSkill(currentFederalResume);
			resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==10) {				
				currentFederalResume=processReferences(currentFederalResume);
				resetFederalResumeMenu(currentFederalResume);
		} else if (federalResumeOption==11) {
			String filePath = promptForDestination();
			WordCreator wordCreator = new WordCreator(currentFederalResume, filePath);
			wordCreator.createWordDocument();
		} else {
			displayExitMessage();
			// TODO update this else if standard resume menu changes (i expect it to)
			return;
		}
	}
	
	private void displayTemplateMenu() {
		System.out.println("What resume template would you like to use?");
		System.out.println("1. Standard Resume");
		System.out.println("2. CV");
		System.out.println("3. Technical Resume");
		System.out.println("4. Federal Resume");
		System.out.println("5. High School Resume");
		System.out.println("6. Undergraduate Research Resume");
		System.out.println("7. Exit");
	}
	
	private void displayStandardResumeMenu() {
		System.out.println("Please select the information you would like to add next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Work Experience");
		System.out.println("4. Skills");
		System.out.println("5. Save as word document");
		System.out.println("6. Exit");
		//Potentially change exit to "cancel" in the future and then have a "next" option that takes you to a formatting menu
	}
	
	private void displayCVMenu() {
		System.out.println("Please select the information you would like to add next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Work Experience");
		System.out.println("4. Skills");
		System.out.println("5. Publications and Presentations");
		System.out.println("6. Professional Associations");
		System.out.println("7. Grants and Scholarships");
		System.out.println("8. Licenses and Certifications");
		System.out.println("9. Exit");
		//Potentially change exit to "cancel" in the future and then have a "next" option that takes you to a formatting menu
		//Options based off of https://www.indeed.com/career-advice/resumes-cover-letters/cv-format-guide
	}
	
	private void displayTechnicalResumeMenu() {
		System.out.println("Please select the information you would like to add next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Work Experience");
		System.out.println("4. Projects");
		System.out.println("5. Skills");
		System.out.println("6. Certifications");
		System.out.println("7. Programming Languages");
		System.out.println("8. Exit");
		//Potentially change exit to "cancel" in the future and then have a "next" option that takes you to a formatting menu
	}
	
	private void displayFederalResumeMenu() {
		System.out.println("Please select the information you would like to add next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Work Experience");
		System.out.println("4. Citizenship Status");
		System.out.println("5. Federal Experience");
		System.out.println("6. Clearance");
		System.out.println("7. Purpose Statement");
		System.out.println("8. Volunteer Work and Community Involvement");
		System.out.println("9. Skills");
		System.out.println("10. References");
		System.out.println("11. Save as word document");
		System.out.println("12. Exit");
		//Options from: https://www.sec.gov/jobs/sample-resume/sample-resume.pdf
	}
	
	private void displayExitMessage() {
		System.out.println("Exiting Resume Builder...");
		System.out.println("Goodbye!");
	}
	
	private void resetStandardResumeMenu(StandardResume currentStandardResume) {
		displayStandardResumeMenu();
		int standardResumeOption = getMenuSelection();
		processStandardResumeMenu(standardResumeOption, currentStandardResume);
	}
	
	private void resetFederalResumeMenu(FederalResume currentFederalResume) {
		displayFederalResumeMenu();
		int federalResumeOption = getMenuSelection();
		processFederalResumeMenu(federalResumeOption, currentFederalResume);
	}
	
	//Process standard resume information
	private StandardResume processContactInformation(StandardResume currentStandardResume) {
		
		System.out.println("Please enter your first name.");
		String firstName = keyboardIn.nextLine(); 
		
		System.out.println("Please enter your email.");
		String email = keyboardIn.nextLine(); 
		
		System.out.println("Please enter your phone number (e.g. 'xxx-xxx-xxxx').");
		String phone_number = keyboardIn.nextLine(); 
		
		System.out.println("Please enter your address.");
		String address = keyboardIn.nextLine();
		
		ContactInformation currentContactInfo = new ContactInformation(firstName, email, phone_number, address);
		
		currentStandardResume.setContactInfo(currentContactInfo);
		
		return currentStandardResume;
	}
		
	private StandardResume processAcademicInformation(StandardResume currentStandardResume) {
		
		System.out.println("Please enter your the name of the academic institution you would like to add.");
		String schoolName = keyboardIn.nextLine(); 
		
		System.out.println("Where is "+schoolName+" located? (e.g. 'St. Louis, MO')");
		String schoolLocation = keyboardIn.nextLine(); 
		
		System.out.println("What is/was your GPA at "+schoolName+"?");
		double gpa = Double.parseDouble(keyboardIn.nextLine()); 
		
		System.out.println("When did you start attending "+schoolName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop attending "+schoolName+"? (If still attending, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		//TODO continuous prompt for honors/awards
		
		School currentSchool = new School(startDate, endDate, schoolName, schoolLocation, gpa);
		
		currentStandardResume.addSchool(currentSchool);
		
		return currentStandardResume;
	}
	
	private StandardResume processWorkExperience(StandardResume currentStandardResume) {
		
		System.out.println("Please enter your the name of the company you would like to add.");
		String companyName = keyboardIn.nextLine(); 
		
		System.out.println("When did you start working at "+companyName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop working at "+companyName+"? (If still employed, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		System.out.println("What was your title at "+companyName+"?");
		String jobTitle = keyboardIn.nextLine(); 
		
		//TODO continuous prompt for responsibilities
		
		Job currentJob = new Job(jobTitle, startDate, endDate, companyName);
		
		currentStandardResume.addJob(currentJob);
		
		return currentStandardResume;
	}
	
	private StandardResume processSkill(StandardResume currentStandardResume) {
		System.out.println("Please enter the skill you would like to add.");
		String newSkill = keyboardIn.nextLine(); // TODO Right now only takes in one word at a time, should get it to take in a phrase
		
		currentStandardResume.addSkill(newSkill);
		
		return currentStandardResume;
	}
	
	//Process federal resume user input
	private FederalResume processContactInformation(FederalResume currentFederalResume) {
		
		System.out.println("Please enter your first name.");
		String firstName = keyboardIn.nextLine(); 
		
		System.out.println("Please enter your email.");
		String email = keyboardIn.nextLine(); 
		
		System.out.println("Please enter your phone number (e.g. 'xxx-xxx-xxxx').");
		String phone_number = keyboardIn.nextLine(); 
		
		System.out.println("Please enter your address.");
		String address = keyboardIn.nextLine();
		
		ContactInformation currentContactInfo = new ContactInformation(firstName, email, phone_number, address);
		
		currentFederalResume.setContactInfo(currentContactInfo);
		
		return currentFederalResume;
	}
	
	private FederalResume processAcademicInformation(FederalResume currentFederalResume) {
		
		System.out.println("Please enter your the name of the academic institution you would like to add.");
		String schoolName = keyboardIn.nextLine(); 
		
		System.out.println("Where is "+schoolName+" located? (e.g. 'St. Louis, MO')");
		String schoolLocation = keyboardIn.nextLine(); 
		
		System.out.println("What is/was your GPA at "+schoolName+"?");
		double gpa = Double.parseDouble(keyboardIn.nextLine()); 
		
		System.out.println("When did you start attending "+schoolName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop attending "+schoolName+"? (If still attending, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		//TODO continuous prompt for honors/awards
		
		School currentSchool = new School(startDate, endDate, schoolName, schoolLocation, gpa);
		
		currentFederalResume.addSchool(currentSchool);
		
		return currentFederalResume;
	}
	
	private FederalResume processWorkExperience(FederalResume currentFederalResume) {
		
		System.out.println("Please enter your the name of the company you would like to add.");
		String companyName = keyboardIn.nextLine(); 
		
		System.out.println("When did you start working at "+companyName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop working at "+companyName+"? (If still employed, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		System.out.println("What was your title at "+companyName+"?");
		String jobTitle = keyboardIn.nextLine(); 
		
		//TODO continuous prompt for responsibilities
		
		Job currentJob = new Job(jobTitle, startDate, endDate, companyName);
		
		currentFederalResume.addJob(currentJob);
		
		return currentFederalResume;
	}
	
	private FederalResume processCitizenshipStatus(FederalResume currentFederalResume) {
		
		System.out.println("Please enter your citizenship status (e.g., US Citizen, Work Visa.");
		String citizenshipStatus = keyboardIn.nextLine(); 
		
		currentFederalResume.setCitizenshipStatus(citizenshipStatus);
		
		return currentFederalResume;
	}
	
	private FederalResume processFederalExperience(FederalResume currentFederalResume) {
		
		System.out.println("Please enter your government experience (e.g., military, federal, or state.");
		String federalExperience = keyboardIn.nextLine(); 
		
		currentFederalResume.setFederalExperience(federalExperience);
		
		return currentFederalResume;
	}
	
	private FederalResume processClearance(FederalResume currentFederalResume) {
		
		System.out.println("Please enter your clearance level (e.g., Top Secret, Secret). If you don't have a clearance, just press 'Enter.'");
		String clearance = keyboardIn.nextLine(); 
		
		currentFederalResume.setClearance(clearance);
		
		return currentFederalResume;
	}
	
	private FederalResume processPurposeStatement(FederalResume currentFederalResume) {
		
		System.out.println("Please enter a purpose statement about the roles you're looking for.");
		String purposeStatement = keyboardIn.nextLine(); 
		
		currentFederalResume.setPurposeStatement(purposeStatement);
		
		return currentFederalResume;
	}
	
	private FederalResume processVolunteerExperience(FederalResume currentFederalResume) {
		
		System.out.println("Please enter your the name of the volunteer experience.");
		String orgName = keyboardIn.nextLine(); 
		
		System.out.println("When did you start volunteering at "+orgName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop volunteering at "+orgName+"? (If still volunteering, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		System.out.println("What was your title at "+orgName+"?");
		String positionTitle = keyboardIn.nextLine(); 
		
		//TODO continuous prompt for responsibilities
		
		Activity currentActivity = new Activity(startDate, endDate, positionTitle, orgName);
		
		currentFederalResume.addActivity(currentActivity);
		
		return currentFederalResume;
	}
	
	private FederalResume processSkill(FederalResume currentFederalResume) {
		System.out.println("Please enter the skill you would like to add.");
		String newSkill = keyboardIn.nextLine();
		
		currentFederalResume.addSkill(newSkill);
		
		return currentFederalResume;
	}
	
	private FederalResume processReferences(FederalResume currentFederalResume) {
		System.out.println("Please enter the name of the reference you would like to add.");
		String newReference = keyboardIn.nextLine();
		
		System.out.println("Please enter the email of " +newReference+".");
		String referenceEmail = keyboardIn.nextLine(); 
		
		System.out.println("Please enter the phone number of " +newReference+".");
		String referencePhoneNumber = keyboardIn.nextLine(); 
		
		System.out.println("Where does " +newReference+" work?");
		String referenceOrg = keyboardIn.nextLine(); 
				
		References reference = new References();
		
		reference.addReferenceName(newReference);
		reference.addReferenceEmail(referenceEmail);
		reference.addReferencePhoneNumber(referencePhoneNumber);
		reference.addReferenceOrganization(referenceOrg);
		
		//Add ability for user to add multiple references
		
		return currentFederalResume;
	}
		
	private String promptForDestination() {
		System.out.println("What file path do you want your resume stored at? (Give absolute path, )");
		return keyboardIn.nextLine();
	}
}
