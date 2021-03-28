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
	
	public void runTemplateMenu() {
		displayTemplateMenu();
		
		int selectedTemplate = getMenuSelection();
		
		openNewMenu(selectedTemplate);
		
		keyboardIn.close();
		
	}
	
	public void processTemplateMenu(int selectedTemplate) {
		if(selectedTemplate == 1) {
			
			//Display standard menu
			
		} else if(selectedTemplate == 2) {
			
			//Display CV menu
			
		} else if(selectedTemplate == 3) {
			
			//Display technical menu
			
		} else {
			return;
		}
		
	}
	
	private int getMenuSelection() {
		return keyboardIn.nextInt();
	}
	
	
	public void openNewMenu(int selectedTemplate) {
		if(selectedTemplate == 1) {
			
		} else if(selectedTemplate == 2) {
			
		} else if(selectedTemplate == 3) {
			
		} else {
			return;
		}
		
	}
	
	public void displayTemplateMenu() {
		System.out.println("What resume template would you like to use?");
		System.out.println("1. Standard Resume");
		System.out.println("2. CV");
		System.out.println("3. Technical Resume");
		System.out.println("4. Exit");
	}
	
	public void displayStandardResumeMenu() {
		System.out.println("Please select the information you would like to add next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Work Experience");
		System.out.println("4. Skills");
		System.out.println("5. Exit");
		//Potentially change exit to "cancel" in the future and then have a "next" option that takes you to a formatting menu
	}
	
	public void displayCVMenu() {
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
	
	public void displayTechnicalResumeMenu() {
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
}
