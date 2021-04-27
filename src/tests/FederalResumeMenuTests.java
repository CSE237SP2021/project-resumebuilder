package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import resumeBuilder.Activity;
import resumeBuilder.ContactInformation;
import resumeBuilder.FederalJob;
import resumeBuilder.FederalResume;
import resumeBuilder.Job;
import resumeBuilder.References;
import resumeBuilder.School;

class FederalResumeMenuTests {
	Scanner keyboardIn = new Scanner(System.in);
	
	@Test
	void testProcessContactInformation() {
		System.out.println("Please enter your full name.");
		String fullName = keyboardIn.nextLine();
		char [] name_char_array = fullName.toCharArray();
		for (char letter : name_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("Please enter your email.");
		String email = keyboardIn.nextLine(); 
		if((email.contains("@")) && (email.contains(".com"))) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		System.out.println("Please enter your phone number (e.g. 'xxx-xxx-xxxx').");
		String phoneNumber = keyboardIn.nextLine();
		char [] num_char_array = phoneNumber.toCharArray();
		for (char digit : num_char_array) {
			if (Character.isDigit(digit) || (digit == '-')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("Please enter your address.");
		String address = keyboardIn.nextLine();
		char [] address_array = address.toCharArray();
		for (char character : address_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertFalse(false);
			}
		}
		
		ContactInformation currentContactInfo = new ContactInformation(fullName, email, phoneNumber, address);
		assertNotNull(currentContactInfo);
		
		FederalResume federalResume = new FederalResume();
		assertNotNull(federalResume);
		
		federalResume.setContactInfo(currentContactInfo);
		
		if (currentContactInfo.equals(federalResume.getContactInfo())) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
	}
	
	@Test
	void testProcessAcademicInformation() {
		
		System.out.println("Please enter your the name of the academic institution you would like to add.");
		String schoolName = keyboardIn.nextLine(); 
		char [] school_name_char_array = schoolName.toCharArray();
		for (char letter : school_name_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("Where is "+schoolName+" located? (e.g. 'St. Louis, MO')");
		String schoolLocation = keyboardIn.nextLine(); 
		char [] school_location_char_array = schoolLocation.toCharArray();
		for (char letter : school_location_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ' || (letter == '.') || (letter == ','))) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("What is/was your GPA at "+schoolName+"?");
		double gpa = 0.0;
		try {
			gpa = Double.parseDouble(keyboardIn.nextLine());
			if(gpa >= 8.0 || gpa < 0.0) {
				assertTrue(false);
			}
		} catch (NumberFormatException formatError) {
			assertTrue(false);
		}
		
		System.out.println("When did you start attending "+schoolName+"? (e.g. August 2018)");
		String startDate = keyboardIn.nextLine(); 
		char [] start_date_array = startDate.toCharArray();
		for (char character : start_date_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("When did you stop attending "+schoolName+"? (If still attending, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		char [] end_date_array = endDate.toCharArray();
		for (char character : end_date_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		School currentSchool = new School(startDate, endDate, schoolName, schoolLocation, gpa);
		assertNotNull(currentSchool);
		
		FederalResume federalResume = new FederalResume();
		assertNotNull(federalResume);
		
		federalResume.addSchool(currentSchool);
		
		boolean schoolExistsInArray = false;
		for (School school : federalResume.getSchools()) {
			if (school.equals(currentSchool)) {
				schoolExistsInArray = true;
			}
		}
		
		assertTrue(schoolExistsInArray);
	}
	
	@Test 
	void processWorkExperience() {
		
		System.out.println("Please enter your the name of the company you would like to add.");
		String companyName = keyboardIn.nextLine(); 
		char [] company_name_char_array = companyName.toCharArray();
		for (char letter : company_name_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("When did you start working at "+companyName+"?");
		String startDate = keyboardIn.nextLine(); 
		char [] start_date_array = startDate.toCharArray();
		for (char character : start_date_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("When did you stop working at "+companyName+"? (If still employed, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		char [] end_date_array = endDate.toCharArray();
		for (char character : end_date_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("What was your title at "+companyName+"?");
		String jobTitle = keyboardIn.nextLine();
		char [] title_array = startDate.toCharArray();
		for (char character : title_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		Job currentJob = new Job(jobTitle, startDate, endDate, companyName);
		assertNotNull(currentJob);
		
		FederalResume federalResume = new FederalResume();
				
		federalResume.addJob(currentJob);
		
		boolean jobExistsInArray = false;
		for (Job job : federalResume.getJobs()) {
			if (job.equals(currentJob)) {
				jobExistsInArray = true;
			}
		}
		
		assertTrue(jobExistsInArray);		
	}
	
	@Test
	void processFederalWorkExperience() {
		System.out.println("Please enter your the name of the company you would like to add.");
		String companyName = keyboardIn.nextLine(); 
 
		
		System.out.println("When did you start working at "+companyName+"?");
		String startDate = keyboardIn.nextLine();
		char [] start_date_array = startDate.toCharArray();
		for (char character : start_date_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("When did you stop working at "+companyName+"? (If still employed, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		char [] end_date_array = endDate.toCharArray();
		for (char character : end_date_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("What was your title at "+companyName+"?");
		String jobTitle = keyboardIn.nextLine(); 
		char [] title_array = startDate.toCharArray();
		for (char character : title_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("What was your GS Level at "+companyName+"? (Press enter if not applicable)");
		String GSLevel = keyboardIn.nextLine(); 
		char [] gs_level_array = GSLevel.toCharArray();
		for (char character : gs_level_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ' || character == '-') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("What was your salary at "+companyName+"?");
		String salary = keyboardIn.nextLine();
		char [] salary_array = salary.toCharArray();
		for (char character : salary_array) {
			if (Character.isDigit(character) || character == '$' || character == '.' ) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		FederalJob currentFederalJob = new FederalJob(jobTitle, startDate, endDate, companyName, GSLevel, salary);
		assertNotNull(currentFederalJob);
		
		FederalResume federalResume = new FederalResume();
		assertNotNull(federalResume);
				
		federalResume.addFederalJob(currentFederalJob);
		
		boolean fedJobExistsInArray = false;
		for (FederalJob fedJob : federalResume.getFederalJobs()) {
			if (fedJob.equals(currentFederalJob)) {
				fedJobExistsInArray = true;
			}
		}
		
		assertTrue(fedJobExistsInArray);
	}
	
	@Test
	void processCitizenshipStatus() {
		System.out.println("Please enter your citizenship status (e.g., US Citizen, Work Visa.");
		String citizenshipStatus = keyboardIn.nextLine(); 
		char [] citizenship_status_char_array = citizenshipStatus.toCharArray();
		for (char letter : citizenship_status_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		FederalResume federalResume = new FederalResume();
		assertNotNull(federalResume);
		
		federalResume.setCitizenshipStatus(citizenshipStatus);
		if(citizenshipStatus != federalResume.getCitizenshipStatus()) {
			assertTrue(false);
		}

		assertTrue(true);
	}
	
	@Test
	void processClearance() {
		System.out.println("Please enter your clearance level (e.g., Top Secret, Secret). If you don't have a clearance, just press 'Enter.'");
		String clearance = keyboardIn.nextLine(); 
		char [] clearance_char_array = clearance.toCharArray();
		for (char letter : clearance_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		FederalResume federalResume = new FederalResume();
		assertNotNull(federalResume);
		
		federalResume.setClearance(clearance);
		if(clearance != federalResume.getClearance()) {
			assertTrue(false);
		}
		assertTrue(true);
	}
	
	@Test
	void processPurposeStatement() {
		System.out.println("Please enter a purpose statement about the roles you're looking for.");
		String purposeStatement = keyboardIn.nextLine(); 
		char [] purpose_char_array = purposeStatement.toCharArray();
		for (char letter : purpose_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		FederalResume federalResume = new FederalResume();
		assertNotNull(federalResume);
		
		federalResume.setPurposeStatement(purposeStatement);
		if(purposeStatement.equals(federalResume.getPurposeStatement())) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	void processVolunteerExperience() {
		System.out.println("Please enter your the name of the volunteer experience.");
		String orgName = keyboardIn.nextLine(); 
		char [] company_name_char_array = orgName.toCharArray();
		for (char letter : company_name_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("When did you start volunteering at "+orgName+"?");
		String startDate = keyboardIn.nextLine(); 
		char [] start_date_array = startDate.toCharArray();
		for (char character : start_date_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("When did you stop working at "+orgName+"? (If still employed, please say 'Present')");
		String endDate = keyboardIn.nextLine(); 
		char [] end_date_array = endDate.toCharArray();
		for (char character : end_date_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("What was your title at "+orgName+"?");
		String positionTitle = keyboardIn.nextLine(); 
		char [] title_array = positionTitle.toCharArray();
		for (char character : title_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		Activity currentActivity = new Activity(startDate, endDate, positionTitle, orgName);
		assertNotNull(currentActivity);
		
		FederalResume federalResume = new FederalResume();
		federalResume.addActivity(currentActivity);
		
		boolean activityExistsInArray = false;
		for (Activity activity : federalResume.getActivity()) {
			if (activity.equals(currentActivity)) {
				activityExistsInArray = true;
			}
		}
		
		assertTrue(activityExistsInArray);
	}
	
	@Test
	void processSkill() {
		String newSkill="";
		
		FederalResume federalResume = new FederalResume();
		
		while(!newSkill.equals("done")) {
			System.out.println("Please enter the next skill you would like to add. Or, type 'done' if you are finished.");
			
			newSkill=keyboardIn.nextLine();
			char [] skill_array = newSkill.toCharArray();
			for (char character : skill_array) {
				if (Character.isDigit(character) || Character.isLetter(character) || character == ' ' || character == '-') {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}
			
			if(!newSkill.equals("done")) {
				federalResume.addSkill(newSkill);
				boolean skillExistsInArray = false;
				for (String skill : federalResume.getSkills()) {
					if (skill.equals(newSkill)) {
						skillExistsInArray = true;
					}
				}
				assertTrue(skillExistsInArray);
			}
		}
		
		System.out.println("Exiting skills section...");
	}
	
	@Test
	void processReference() {
		System.out.println("Please enter the name of the reference you would like to add.");
		String newReferenceName = keyboardIn.nextLine();
		char [] name_char_array = newReferenceName.toCharArray();
		for (char letter : name_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("Please enter the email of " +newReferenceName+".");
		String referenceEmail = keyboardIn.nextLine(); 
		if((referenceEmail.contains("@")) && (referenceEmail.contains(".com"))) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		System.out.println("Please enter the phone number of " +newReferenceName+".");
		String referencePhoneNumber = keyboardIn.nextLine(); 
		char [] num_char_array = referencePhoneNumber.toCharArray();
		for (char digit : num_char_array) {
			if (Character.isDigit(digit) || (digit == '-')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("Where does " +newReferenceName+" work?");
		String referenceOrg = keyboardIn.nextLine(); 
		char [] company_name_char_array = referenceOrg.toCharArray();
		for (char letter : company_name_char_array) {
			if ((Character.isLetter(letter)) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
				
		References currentReference = new References();
		assertNotNull(currentReference);
		
		currentReference.addReferenceName(newReferenceName);
		if(newReferenceName.equals(currentReference.getReferenceName())) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		currentReference.addReferenceEmail(referenceEmail);
		if(referenceEmail.equals(currentReference.getReferenceEmail())) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		currentReference.addReferencePhoneNumber(referencePhoneNumber);
		if(referencePhoneNumber.equals(currentReference.getReferencePhoneNumber())) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		currentReference.addReferenceOrganization(referenceOrg);
		if(referenceOrg.equals(currentReference.getReferenceOrganization())) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		FederalResume federalResume = new FederalResume();
		assertNotNull(federalResume);
		federalResume.addReference(currentReference);
		
		boolean referenceExistsInArray = false;
		for (References reference : federalResume.getReferences()) {
			if (reference.equals(currentReference)) {
				referenceExistsInArray = true;
			}
		}
		
		assertTrue(referenceExistsInArray);

	}
	
}	
