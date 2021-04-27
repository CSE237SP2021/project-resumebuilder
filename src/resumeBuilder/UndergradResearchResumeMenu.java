package resumeBuilder;

import java.util.Scanner;

public class UndergradResearchResumeMenu implements Menu {
	
	public Scanner keyboardIn = new Scanner(System.in);

	@Override
	public void runMenu() {
		Resume currentUndergradResearchResume = new UndergradResearchResume();
		displayMenu();
		int undergradResearchResumeOption = getMenuSelection();
		processMenu(undergradResearchResumeOption, currentUndergradResearchResume);		
	}

	@Override
	public void displayMenu() {
		System.out.println("Please select the information you would like to add/edit next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Research and/or Work Experience");
		System.out.println("4. Activities and Leadership");
		System.out.println("5. Skills");
		System.out.println("6. Certifications");
		System.out.println("7. Organizational Memberships");
		System.out.println("8. Conferences Attended/Presented");
		System.out.println("9. View current content");
		System.out.println("10. Save as word document");
		System.out.println("11. Exit");
	}

	@Override
	public void displayExitMessage() {
		System.out.println("Exiting Resume Builder...");
		System.out.println("Goodbye!");		
	}

	@Override
	public int getMenuSelection() {
		return Integer.parseInt(keyboardIn.nextLine());
	}

	@Override
	public void processMenu(int undergradResearchResumeOption, Resume currentUndergradResearchResume) {
		if(undergradResearchResumeOption==1) {
			currentUndergradResearchResume=processContactInformation(currentUndergradResearchResume);
			resetMenu(currentUndergradResearchResume);
		} else if (undergradResearchResumeOption==2) {
			currentUndergradResearchResume=addOrRemoveSchool(currentUndergradResearchResume);
			resetMenu(currentUndergradResearchResume);
		} else if (undergradResearchResumeOption==3) {
			currentUndergradResearchResume=addOrRemoveJob(currentUndergradResearchResume);
			resetMenu(currentUndergradResearchResume);
		} else if (undergradResearchResumeOption==4) {				
			currentUndergradResearchResume=addOrRemoveActivity(currentUndergradResearchResume);
			resetMenu(currentUndergradResearchResume);
		} else if (undergradResearchResumeOption==5) {				
			currentUndergradResearchResume=addOrRemoveSkill(currentUndergradResearchResume);
			resetMenu(currentUndergradResearchResume);
		} else if (undergradResearchResumeOption==6) {				
			currentUndergradResearchResume=addOrRemoveCertification(currentUndergradResearchResume);
			resetMenu(currentUndergradResearchResume);
		} else if (undergradResearchResumeOption==7) {				
			currentUndergradResearchResume=processMembership((UndergradResearchResume) currentUndergradResearchResume);
			resetMenu(currentUndergradResearchResume);
		} else if (undergradResearchResumeOption==8) {				
			currentUndergradResearchResume=processConference((UndergradResearchResume) currentUndergradResearchResume);
			resetMenu(currentUndergradResearchResume);
		}  else if (undergradResearchResumeOption==9) {	
			((UndergradResearchResume) currentUndergradResearchResume).printUndergradResearchResume();
			resetMenu(currentUndergradResearchResume);
		} else if (undergradResearchResumeOption==10) {
			System.out.println("Cannot create Word document for this resume template yet.");
//			String filePath = promptForDestination();
//			WordCreator wordCreator = new WordCreator((StandardResume) currentStandardResume, filePath);
//			wordCreator.createWordDocument();
		} else {
			displayExitMessage();
			return;
		}
	}

	@Override
	public Resume processContactInformation(Resume currentUndergradResearchResume) {
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
		
		currentUndergradResearchResume.setContactInfo(currentContactInfo);
		
		return currentUndergradResearchResume;
	}

	@Override
	public Resume processAcademicInformation(Resume currentUndergradResearchResume) {
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
		
		currentUndergradResearchResume.addSchool(currentSchool);
		
		return currentUndergradResearchResume;
	}

