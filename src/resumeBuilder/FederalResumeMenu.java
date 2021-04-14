package resumeBuilder;

import java.util.Scanner;

//import resumeBuilder.WordCreator;

public class FederalResumeMenu implements Menu {

	public Scanner keyboardIn = new Scanner(System.in);

	@Override
	public void runMenu() {
		Resume currentFederalResume = new FederalResume();
		displayMenu();
		int federalResumeOption = getMenuSelection();
		processMenu(federalResumeOption, currentFederalResume);		
	}

	@Override
	public void displayMenu() {
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

	@Override
	public int getMenuSelection() {
		return Integer.parseInt(keyboardIn.nextLine());
	}

	@Override
	public void processMenu(int federalResumeOption, Resume currentFederalResume) {
		if(federalResumeOption==1) {
			currentFederalResume=processContactInformation(currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==2) {
			currentFederalResume=processAcademicInformation(currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==3) {
			currentFederalResume=processWorkExperience(currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==4) {				
			currentFederalResume=processCitizenshipStatus((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==5) {				
			currentFederalResume=processFederalExperience((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==6) {				
			currentFederalResume=processClearance((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==7) {				
			currentFederalResume=processPurposeStatement((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==8) {				
			currentFederalResume=processVolunteerExperience((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==9) {				
			currentFederalResume=processSkill((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==10) {				
				currentFederalResume=processReferences((FederalResume) currentFederalResume);
				resetMenu(currentFederalResume);
		} else if (federalResumeOption==11) {
			System.out.println("Word Doc creation unsupported for our federal resume template.");
			resetMenu(currentFederalResume);
//			String filePath = promptForDestination();
//			WordCreator wordCreator = new WordCreator(currentFederalResume, filePath);
//			wordCreator.createWordDocument();
		} else {
			displayExitMessage();
			return;
		}		
	}

	@Override
	public Resume processContactInformation(Resume currentFederalResume) {
		
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

	@Override
	public Resume processAcademicInformation(Resume currentFederalResume) {
		
		System.out.println("Please enter your the name of the academic institution you would like to add.");
		String schoolName = keyboardIn.nextLine(); 
		
		System.out.println("Where is "+schoolName+" located? (e.g. 'St. Louis, MO')");
		String schoolLocation = keyboardIn.nextLine(); 
		
		System.out.println("What is/was your GPA at "+schoolName+"?");
		double gpa = Double.parseDouble(keyboardIn.nextLine()); 
		
		System.out.println("When did you start attending "+schoolName+"? (e.g. August 2018)");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop attending "+schoolName+"? (If still attending, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		School currentSchool = new School(startDate, endDate, schoolName, schoolLocation, gpa);
		
		currentSchool=promptForHonorsOrAwards(currentSchool);
		
		currentFederalResume.addSchool(currentSchool);
		
		return currentFederalResume;
	}

	@Override
	public Resume processWorkExperience(Resume currentFederalResume) {
		
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
		
		Activity currentActivity = new Activity(startDate, endDate, positionTitle, orgName);
		
		//TODO continuous prompt for responsibilities
		
		currentActivity=promptForTasks(currentActivity);
		
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
		
		//TODO: ability for user to add multiple references
		
		return currentFederalResume;
	}

	@Override
	public void resetMenu(Resume currentFederalResume) {
		displayMenu();
		int federalResumeOption = getMenuSelection();
		processMenu(federalResumeOption, currentFederalResume);
	}

	@Override
	public String promptForDestination() {
		System.out.println("What file path do you want your resume stored at? (Give absolute path.)");
		return keyboardIn.nextLine();
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
	
	public Activity promptForTasks(Activity currentActivity) {
		String userInput="";
		
		while(!userInput.equals("done")) {
			System.out.println("Please enter the next responsibility you have/had at "+currentActivity.getOrganization()+". Or, type 'done' if you are finished.");
			userInput=keyboardIn.nextLine();
			
			if(!userInput.equals("done")) {
				currentActivity.addDescription(userInput);
			}
		}
		
		System.out.println("Exiting job responsibilities section...");
		
		return currentActivity;
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
	public void displayExitMessage() {
		System.out.println("Exiting Resume Builder...");
		System.out.println("Goodbye!");
	}
}
