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
		return keyboardIn.nextInt();
	}
	
	
	private void runTemplateMenu() {
		displayTemplateMenu();
		
		int selectedTemplate = getMenuSelection();
		
		processTemplateMenu(selectedTemplate);
		
		keyboardIn.close();
		
	}
	
	private void processTemplateMenu(int selectedTemplate) { //see displayTemplateMenu for code correspondence
		if(selectedTemplate == 1) {
			displayStandardResumeMenu();
			
			int standardResumeOption = getMenuSelection();
			
			processStandardResumeMenu(standardResumeOption);
			
		} else if(selectedTemplate == 2) {
			
			displayCVMenu();
			
			int CVOption = getMenuSelection();
			
			processCVMenu(CVOption);
			
		} else if(selectedTemplate == 3) {
			
			displayTechnicalResumeMenu();
			
			int technicalResumeOption = getMenuSelection();
			
			processTechnicalResumeMenu(technicalResumeOption);
			
		} else {
			displayExitMessage();
			return;
		}
	}
	
	private void processStandardResumeMenu(int standardResumeOption) {
		/*
		 * Hannah: I feel as though this is when we should instantiate our resume object that we keep track of?
		 * The issue is that our constructor isn't empty; it requires contact info.
		 * So maybe we should prompt for contact info immediately before showing the template menu? 
		 * And then just pass that contactinfo object to processTemplateMenu, 
		 * instantiate the resume with that contactinfo, and then pass the resume to this process method for further additions?
		 */
		if(standardResumeOption==1) {
			//Prompt for contact information (menu?)
			
		} else if (standardResumeOption==2) {
			
			//Prompt for academic history (menu?)
			
		} else if (standardResumeOption==3) {
			
			//Prompt for work experience (menu?)
			
		} else if (standardResumeOption==4) {
			
			//Prompt for skills - definitely not a menu
			
			//Can't implement til we discuss resume instantiation, but my thought is something like
			
			System.out.println("Please enter the skill you would like to add.");
			String newSkill = keyboardIn.next(); // TODO Right now only takes in one word at a time, should get it to take in a phrase
			System.out.println(newSkill);
			
			// currentStandardResume.addSkill(newSkill);
			// displayStandardResumeMenu();
			//int standardResumeOption = getMenuSelection();
			//processStandardResumeMenu(standardResumeOption);
			
			// TODO make a method for each template that displays its menu, prompts for selection, and processes the selection so that we aren't repeating the same 3 lines of code
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
}
