package resumeBuilder;

import java.util.Scanner;

public class RunResumeBuilder {
	
	public Scanner keyboardIn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunResumeBuilder runResumeBuilder = new RunResumeBuilder();
		runResumeBuilder.runTemplateMenu();
	}
	
	public void runTemplateMenu() {
		displayTemplateMenu();
		
		int selectedTemplate = getMenuSelection();
		processTemplateMenu(selectedTemplate);
		
		keyboardIn.close();
	}
	
	private int getMenuSelection() {
		return Integer.parseInt(keyboardIn.nextLine());
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
	
	private void processTemplateMenu(int selectedTemplate) { //see displayTemplateMenu for code correspondence
		
		if(selectedTemplate == 1) {
			
			Menu standardResumeMenu = new StandardResumeMenu();
			standardResumeMenu.runMenu();
			
		} else if(selectedTemplate == 2) {
			
			//TODO: Create CV menu and object
			
		} else if(selectedTemplate == 3) {
			
			//TODO: Create technical resume menu and object
			
		} else if(selectedTemplate == 4) {
			
			Menu federalResumeMenu = new FederalResumeMenu();
			federalResumeMenu.runMenu();
			
		} else if (selectedTemplate == 5) {
			
			//TODO: Create HS resume menu and object
			
		} else if (selectedTemplate == 6) {
			
			//TODO: Create Undergrad Research Resume
			
		} else {
			displayExitMessage();
			return;
		}
	}
	
	public void displayExitMessage() {
		System.out.println("Exiting Resume Builder...");
		System.out.println("Goodbye!");		
	}

}
