package resumeBuilder;

import java.util.Scanner;

public class RunResumeBuilder {
	
	public Scanner keyboardIn = new Scanner(System.in);

	public static void main(String[] args) {
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
		System.out.println("2. Technical Resume");
		System.out.println("3. Federal Resume");
		System.out.println("4. Undergraduate Research Resume");
		System.out.println("5. Exit");
	}
	
	private void processTemplateMenu(int selectedTemplate) { //see displayTemplateMenu for code correspondence
		
		if(selectedTemplate == 1) {
			
			Menu standardResumeMenu = new StandardResumeMenu();
			standardResumeMenu.runMenu();
			
		} else if(selectedTemplate == 2) {
			
			Menu technicalResumeMenu = new TechnicalResumeMenu();
			technicalResumeMenu.runMenu();
			
		} else if(selectedTemplate == 3) {
			
			Menu federalResumeMenu = new FederalResumeMenu();
			federalResumeMenu.runMenu();
			
		} else if (selectedTemplate == 4) {
			
			Menu undergradResearchResumeMenu = new UndergradResearchResumeMenu();
			undergradResearchResumeMenu.runMenu();
			
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
