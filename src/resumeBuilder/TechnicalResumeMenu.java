package resumeBuilder;

import java.util.Scanner;

public class TechnicalResumeMenu implements Menu {
	
	public Scanner keyboardIn = new Scanner(System.in);

	@Override
	public void runMenu() {
		Resume currentTechnicalResume = new TechnicalResume();
		displayMenu();
		int technicalResumeOption = getMenuSelection();
		processMenu(technicalResumeOption, currentTechnicalResume);
	}

	@Override
	public void displayMenu() {
		System.out.println("Please select the information you would like to add/edit next.");
		System.out.println("1. Contact Information");
		System.out.println("2. Academic History");
		System.out.println("3. Work Experience");
		System.out.println("4. Projects");
		System.out.println("5. Software Skills");
		System.out.println("6. Programming Language Skills");
		System.out.println("7. Certifications");
		System.out.println("8. View current content");
		System.out.println("9. Save as word document");
		System.out.println("10. Exit");
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
	public void processMenu(int technicalResumeOption, Resume currentTechnicalResume) {
		if(technicalResumeOption==1) {
			currentTechnicalResume=processContactInformation(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==2) {
			currentTechnicalResume=addOrRemoveSchool(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==3) {
			currentTechnicalResume=addOrRemoveJob(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==4) {				
			currentTechnicalResume=addOrRemoveProject(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==5) {				
			currentTechnicalResume=addOrRemoveSoftwareSkill(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==6) {				
			currentTechnicalResume=addOrRemoveProgrammingLanguageSkill(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==7) {				
			currentTechnicalResume=addOrRemoveCertification(currentTechnicalResume);
			resetMenu(currentTechnicalResume);
		} else if(technicalResumeOption==8) {
			((TechnicalResume) currentTechnicalResume).printTechnicalResume();
			resetMenu(currentTechnicalResume);
		} else if (technicalResumeOption==9) {				
			System.out.println("Word Doc creation currently unsupported for our technical resume template.");
			resetMenu(currentTechnicalResume);
//			String filePath = promptForDestination();
//			WordCreator wordCreator = new WordCreator(currentFederalResume, filePath);
//			wordCreator.createWordDocument();
		} else {
			displayExitMessage();
			return;
		}
	}

	@Override
	public Resume processContactInformation(Resume currentTechnicalResume) {
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
		
		currentTechnicalResume.setContactInfo(currentContactInfo);
		
		return currentTechnicalResume;
	}

	@Override
	public Resume processAcademicInformation(Resume currentTechnicalResume) {
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
		
		currentTechnicalResume.addSchool(currentSchool);
		
		return currentTechnicalResume;
	}

	@Override
	public Resume processWorkExperience(Resume currentTechnicalResume) {
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
		
		currentTechnicalResume.addJob(currentJob);
		
		return currentTechnicalResume;
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
	
	private TechnicalResume processProjectHistory(TechnicalResume currentTechnicalResume) {
		System.out.println("Please enter the name of the project.");
		String projectName = keyboardIn.nextLine(); 
		
		System.out.println("When did you start "+projectName+"?");
		String startDate = keyboardIn.nextLine(); 
		
		System.out.println("When did you finish "+projectName+"? (If still working on it, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		
		System.out.println("Please enter a brief summary of "+projectName+".");
		String projectSummary = keyboardIn.nextLine(); 
		
		Project currentProject = new Project(projectName, startDate, endDate, projectSummary);
		
		currentTechnicalResume.addProject(currentProject);
		
		return currentTechnicalResume;
	}
	
	private TechnicalResume processSkills(TechnicalResume currentTechnicalResume, String skillType) {
		String newSkill="";
		
		while(!newSkill.equals("done")) {
			System.out.println("Please enter the next "+skillType+" skill you would like to add. Or, type 'done' if you are finished.");
			
			newSkill=keyboardIn.nextLine();
			
			if(!newSkill.equals("done")) {
				if(skillType.equals("software")) {
					
					currentTechnicalResume.addSoftwareSkill(newSkill);
					
				} else if(skillType.equals("programming language")) {
					
					currentTechnicalResume.addProgrammingLanguageSkill(newSkill);
					
				} else {
					System.out.println("Error: You are attempting to add a skill with an invalid type.");
				}
			}
		}
		
		System.out.println("Exiting "+skillType+" skills section...");
		
		return currentTechnicalResume;
	}
	
	public Resume processCertifications(TechnicalResume currentTechnicalResume) {
		System.out.println("Please enter the title of the certification you would like to add.");
		String certificationTitle = keyboardIn.nextLine(); 
		
		System.out.println("When did you earn "+certificationTitle+"?");
		String dateEarned = keyboardIn.nextLine(); 
		
		System.out.println("Please enter the name of the host/organization for your "+certificationTitle+".");
		String hostName = keyboardIn.nextLine(); 
		
		System.out.println("Please enter any relevant details for "+certificationTitle+". (Optional: Hit return to skip.)");
		String details = keyboardIn.nextLine(); 
		
		Certification currentCertification = new Certification(certificationTitle, hostName, dateEarned, details);
		
		currentTechnicalResume.addCertification(currentCertification);
		
		return currentTechnicalResume;
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
	
	public Resume addOrRemoveSchool(Resume currentTechnicalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentTechnicalResume=processAcademicInformation(currentTechnicalResume);	
		} else if(selection == 2) {
			currentTechnicalResume=processSchoolRemoval(currentTechnicalResume);
		} else if(selection == 3) {
			((TechnicalResume) currentTechnicalResume).eraseSchools();
			System.out.println("All academic history has been erased.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume processSchoolRemoval(Resume currentTechnicalResume) {
		System.out.println("Please enter the name of the school you would like to delete (exactly as entered previously.");
		String schoolName = keyboardIn.nextLine();
		if(((TechnicalResume) currentTechnicalResume).removeSchool(schoolName)) {
			System.out.println(schoolName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find school with that name.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume addOrRemoveJob(Resume currentTechnicalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentTechnicalResume=processWorkExperience(currentTechnicalResume);	
		} else if(selection == 2) {
			currentTechnicalResume=processJobRemoval(currentTechnicalResume);
		} else if(selection == 3) {
			((TechnicalResume) currentTechnicalResume).eraseJobs();
			System.out.println("All work experience has been erased.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume processJobRemoval(Resume currentTechnicalResume) {
		System.out.println("Please enter the company name of the job you would like to delete (exactly as entered previously.");
		String companyName = keyboardIn.nextLine();
		if(((StandardResume) currentTechnicalResume).removeJob(companyName)) {
			System.out.println(companyName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find job with that company name.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume addOrRemoveProject(Resume currentTechnicalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentTechnicalResume=processProjectHistory((TechnicalResume) currentTechnicalResume);	
		} else if(selection == 2) {
			currentTechnicalResume=processProjectRemoval(currentTechnicalResume);
		} else if(selection == 3) {
			((TechnicalResume) currentTechnicalResume).eraseProjects();
			System.out.println("All projects have been erased.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume processProjectRemoval(Resume currentTechnicalResume) {
		System.out.println("Please enter the name of the project you would like to delete (exactly as entered previously.");
		String projectName = keyboardIn.nextLine();
		if(((TechnicalResume) currentTechnicalResume).removeProject(projectName)) {
			System.out.println(projectName+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find project with that name.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume addOrRemoveSoftwareSkill(Resume currentTechnicalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentTechnicalResume=processSkills((TechnicalResume) currentTechnicalResume, "software");
		} else if(selection == 2) {
			currentTechnicalResume=processSoftwareSkillRemoval(currentTechnicalResume);
		} else if(selection == 3) {
			((TechnicalResume) currentTechnicalResume).eraseSoftwareSkills();
			System.out.println("All skills been erased.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume processSoftwareSkillRemoval(Resume currentTechnicalResume) {
		System.out.println("Please enter the skill you would like to delete (exactly as entered previously.");
		String skill = keyboardIn.nextLine();
		if(((TechnicalResume) currentTechnicalResume).removeSoftwareSkill(skill)) {
			System.out.println(skill+" has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find that skill.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume addOrRemoveProgrammingLanguageSkill(Resume currentTechnicalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentTechnicalResume=processSkills((TechnicalResume) currentTechnicalResume, "programming language");
		} else if(selection == 2) {
			currentTechnicalResume=processProgrammingLanguageSkillRemoval(currentTechnicalResume);
		} else if(selection == 3) {
			((TechnicalResume) currentTechnicalResume).eraseProgrammingLanguageSkills();
			System.out.println("All skills been erased.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume processProgrammingLanguageSkillRemoval(Resume currentTechnicalResume) {
		System.out.println("Please enter the skill you would like to delete (exactly as entered previously.");
		String skill = keyboardIn.nextLine();
		if(((TechnicalResume) currentTechnicalResume).removeProgrammingLanguageSkill(skill)) {
			System.out.println(skill+" has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find that skill.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume addOrRemoveCertification(Resume currentTechnicalResume) {
		int selection = promptForAddOrRemove();
		
		if(selection == 1) {
			currentTechnicalResume=processCertifications((TechnicalResume) currentTechnicalResume);	
		} else if(selection == 2) {
			currentTechnicalResume=processCertificationRemoval(currentTechnicalResume);
		} else if(selection == 3) {
			((TechnicalResume) currentTechnicalResume).eraseCertifications();
			System.out.println("All certifications have been erased.");
		}
		
		return currentTechnicalResume;
	}
	
	public Resume processCertificationRemoval(Resume currentTechnicalResume) {
		System.out.println("Please enter the title of the certification you would like to delete (exactly as entered previously.");
		String certificationTitle = keyboardIn.nextLine();
		if(((TechnicalResume) currentTechnicalResume).removeCertification(certificationTitle)) {
			System.out.println(certificationTitle+" and all associated data has been deleted.");
		}
		else {
			System.out.println("Deletion unsuccessful. Couldn't find certification with that title.");
		}
		
		return currentTechnicalResume;
	}

	@Override
	public void resetMenu(Resume currentTechnicalResume) {
		displayMenu();
		int technicalResumeOption = getMenuSelection();
		processMenu(technicalResumeOption, currentTechnicalResume);
	}

	@Override
	public String promptForDestination() {
		System.out.println("What file path do you want your resume stored at? (Give absolute path. e.g. /Users/<username>/Desktop/<filename>.docx)");
		System.out.println("Don't forget to include the file name at the end!");
		return keyboardIn.nextLine();
	}

}
