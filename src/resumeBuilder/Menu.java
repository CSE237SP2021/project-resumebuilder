package resumeBuilder;

public interface Menu {
	
	public void runMenu();
	
	public void displayMenu();
	
	public int getMenuSelection();
	
	public void processMenu(int resumeOption, Resume currentResume);
	
	public Resume processContactInformation(Resume currentResume);
	
	public Resume processAcademicInformation(Resume currentResume);
	
	public Resume processWorkExperience(Resume currentResume);
	
	public void resetMenu(Resume currentResume);
	
	public String promptForDestination();
	
}