	@Override
	public Resume processWorkExperience(Resume currentUndergradResearchResume) {
		System.out.println("Please enter your the name of the organization, lab, or company you would like to add.");
		String companyName = keyboardIn.nextLine(); 
		
		System.out.println("When did you start working at "+companyName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you stop working at "+companyName+"? (If still employed, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		System.out.println("What was your title at "+companyName+"?");
		String jobTitle = keyboardIn.nextLine(); 
		
		Job currentJob = new Job(jobTitle, startDate, endDate, companyName);
		
		currentJob=promptForResponsibilities(currentJob);
		
		currentUndergradResearchResume.addJob(currentJob);
		
		return currentUndergradResearchResume;
	}
	
	private Resume processActivity(UndergradResearchResume currentUndergradResearchResume) {
		System.out.println("Please enter the name of your leadership, activity, or volunteer experience.");
		String orgName = keyboardIn.nextLine(); 
		
		System.out.println("When did you join "+orgName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you leave "+orgName+"? (If still volunteering, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		System.out.println("What was your title at "+orgName+"?");
		String positionTitle = keyboardIn.nextLine(); 
		
		Activity currentActivity = new Activity(startDate, endDate, positionTitle, orgName);
				
		currentActivity=promptForTasks(currentActivity);
		
		currentUndergradResearchResume.addActivity(currentActivity);
		
		return currentUndergradResearchResume;
				
	}

	private Activity promptForTasks(Activity currentActivity) {
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
	
	private Resume processSkill(UndergradResearchResume currentUndergradResearchResume) {
		String newSkill="";
		
		while(!newSkill.equals("done")) {
			System.out.println("Please enter the next skill you would like to add. Or, type 'done' if you are finished.");
			
			newSkill=keyboardIn.nextLine();
			
			if(!newSkill.equals("done")) {
				currentUndergradResearchResume.addSkill(newSkill);
			}
		}
		
		System.out.println("Exiting skills section...");
		
		return currentUndergradResearchResume;
	}
	
	private Resume processCertification(UndergradResearchResume currentUndergradResearchResume) {
		System.out.println("Please enter the title of the certification you would like to add.");
		String certificationTitle = keyboardIn.nextLine(); 
		
		System.out.println("When did you earn "+certificationTitle+"?");
		String dateEarned = keyboardIn.nextLine(); 
		
		System.out.println("Please enter the name of the host/organization for your "+certificationTitle+".");
		String hostName = keyboardIn.nextLine(); 
		
		System.out.println("Please enter any relevant details for "+certificationTitle+". (Optional: Hit return to skip.)");
		String details = keyboardIn.nextLine(); 
		
		Certification currentCertification = new Certification(certificationTitle, hostName, dateEarned, details);
		
		currentUndergradResearchResume.addCertification(currentCertification);
		
		System.out.println("Exiting certifications section...");
		
		return currentUndergradResearchResume;
	}
	
	private Resume processMembership(UndergradResearchResume currentUndergradResearchResume) {
		String newMembership="";
		
		while(!newMembership.equals("done")) {
			System.out.println("Please enter the next membership you would like to add. Or, type 'done' if you are finished.");
			
			newMembership=keyboardIn.nextLine();
			
			if(!newMembership.equals("done")) {
				currentUndergradResearchResume.addMemberships(newMembership);
			}
		}
		
		System.out.println("Exiting memberships section...");
		
		return currentUndergradResearchResume;
	}
	
	private Resume processConference(UndergradResearchResume currentUndergradResearchResume) {
		String newConference="";
		
		while(!newConference.equals("done")) {
			System.out.println("Please enter the next conference you would like to add. Or, type 'done' if you are finished.");
			
			newConference=keyboardIn.nextLine();
			
			if(!newConference.equals("done")) {
				currentUndergradResearchResume.addConferences(newConference);
			}
		}
		
		System.out.println("Exiting conferences section...");
		
		return currentUndergradResearchResume;
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
	
	public Resume addOrRemoveSchool(Resume currentUndergradResearchResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentUndergradResearchResume=processAcademicInformation(currentUndergradResearchResume);	
		} else if(selection == 2) {
			currentUndergradResearchResume=processSchoolRemoval(currentUndergradResearchResume);
		} else if(selection == 3) {
			((UndergradResearchResume) currentUndergradResearchResume).eraseSchools();
			System.out.println("All academic history has been erased.");
		}
		
		return currentUndergradResearchResume;
	}
	
	public Resume processSchoolRemoval(Resume currentUndergradResearchResume) {
		System.out.println("Please enter the name of the school you would like to delete (exactly as entered previously.");
		String schoolName = keyboardIn.nextLine();
		if(((UndergradResearchResume) currentUndergradResearchResume).removeSchool(schoolName)) {
			System.out.println(schoolName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find school with that name.");
		}
		
		return currentUndergradResearchResume;
	}
	
	public Resume addOrRemoveJob(Resume currentUndergradResearchResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentUndergradResearchResume=processWorkExperience(currentUndergradResearchResume);
		} else if(selection == 2) {
			currentUndergradResearchResume=processJobRemoval(currentUndergradResearchResume);
		} else if(selection == 3) {
			((UndergradResearchResume) currentUndergradResearchResume).eraseJobs();
			System.out.println("All work experience has been erased.");
		}
		
		return currentUndergradResearchResume;
	}
	
	public Resume processJobRemoval(Resume currentUndergradResearchResume) {
		System.out.println("Please enter the company name of the job or research experience you would like to delete (exactly as entered previously.");
		String companyName = keyboardIn.nextLine();
		if(((UndergradResearchResume) currentUndergradResearchResume).removeJob(companyName)) {
			System.out.println(companyName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find job or research experience with that company name.");
		}
		
		return currentUndergradResearchResume;
	}
	
	public Resume addOrRemoveActivity(Resume currentUndergradResearchResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentUndergradResearchResume=processActivity((UndergradResearchResume) currentUndergradResearchResume);
		} else if(selection == 2) {
			currentUndergradResearchResume=processActivityRemoval(currentUndergradResearchResume);
		} else if(selection == 3) {
			((UndergradResearchResume) currentUndergradResearchResume).eraseActivities();
			System.out.println("All activities have been erased.");
		}
		
		return currentUndergradResearchResume;
	}
	
	public Resume processActivityRemoval(Resume currentUndergradResearchResume) {
		System.out.println("Please enter the organization name of the activity you would like to delete (exactly as entered previously.");
		String organizationName = keyboardIn.nextLine();
		if(((UndergradResearchResume) currentUndergradResearchResume).removeActivity(organizationName)) {
			System.out.println(organizationName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find activity with that organization name.");
		}
		
		return currentUndergradResearchResume;
	}
	
	public Resume addOrRemoveSkill(Resume currentUndergradResearchResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentUndergradResearchResume=processSkill((UndergradResearchResume) currentUndergradResearchResume);
		} else if(selection == 2) {
			currentUndergradResearchResume=processSkillRemoval(currentUndergradResearchResume);
		} else if(selection == 3) {
			((UndergradResearchResume) currentUndergradResearchResume).eraseSkills();
			System.out.println("All skills been erased.");
		}
		
		return currentUndergradResearchResume;
	}
	
	public Resume processSkillRemoval(Resume currentUndergradResearchResume) {
		System.out.println("Please enter the skill you would like to delete (exactly as entered previously.");
		String skill = keyboardIn.nextLine();
		if(((UndergradResearchResume) currentUndergradResearchResume).removeSkill(skill)) {
			System.out.println(skill+" has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find that skill.");
		}
		
		return currentUndergradResearchResume;
	}
	
	public Resume addOrRemoveCertification(Resume currentUndergradResearchResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentUndergradResearchResume=processCertification((UndergradResearchResume) currentUndergradResearchResume);	
		} else if(selection == 2) {
			currentUndergradResearchResume=processCertificationRemoval(currentUndergradResearchResume);
		} else if(selection == 3) {
			((UndergradResearchResume) currentUndergradResearchResume).eraseCertifications();
			System.out.println("All certifications have been erased.");
		}
		
		return currentUndergradResearchResume;
	}
	
	public Resume processCertificationRemoval(Resume currentUndergradResearchResume) {
		System.out.println("Please enter the title of the certification you would like to delete (exactly as entered previously.");
		String certificationTitle = keyboardIn.nextLine();
		if(((UndergradResearchResume) currentUndergradResearchResume).removeCertification(certificationTitle)) {
			System.out.println(certificationTitle+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find certification with that title.");
		}
		
		return currentUndergradResearchResume;
	}

	@Override
	public void resetMenu(Resume currentUndergradResearchResume) {
		displayMenu();
		int undergradResearchResumeOption = getMenuSelection();
		processMenu(undergradResearchResumeOption, currentUndergradResearchResume);		
	}

	@Override
	public String promptForDestination() {
		System.out.println("What file path do you want your resume stored at? (Give absolute path. e.g. /Users/<username>/Desktop/<filename>.docx)");
		System.out.println("Don't forget to include the file name at the end!");
		return keyboardIn.nextLine();
	}

}
