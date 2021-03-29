package resumeBuilder;

import java.util.Scanner;

public class Menu {
	private Scanner keyboardIn;
	
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
	
	private void displayTemplateMenu() {
		System.out.println("What resume template would you like to use?");
		System.out.println("1. Standard Resume");
		System.out.println("2. CV");
		System.out.println("3. Technical Resume");
		System.out.println("4. Exit");
	}
	
	private void displayStandardResumeMenu() {
		System.out.println("Please select the information you would like to add next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Work Experience");
		System.out.println("4. Skills");
		System.out.println("5. Exit");
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
	
	private void displayExitMessage() {
		System.out.println("Exiting Resume Builder...");
		System.out.println("Goodbye!");
	}
	
	private void resetStandardResumeMenu(StandardResume currentStandardResume) {
		displayStandardResumeMenu();
		int standardResumeOption = getMenuSelection();
		processStandardResumeMenu(standardResumeOption, currentStandardResume);
	}
	
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
}
