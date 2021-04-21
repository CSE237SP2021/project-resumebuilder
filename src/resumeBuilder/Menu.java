package resumeBuilder;

public interface Menu {
	
	public void runMenu();
	
	public void displayExitMessage();
	
	public void displayMenu();
		
	public int getMenuSelection();
	
	public void processMenu(int resumeOption, Resume currentResume);
	
	public Resume processContactInformation(Resume currentResume);
	
	public Resume processAcademicInformation(Resume currentResume);
	
	public Resume processWorkExperience(Resume currentResume);
	
	public Job promptForResponsibilities(Job currentJob);
	
	public School promptForHonorsOrAwards(School currentSchool);
	
	public void resetMenu(Resume currentResume);
	
	public String promptForDestination();
	
}
