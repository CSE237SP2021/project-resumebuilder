package resumeBuilder;

import java.util.Scanner;

public class TemplateMenu {
	private Scanner keyboardIn;
	
	public TemplateMenu() {
		keyboardIn = new Scanner(System.in);
	}
	
	public void displayTemplateMenu() {
		System.out.println("What type of resume do you want to make?");
		System.out.println("1. Standard Resume");
		System.out.println("2. CV");
		System.out.println("3. Technical Resume");
		System.out.println("4. EXIT");
	}
	
	private int getTemplateMenuSelection() {
		return keyboardIn.nextInt();
	}
	
	public void runTemplateMenu() {
		displayTemplateMenu();
		
		int selectedMenu = getTemplateMenuSelection();
		
		openNewMenu(selectedMenu);
		
	}
	
	public void openNewMenu(int selectedMenu) {
		if(selectedMenu == 1) {
			
		} else if(selectedMenu == 2) {
			
		} else if(selectedMenu == 3) {
			
		} else {
			return;
		}
		
	}
	
	
}
