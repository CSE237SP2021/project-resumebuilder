package resumeBuilder;

import java.util.Scanner;

//import resumeBuilder.WordCreator;

public class StandardResumeMenu implements Menu{
	
	public Scanner keyboardIn = new Scanner(System.in);

	@Override
	public void runMenu() {
		Resume currentStandardResume = new StandardResume();
		displayMenu();
		int standardResumeOption = getMenuSelection();
		processMenu(standardResumeOption, currentStandardResume);
	}

	@Override
	public void displayMenu() {
		System.out.println("Please select the information you would like to add next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Work Experience");
		System.out.println("4. Skills");
		System.out.println("5. View current content");
		System.out.println("6. Save as word document");
		System.out.println("7. Exit");
	}

	@Override
	public int getMenuSelection() {
		return Integer.parseInt(keyboardIn.nextLine());
	}

	@Override
	public void processMenu(int standardResumeOption, Resume currentStandardResume) {
		if(standardResumeOption==1) {
			currentStandardResume=processContactInformation(currentStandardResume);
			resetMenu(currentStandardResume);
		} else if (standardResumeOption==2) {
			currentStandardResume=processAcademicInformation(currentStandardResume);
			resetMenu(currentStandardResume);
		} else if (standardResumeOption==3) {
			currentStandardResume=processWorkExperience(currentStandardResume);
			resetMenu(currentStandardResume);
		} else if (standardResumeOption==4) {				
			currentStandardResume=processSkill((StandardResume) currentStandardResume);
			resetMenu(currentStandardResume);
		} else if (standardResumeOption==5) {
			((StandardResume) currentStandardResume).printStandardResume();
			resetMenu(currentStandardResume);
		} else if (standardResumeOption==6) {
			String filePath = promptForDestination();
			WordCreator wordCreator = new WordCreator((StandardResume) currentStandardResume, filePath);
			wordCreator.createWordDocument();
		} else {
			displayExitMessage();
			return;
		}
	}

	private Resume processSkill(StandardResume currentStandardResume) {
		String newSkill="";
		
		while(!newSkill.equals("done")) {
			System.out.println("Please enter the next skill you would like to add. Or, type 'done' if you are finished.");
			
			newSkill=keyboardIn.nextLine();
			
			if(!newSkill.equals("done")) {
				currentStandardResume.addSkill(newSkill);
			}
		}
		
		System.out.println("Exiting skills section...");
		
		return currentStandardResume;
	}

	@Override
	public void resetMenu(Resume currentStandardResume) {
		displayMenu();
		int standardResumeOption = getMenuSelection();
		processMenu(standardResumeOption, currentStandardResume);		
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

	@Override
	public Resume processContactInformation(Resume currentStandardResume) {
		System.out.println("Please enter your full name.");
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

	@Override
	public Resume processAcademicInformation(Resume currentStandardResume) {
		System.out.println("Please enter your the name of the academic institution you would like to add.");
		String schoolName = keyboardIn.nextLine(); 
		
		System.out.println("Where is "+schoolName+" located? (e.g. 'St. Louis, MO')");
		String schoolLocation = keyboardIn.nextLine(); 
		
		System.out.println("What is/was your GPA at "+schoolName+"?");
		double gpa;
		try {
			 gpa = Double.parseDouble(keyboardIn.nextLine()); 
		} catch (NumberFormatException formatError) {
			 gpa = 0.0;
			 System.out.println("No GPA entered. Will be set to 0.0.");
		}		
		System.out.println("When did you start attending "+schoolName+"? (e.g. August 2018)");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop attending "+schoolName+"? (If still attending, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		School currentSchool = new School(startDate, endDate, schoolName, schoolLocation, gpa);
		
		currentSchool=promptForHonorsOrAwards(currentSchool);
		
		currentStandardResume.addSchool(currentSchool);
		
		return currentStandardResume;
	}

	@Override
	public Resume processWorkExperience(Resume currentStandardResume) {
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
		
		currentStandardResume.addJob(currentJob);
		
		return currentStandardResume;
	}

	@Override
	public void displayExitMessage() {
		System.out.println("Exiting Resume Builder...");
		System.out.println("Goodbye!");
	}

	@Override
	public String promptForDestination() {
		System.out.println("What file path do you want your resume stored at? (Give absolute path. e.g. /Users/<username>/Desktop/<filename>.docx)");
		System.out.println("Don't forget to include the file name at the end!");
		return keyboardIn.nextLine();
	}

}
