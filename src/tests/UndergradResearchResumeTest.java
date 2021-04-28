package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import resumeBuilder.Activity;
import resumeBuilder.Certification;
import resumeBuilder.ContactInformation;
import resumeBuilder.Job;
import resumeBuilder.School;
import resumeBuilder.UndergradResearchResume;

class UndergradResearchResumeTest {
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
		
		UndergradResearchResume undergradResearchResume = new UndergradResearchResume();
		assertNotNull(undergradResearchResume);
		
		undergradResearchResume.setContactInfo(currentContactInfo);
		
		if (currentContactInfo.equals(undergradResearchResume.getContactInfo())) {
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
		
		UndergradResearchResume undergradResearchResume = new UndergradResearchResume();
		assertNotNull(undergradResearchResume);
		
		undergradResearchResume.addSchool(currentSchool);
		
		boolean schoolExistsInArray = false;
		for (School school : undergradResearchResume.getSchools()) {
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
		
		UndergradResearchResume undergradResearchResume = new UndergradResearchResume();
				
		undergradResearchResume.addJob(currentJob);
		
		boolean jobExistsInArray = false;
		for (Job job : undergradResearchResume.getJobs()) {
			if (job.equals(currentJob)) {
				jobExistsInArray = true;
			}
		}
		
		assertTrue(jobExistsInArray);		
	}
	
	@Test
	void processActivity() {
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
		
		UndergradResearchResume undergradResearchResume = new UndergradResearchResume();
		undergradResearchResume.addActivity(currentActivity);
		
		boolean activityExistsInArray = false;
		for (Activity activity : undergradResearchResume.getActivities()) {
			if (activity.equals(currentActivity)) {
				activityExistsInArray = true;
			}
		}
		
		assertTrue(activityExistsInArray);
	}
	
	@Test
	void processSkill() {
		String newSkill="";
		
		UndergradResearchResume undergradResearchResume = new UndergradResearchResume();
		assertNotNull(undergradResearchResume);
		
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
				undergradResearchResume.addSkill(newSkill);
				boolean skillExistsInArray = false;
				for (String skill : undergradResearchResume.getSkills()) {
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
	void processCertifications() {
		
		System.out.println("Please enter the title of the certification you would like to add.");
		String certificationTitle = keyboardIn.nextLine(); 
		char [] certification_name_char_array = certificationTitle.toCharArray();
		for (char letter : certification_name_char_array) {
			if ((Character.isLetter(letter)) || Character.isDigit(letter) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("When did you earn "+certificationTitle+"?");
		String dateEarned = keyboardIn.nextLine();
		char [] date_array = dateEarned.toCharArray();
		for (char character : date_array) {
			if (Character.isDigit(character) || Character.isLetter(character) || character == ' ') {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("Please enter the name of the host/organization for your "+certificationTitle+".");
		String hostName = keyboardIn.nextLine(); 
		char [] host_name_char_array = hostName.toCharArray();
		for (char letter : host_name_char_array) {
			if ((Character.isLetter(letter)) || Character.isDigit(letter) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		System.out.println("Please enter any relevant details for "+certificationTitle+". (Optional: Hit return to skip.)");
		String details = keyboardIn.nextLine(); 
		char [] details_char_array = certificationTitle.toCharArray();
		for (char letter : details_char_array) {
			if ((Character.isLetter(letter)) || Character.isDigit(letter) || (letter == ' ')) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		
		Certification currentCertification = new Certification(certificationTitle, hostName, dateEarned, details);
		assertNotNull(currentCertification);
		
		UndergradResearchResume undergradResearchResume = new UndergradResearchResume();
		
		undergradResearchResume.addCertification(currentCertification);
		boolean certExistsInArray = false;
		for (Certification certification : undergradResearchResume.getCertifications()) {
			if (certification.equals(currentCertification)) {
				certExistsInArray = true;
			}
		}
		
		assertTrue(certExistsInArray);	
		
	}
	
	@Test
	void processMembership() {
		String newMembership="";
		
		UndergradResearchResume undergradResearchResume = new UndergradResearchResume();
		assertNotNull(undergradResearchResume);
		
		while(!newMembership.equals("done")) {
			System.out.println("Please enter the next membership you would like to add. Or, type 'done' if you are finished.");
			
			newMembership=keyboardIn.nextLine();
			char [] membership_char_array = newMembership.toCharArray();
			for (char letter : membership_char_array) {
				if ((Character.isLetter(letter)) || Character.isDigit(letter) || (letter == ' ')) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}
			
			if(!newMembership.equals("done")) {
				undergradResearchResume.addMemberships(newMembership);
				boolean memExistsInArray = false;
				for (String membership : undergradResearchResume.getMemberships()) {
					if (membership.equals(newMembership)) {
						memExistsInArray = true;
					}
				}
				
				assertTrue(memExistsInArray);	
				
			}
		}
		
		System.out.println("Exiting memberships section...");
		
	}
	
	@Test
	void processConference() {
		String newConference="";
		
		UndergradResearchResume undergradResearchResume = new UndergradResearchResume();
		assertNotNull(undergradResearchResume);

		while(!newConference.equals("done")) {
			System.out.println("Please enter the next conference you would like to add. Or, type 'done' if you are finished.");
			
			newConference=keyboardIn.nextLine();
			char [] conference_char_array = newConference.toCharArray();
			for (char letter : conference_char_array) {
				if ((Character.isLetter(letter)) || Character.isDigit(letter) || (letter == ' ')) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}
			
			if(!newConference.equals("done")) {
				undergradResearchResume.addConferences(newConference);
				boolean conferencesExistsInArray = false;
				for (String conference : undergradResearchResume.getConferences()) {
					if (conference.equals(newConference)) {
						conferencesExistsInArray = true;
					}
				}
				
				assertTrue(conferencesExistsInArray);
			}
		}
		
		System.out.println("Exiting conferences section...");
		
	}

}
