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
		System.out.println("Please select the information you would like to add/edit next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Federal Work Experience");
		System.out.println("4. Regular Work Experience");
		System.out.println("5. Citizenship Status");
		System.out.println("6. Government or Military Experience");
		System.out.println("7. Clearance");
		System.out.println("8. Purpose Statement");
		System.out.println("9. Volunteer Work and Community Involvement");
		System.out.println("10. Skills");
		System.out.println("11. References");
		System.out.println("12. View current content");
		System.out.println("13. Save as word document");
		System.out.println("14. Exit");
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
			currentFederalResume=addOrRemoveSchool(currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==3) {
			currentFederalResume=addOrRemoveFederalJob(currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==4) {
			currentFederalResume=addOrRemoveJob(currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==5) {				
			currentFederalResume=processCitizenshipStatus((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==6) {				
			currentFederalResume=processFederalExperience((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==7) {				
			currentFederalResume=processClearance((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==8) {				
			currentFederalResume=processPurposeStatement((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==9) {				
			currentFederalResume=addOrRemoveVolunteerExperience(currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==10) {				
			currentFederalResume=addOrRemoveSkill((FederalResume) currentFederalResume);
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==11) {				
				currentFederalResume=addOrRemoveReference(currentFederalResume);
				resetMenu(currentFederalResume);
		} else if (federalResumeOption==12){
			((FederalResume) currentFederalResume).printFederalResume();
			resetMenu(currentFederalResume);
		} else if (federalResumeOption==13) {
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
		System.out.println("If you have already entered contact information, what you are entering now will replace that.");
		System.out.println();
		
		System.out.println("Please enter your full name.");
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
	
	public Resume processFederalWorkExperience(FederalResume currentFederalResume) {
		
		System.out.println("Please enter your the name of the company you would like to add.");
		String companyName = keyboardIn.nextLine(); 
		
		System.out.println("When did you start working at "+companyName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop working at "+companyName+"? (If still employed, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		System.out.println("What was your title at "+companyName+"?");
		String jobTitle = keyboardIn.nextLine(); 
		
		System.out.println("What was your GS Level at "+companyName+"? (Press enter if not applicable)");
		String GSLevel = keyboardIn.nextLine(); 
		
		System.out.println("What was your salary at "+companyName+"?");
		String salary = keyboardIn.nextLine(); 
		
		FederalJob currentFederalJob = new FederalJob(jobTitle, startDate, endDate, companyName, GSLevel, salary);
		
		currentFederalJob=promptForFedResponsibilities(currentFederalJob);
		
		currentFederalResume.addFederalJob(currentFederalJob);
		
		return currentFederalResume;
	}
	
	private FederalResume processCitizenshipStatus(FederalResume currentFederalResume) {
		System.out.println("If you have already entered your citizenship status, what you are entering now will replace that.");
		System.out.println();
		
		System.out.println("Please enter your citizenship status (e.g., US Citizen, Work Visa.");
		String citizenshipStatus = keyboardIn.nextLine(); 
		
		currentFederalResume.setCitizenshipStatus(citizenshipStatus);
		
		return currentFederalResume;
	}
	
	private FederalResume processFederalExperience(FederalResume currentFederalResume) {
		System.out.println("If you have already entered your government experience, what you are entering now will replace that.");
		System.out.println();
		
		System.out.println("Please enter your government experience (e.g., military, federal, or state.");
		String federalExperience = keyboardIn.nextLine(); 
		
		currentFederalResume.setFederalExperience(federalExperience);
		
		return currentFederalResume;
	}

	private FederalResume processClearance(FederalResume currentFederalResume) {
		System.out.println("If you have already entered your clearance level, what you are entering now will replace that.");
		System.out.println();
		
		System.out.println("Please enter your clearance level (e.g., Top Secret, Secret). If you don't have a clearance, just press 'Enter.'");
		String clearance = keyboardIn.nextLine(); 
		
		currentFederalResume.setClearance(clearance);
		
		return currentFederalResume;
	}
	
	private FederalResume processPurposeStatement(FederalResume currentFederalResume) {
		System.out.println("If you have already entered your purpose statement, what you are entering now will replace that.");
		System.out.println();
		
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
				
		currentActivity=promptForTasks(currentActivity);
		
		currentFederalResume.addActivity(currentActivity);
		
		return currentFederalResume;
	}
	
	private FederalResume processSkill(FederalResume currentFederalResume) {
		String newSkill="";
		
		while(!newSkill.equals("done")) {
			System.out.println("Please enter the next skill you would like to add. Or, type 'done' if you are finished.");
			
			newSkill=keyboardIn.nextLine();
			
			if(!newSkill.equals("done")) {
				currentFederalResume.addSkill(newSkill);
			}
		}
		
		System.out.println("Exiting skills section...");
		
		return currentFederalResume;
	}
	
	private FederalResume processReference(FederalResume currentFederalResume) {
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
		
		currentFederalResume.addReference(reference);
				
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
		System.out.println("What file path do you want your resume stored at? (Give absolute path. e.g. /Users/<username>/Desktop/<filename>.docx)");
		System.out.println("Don't forget to include the file name at the end!");
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
	
	public FederalJob promptForFedResponsibilities(FederalJob currentFederalJob) {
		String userInput="";
		
		while(!userInput.equals("done")) {
			System.out.println("Please enter the next responsibility you have/had at "+currentFederalJob.getCompany()+". Or, type 'done' if you are finished.");
			userInput=keyboardIn.nextLine();
			
			if(!userInput.equals("done")) {
				currentFederalJob.addBullet(userInput);
			}
		}
		
		System.out.println("Exiting job responsibilities section...");
		
		return currentFederalJob;
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
	
	public void displayAddOrRemove() {
		System.out.println("Please select what you would like to do.");
		System.out.println("1. Add an entry.");
		System.out.println("2. Remove an entry.");
		System.out.println("3. Erase all entries.");
		System.out.println("4. Return");
	}
	
	public int promptForAddOrRemove() {
		displayAddOrRemove();
		
		int selection = getMenuSelection();
		
		while(selection>4 || selection<1) {
			System.out.println("That is not a valid selection. Please try again.");
			displayAddOrRemove();
			selection = getMenuSelection();
		}
		
		return selection;
	}
	
	public Resume addOrRemoveSchool(Resume currentFederalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentFederalResume=processAcademicInformation(currentFederalResume);	
		} else if(selection == 2) {
			currentFederalResume=processSchoolRemoval(currentFederalResume);
		} else if(selection == 3) {
			((FederalResume) currentFederalResume).eraseSchools();
			System.out.println("All academic history has been erased.");
		}
		
		return currentFederalResume;
	}
	
	public Resume processSchoolRemoval(Resume currentFederalResume) {
		System.out.println("Please enter the name of the school you would like to delete (exactly as entered previously.");
		String schoolName = keyboardIn.nextLine();
		if(((FederalResume) currentFederalResume).removeSchool(schoolName)) {
			System.out.println(schoolName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find school with that name.");
		}
		
		return currentFederalResume;
	}
	
	public Resume addOrRemoveFederalJob(Resume currentFederalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentFederalResume=processFederalWorkExperience((FederalResume) currentFederalResume);
		} else if(selection == 2) {
			currentFederalResume=processFederalJobRemoval(currentFederalResume);
		} else if(selection == 3) {
			((FederalResume) currentFederalResume).eraseFederalJobs();
			System.out.println("All federal work experience has been erased.");
		}
		
		return currentFederalResume;
	}
	
	public Resume processFederalJobRemoval(Resume currentFederalResume) {
		System.out.println("Please enter the company name of the federal job you would like to delete (exactly as entered previously.");
		String companyName = keyboardIn.nextLine();
		if(((FederalResume) currentFederalResume).removeFederalJob(companyName)) {
			System.out.println(companyName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find federal job with that company name.");
		}
		
		return currentFederalResume;
	}
	
	public Resume addOrRemoveJob(Resume currentFederalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentFederalResume=processWorkExperience(currentFederalResume);
		} else if(selection == 2) {
			currentFederalResume=processJobRemoval(currentFederalResume);
		} else if(selection == 3) {
			((FederalResume) currentFederalResume).eraseJobs();
			System.out.println("All regular work experience has been erased.");
		}
		
		return currentFederalResume;
	}
	
	public Resume processJobRemoval(Resume currentFederalResume) {
		System.out.println("Please enter the company name of the job you would like to delete (exactly as entered previously.");
		String companyName = keyboardIn.nextLine();
		if(((FederalResume) currentFederalResume).removeJob(companyName)) {
			System.out.println(companyName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find job with that company name.");
		}
		
		return currentFederalResume;
	}
	
	public Resume addOrRemoveVolunteerExperience(Resume currentFederalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentFederalResume=processVolunteerExperience((FederalResume) currentFederalResume);
		} else if(selection == 2) {
			currentFederalResume=processVolunteerExperienceRemoval(currentFederalResume);
		} else if(selection == 3) {
			((FederalResume) currentFederalResume).eraseActivities();
			System.out.println("All activities have been erased.");
		}
		
		return currentFederalResume;
	}
	
	public Resume processVolunteerExperienceRemoval(Resume currentFederalResume) {
		System.out.println("Please enter the organization name of the volunteer experience you would like to delete (exactly as entered previously.");
		String organizationName = keyboardIn.nextLine();
		if(((FederalResume) currentFederalResume).removeActivity(organizationName)) {
			System.out.println(organizationName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find volunteer experience with that organization name.");
		}
		
		return currentFederalResume;
	}
	
	public Resume addOrRemoveSkill(Resume currentFederalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentFederalResume=processSkill((FederalResume) currentFederalResume);
		} else if(selection == 2) {
			currentFederalResume=processSkillRemoval(currentFederalResume);
		} else if(selection == 3) {
			((FederalResume) currentFederalResume).eraseSkills();
			System.out.println("All skills been erased.");
		}
		
		return currentFederalResume;
	}
	
	public Resume processSkillRemoval(Resume currentFederalResume) {
		System.out.println("Please enter the skill you would like to delete (exactly as entered previously.");
		String skill = keyboardIn.nextLine();
		if(((FederalResume) currentFederalResume).removeSkill(skill)) {
			System.out.println(skill+" has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find that skill.");
		}
		
		return currentFederalResume;
	}
	
	public Resume addOrRemoveReference(Resume currentFederalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentFederalResume=processReference((FederalResume) currentFederalResume);	
		} else if(selection == 2) {
			currentFederalResume=processReferenceRemoval(currentFederalResume);
		} else if(selection == 3) {
			((FederalResume) currentFederalResume).eraseReferences();
			System.out.println("All references have been erased.");
		}
		
		return currentFederalResume;
	}
	
	public Resume processReferenceRemoval(Resume currentFederalResume) {
		System.out.println("Please enter the name of the reference you would like to delete (exactly as entered previously.");
		String referenceName = keyboardIn.nextLine();
		if(((FederalResume) currentFederalResume).removeReference(referenceName)) {
			System.out.println(referenceName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find reference with that name.");
		}
		
		return currentFederalResume;
	}

	@Override
	public void displayExitMessage() {
		System.out.println("Exiting Resume Builder...");
		System.out.println("Goodbye!");
	}

}
