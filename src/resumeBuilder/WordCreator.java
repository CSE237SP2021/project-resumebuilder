package resumeBuilder;

import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;

public class WordCreator {
  
	private static final int successfulSave =0;
	private static final int noFilePathGiven =1;
	private static final int defaultFile =2;
  
	private Resume resume;
	private String destination;
	
	public WordCreator(Resume resume, String destination) {
		this.resume = resume;
		this.destination = destination;
	}
	
	public int createWordDocument() {
		if(resume instanceof StandardResume) {
			return createStandardResume();
		} else if(resume instanceof FederalResume) {
			return createFederalResume();
		} else if(resume instanceof UndergradResearchResume) {
			return createUndergradResearchResume();
		} else {
			return createTechnicalResume();
		}
	}
	
	/** Adds contact information to resume header
	 * 
	 * @param section section to add to in word doc
	 */
	public void addContactInfo(Section section) {
		Paragraph name = section.addParagraph();
		name.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
		name.getFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);	
		TextRange tr = name.appendText(resume.getContactInfo().getName()+ "\n");
		tr.getCharacterFormat().setBold(true);
		tr.getCharacterFormat().setFontSize(18);
		
		//add email/phone/address below border line
		Paragraph otherPersonalInfo = section.addParagraph();
		otherPersonalInfo.appendText(resume.getContactInfo().getEmail());
		otherPersonalInfo.appendText("       "+resume.getContactInfo().getPhoneNumber());
		otherPersonalInfo.appendText("       "+resume.getContactInfo().getAddress());
	}
	
	/** Adds 'Education' section to word doc
	 * 
	 * @param section section to add to in word doc
	 */
	public void addEducation(Section section) {
		if(resume.getSchools().size() > 0) {
			Paragraph educationHeader = section.addParagraph();
			
			educationHeader.getFormat().setBeforeAutoSpacing(false);
			educationHeader.getFormat().setBeforeSpacing(10);
			
			TextRange educationTR = educationHeader.appendText("Education");
			educationTR.getCharacterFormat().setFontSize(14);
			educationTR.getCharacterFormat().setBold(true);
			for(School school: resume.getSchools()) {
				//add school info, such as name/location/dates
				Paragraph schoolName = section.addParagraph();
				schoolName.getFormat().setLeftIndent(30);
				TextRange tr = schoolName.appendText(school.getSchoolName()+ ", " +school.getSchoolLocation());
				tr.getCharacterFormat().setBold(true);
				tr.getCharacterFormat().setFontSize(12);
				schoolName.appendText("          "+school.getStartDate()+"-"+school.getEndDate());
				
				//add GPA and label for honors/awards
				Paragraph gpa = section.addParagraph();
				gpa.getFormat().setLeftIndent(30);
				gpa.appendText("GPA: "+ school.getGPA());
				
				if(school.getHonorsAwards().size() > 0) {
					Paragraph honors_awards = section.addParagraph();
					honors_awards.getFormat().setLeftIndent(30);
					honors_awards.appendText("Honors/Awards:");
					
					//add honors/awards
					for(String award: school.getHonorsAwards()) {
						Paragraph newAward = section.addParagraph();
						newAward.getFormat().setLeftIndent(60);
						newAward.appendText(award);
						newAward.getListFormat().applyBulletStyle();
					}
				}
				
			}
		}
	}
	
	/** Adds 'Work Experience' section to word doc
	 * 
	 * @param section section to add to in word doc
	 */
	public void addJobs(Section section) {
		if(resume.getJobs().size() > 0) {
			if(!(resume instanceof FederalResume)) {
				Paragraph jobsHeader = section.addParagraph();
				TextRange jobsTR = jobsHeader.appendText("Work Experience");
				jobsTR.getCharacterFormat().setFontSize(14);
				jobsTR.getCharacterFormat().setBold(true);
				jobsHeader.getFormat().setBeforeAutoSpacing(false);
				jobsHeader.getFormat().setBeforeSpacing(10);
			} else {
				FederalResume fedResume = (FederalResume)resume;
				if(fedResume.getFederalJobs().size() == 0) {
					Paragraph jobsHeader = section.addParagraph();
					TextRange jobsTR = jobsHeader.appendText("Work Experience");
					jobsTR.getCharacterFormat().setFontSize(14);
					jobsTR.getCharacterFormat().setBold(true);
					jobsHeader.getFormat().setBeforeAutoSpacing(false);
					jobsHeader.getFormat().setBeforeSpacing(10);
				}
			}
		
		
			for(Job job : resume.getJobs()) {
				//add company and job title
				Paragraph newJob = section.addParagraph();
				newJob.getFormat().setLeftIndent(30);
				TextRange tr = newJob.appendText(job.getCompany() +", " +job.getJobTitle());
				tr.getCharacterFormat().setBold(true);
				tr.getCharacterFormat().setFontSize(12);
				newJob.appendText("                   " + job.getStartDate()+"-"+job.getEndDate());
				//add bullets describing job
				for(String description: job.getDescriptions()) {
					Paragraph newBullet = section.addParagraph();
					newBullet.getFormat().setLeftIndent(60);
					newBullet.appendText(description);
					newBullet.getListFormat().applyBulletStyle();
				}
			}
		}
	}
	
	public void addFederalJobs(Section section, FederalResume fedResume) {
		if(fedResume.getFederalJobs().size() > 0) {
			Paragraph jobsHeader = section.addParagraph();
			TextRange jobsTR = jobsHeader.appendText("Work Experience");
			jobsTR.getCharacterFormat().setFontSize(14);
			jobsTR.getCharacterFormat().setBold(true);
			jobsHeader.getFormat().setBeforeAutoSpacing(false);
			jobsHeader.getFormat().setBeforeSpacing(10);
			
			for(FederalJob federalJob : fedResume.getFederalJobs()) {
				//add company and job title
				Paragraph newJob = section.addParagraph();
				newJob.getFormat().setLeftIndent(30);
				TextRange tr = newJob.appendText(federalJob.getCompany() +", " +federalJob.getJobTitle());
				tr.getCharacterFormat().setBold(true);
				tr.getCharacterFormat().setFontSize(12);
				newJob.appendText("                   " + federalJob.getStartDate()+"-"+federalJob.getEndDate());
				
				if(!federalJob.getGSLevel().equals("")) {
					Paragraph gsLevel = section.addParagraph();
					gsLevel.getFormat().setLeftIndent(60);
					gsLevel.appendText("GS Level: " + federalJob.getGSLevel());
				}
				
				if(!federalJob.getSalary().equals("")) {
					Paragraph salary = section.addParagraph();
					salary.getFormat().setLeftIndent(60);
					salary.appendText("Salary: " + federalJob.getSalary());
				}
				//add bullets describing job
				for(String description: federalJob.getDescriptions()) {
					Paragraph newBullet = section.addParagraph();
					newBullet.getFormat().setLeftIndent(60);
					newBullet.appendText(description);
					newBullet.getListFormat().applyBulletStyle();
				}
			}
		}
	}
	
	/** Adds skills to word document. Overloads for each type of resume that has skills section
	 * 
	 * @param section section to add to in word doc
	 */
	public void addSkills(Section section, StandardResume stdResume) {
		if(stdResume.getSkills().size() > 0) {
			Paragraph skillsHeader = section.addParagraph();
			TextRange skillsTR = skillsHeader.appendText("Skills");
			skillsTR.getCharacterFormat().setFontSize(14);
			skillsTR.getCharacterFormat().setBold(true);
			skillsHeader.getFormat().setBeforeAutoSpacing(false);
			skillsHeader.getFormat().setBeforeSpacing(10);
			
			for(String skill: stdResume.getSkills()) {
				Paragraph newParagraph = section.addParagraph();
				newParagraph.appendText(skill);
				newParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
				newParagraph.getListFormat().applyBulletStyle();
			}
		}
	}
	
	public void addSkills(Section section, FederalResume fedResume) {
		if(fedResume.getSkills().size() > 0) {
			Paragraph skillsHeader = section.addParagraph();
			TextRange skillsTR = skillsHeader.appendText("Skills");
			skillsTR.getCharacterFormat().setFontSize(14);
			skillsTR.getCharacterFormat().setBold(true);
			skillsHeader.getFormat().setBeforeAutoSpacing(false);
			skillsHeader.getFormat().setBeforeSpacing(10);
			
			Paragraph newParagraph = section.addParagraph();
			
			int numSkills = fedResume.getSkills().size();
			for(int i = 0; i< numSkills-1; i++) {
				newParagraph.appendText(fedResume.getSkills().get(i) +", ");
			}
			if(numSkills != 0) {
				newParagraph.appendText(fedResume.getSkills().get(numSkills-1));
			}
		}
	}
	
	public void addSkills(Section section, UndergradResearchResume undergradResume) {
		if(undergradResume.getSkills().size() > 0) {
			Paragraph skillsHeader = section.addParagraph();
			TextRange skillsTR = skillsHeader.appendText("Skills");
			skillsTR.getCharacterFormat().setFontSize(14);
			skillsTR.getCharacterFormat().setBold(true);
			skillsHeader.getFormat().setBeforeAutoSpacing(false);
			skillsHeader.getFormat().setBeforeSpacing(10);
			
			for(String skill: undergradResume.getSkills()) {
				Paragraph newParagraph = section.addParagraph();
				newParagraph.appendText(skill);
				newParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
				newParagraph.getListFormat().applyBulletStyle();
			}
		}
	}
	
	public void addSkills(Section section, TechnicalResume techResume) {
		if(techResume.getProgrammingLanguageSkills().size() > 0) {
			Paragraph programmingLanguages = section.addParagraph();
			TextRange programmingTR = programmingLanguages.appendText("Programming Languages");
			programmingTR.getCharacterFormat().setFontSize(14);
			programmingTR.getCharacterFormat().setBold(true);
			programmingLanguages.getFormat().setBeforeAutoSpacing(false);
			programmingLanguages.getFormat().setBeforeSpacing(10);
			
			Paragraph newParagraph = section.addParagraph();
			
			int numSkills = techResume.getProgrammingLanguageSkills().size();
			for(int i = 0; i< numSkills-1; i++) {
				newParagraph.appendText(techResume.getProgrammingLanguageSkills().get(i) +", ");
			}
			if(numSkills != 0) {
				newParagraph.appendText(techResume.getProgrammingLanguageSkills().get(numSkills-1));
			}
		} 
		
		if(techResume.getSoftwareSkills().size() > 0) {
			Paragraph softwareSkills = section.addParagraph();
			TextRange softwareTR = softwareSkills.appendText("Software Skills");
			softwareTR.getCharacterFormat().setFontSize(14);
			softwareTR.getCharacterFormat().setBold(true);
			softwareSkills.getFormat().setBeforeAutoSpacing(false);
			softwareSkills.getFormat().setBeforeSpacing(10);
			
			Paragraph newParagraph = section.addParagraph();
			
			int numSkills = techResume.getSoftwareSkills().size();
			for(int i = 0; i< numSkills-1; i++) {
				newParagraph.appendText(techResume.getSoftwareSkills().get(i) +", ");
			}
			if(numSkills != 0) {
				newParagraph.appendText(techResume.getSoftwareSkills().get(numSkills-1));
			}
		}
	}
	
	/** Adds activities to document, overloaded for each resume requiring activities
	 * 
	 * @param section section to add to in document
	 */
	public void addActivities(Section section, FederalResume fedResume) {
		if(fedResume.getActivities().size() > 0) {
			Paragraph activitiesHeader = section.addParagraph();
			
			TextRange activitiesTR = activitiesHeader.appendText("Activities");
			activitiesTR.getCharacterFormat().setFontSize(14);
			activitiesTR.getCharacterFormat().setBold(true);
			activitiesHeader.getFormat().setBeforeAutoSpacing(false);
			activitiesHeader.getFormat().setBeforeSpacing(10);
			for(Activity activity : fedResume.getActivities()) {
				//add organization and activity title
				Paragraph newActivity = section.addParagraph();
				newActivity.getFormat().setLeftIndent(30);
				TextRange tr = newActivity.appendText(activity.getOrganization() +", " +activity.getRole());
				tr.getCharacterFormat().setBold(true);
				tr.getCharacterFormat().setFontSize(12);
				newActivity.appendText("                   " + activity.getStartDate()+"-"+activity.getEndDate());
				//add bullets describing activity
				for(String description: activity.getDescriptions()) {
					Paragraph newBullet = section.addParagraph();
					newBullet.getFormat().setLeftIndent(60);
					newBullet.appendText(description);
					newBullet.getListFormat().applyBulletStyle();
				}
			}
		}
	}
	
	public void addActivities(Section section, UndergradResearchResume undergradResume) {
		if(undergradResume.getActivities().size() > 0) {
			Paragraph activitiesHeader = section.addParagraph();
			
			TextRange activitiesTR = activitiesHeader.appendText("Activities");
			activitiesTR.getCharacterFormat().setFontSize(14);
			activitiesTR.getCharacterFormat().setBold(true);
			activitiesHeader.getFormat().setBeforeAutoSpacing(false);
			activitiesHeader.getFormat().setBeforeSpacing(10);
			for(Activity activity : undergradResume.getActivities()) {
				//add organization and activity title
				Paragraph newActivity = section.addParagraph();
				newActivity.getFormat().setLeftIndent(30);
				TextRange tr = newActivity.appendText(activity.getOrganization() +", " +activity.getRole());
				tr.getCharacterFormat().setBold(true);
				tr.getCharacterFormat().setFontSize(12);
				newActivity.appendText("                   " + activity.getStartDate()+"-"+activity.getEndDate());
				//add bullets describing activity
				for(String description: activity.getDescriptions()) {
					Paragraph newBullet = section.addParagraph();
					newBullet.getFormat().setLeftIndent(60);
					newBullet.appendText(description);
					newBullet.getListFormat().applyBulletStyle();
				}
			}
		}
	}
	
	public void addCertifications(Section section, UndergradResearchResume undergradResume) {
		if(undergradResume.getCertifications().size() > 0) {
			//TODO: complete this when we change UndergradResearch to use Certification object
		}
	}
	
	public void addCertifications(Section section, TechnicalResume techResume) {
		if(techResume.getCertifications().size() > 0) {
			Paragraph certificationsHeader = section.addParagraph();
			TextRange certificationsTR = certificationsHeader.appendText("Certifications");
			certificationsTR.getCharacterFormat().setBold(true);
			certificationsTR.getCharacterFormat().setFontSize(14);
			certificationsHeader.getFormat().setBeforeAutoSpacing(false);
			certificationsHeader.getFormat().setBeforeSpacing(10);
			
			for(Certification certification : techResume.getCertifications()) {
				Paragraph newCertification = section.addParagraph();
				newCertification.getFormat().setLeftIndent(30);
				TextRange certificationTitle = newCertification.appendText(certification.getCertificationTitle());
				certificationTitle.getCharacterFormat().setBold(true);
				certificationTitle.getCharacterFormat().setFontSize(12);
				
				Paragraph certificationOrg = section.addParagraph();
				certificationOrg.getFormat().setLeftIndent(30);
				certificationOrg.appendText(certification.getHostName()+", "+certification.getDateEarned());
				
				if(!certification.getDetails().equals("")) {
					Paragraph extraDetails = section.addParagraph();
					extraDetails.getFormat().setLeftIndent(30);
					extraDetails.appendText(certification.getDetails());
				}
			}
		}
	}
	
	 /**  Adds citizenship status and a couple other important details for Federal resume
	  * 
	  * @param section section to add to in document
	  */
	public void addFederalInfo(Section section) {
		FederalResume federalResume = (FederalResume)resume;
		
		Paragraph citizenStatus = section.addParagraph();
		TextRange citizenTR = citizenStatus.appendText("Citizenship: ");
		citizenTR.getCharacterFormat().setBold(true);
		citizenStatus.appendText(federalResume.getCitizenshipStatus());
		citizenStatus.getFormat().setBeforeAutoSpacing(false);
		citizenStatus.getFormat().setBeforeSpacing(10);
		
		Paragraph federalExperience = section.addParagraph();
		TextRange experienceTR = federalExperience.appendText("Federal Experience: ");
		experienceTR.getCharacterFormat().setBold(true);		
		federalExperience.appendText(federalResume.getFederalExperience());
		
		Paragraph clearance = section.addParagraph();
		TextRange clearanceTR = clearance.appendText("Clearance: ");
		clearanceTR.getCharacterFormat().setBold(true);
		
		clearance.appendText(federalResume.getClearance());
		
		
		Paragraph purposeHeader = section.addParagraph();
		purposeHeader.getFormat().setBeforeAutoSpacing(false);
		purposeHeader.getFormat().setBeforeSpacing(10);
		
		TextRange purposeTR = purposeHeader.appendText("Summary");
		purposeTR.getCharacterFormat().setFontSize(14);
		purposeTR.getCharacterFormat().setBold(true);
		Paragraph purpose = section.addParagraph();
		purpose.appendText(federalResume.getPurposeStatement());	
	}
	
	 /**
	  * Adds references to FederalResume
	  * @param section section to add to
	  */
	public void addReferences(Section section) {
		FederalResume federalResume = (FederalResume)resume;
		if(federalResume.getReferences().size() > 0) {
		
			Paragraph referencesHeader = section.addParagraph();
			
			TextRange referencesTR = referencesHeader.appendText("References");
			referencesTR.getCharacterFormat().setBold(true);
			referencesTR.getCharacterFormat().setFontSize(14);
			referencesHeader.getFormat().setBeforeAutoSpacing(false);
			referencesHeader.getFormat().setBeforeSpacing(10);
			
			for(References reference : federalResume.getReferences()) {
				Paragraph newReference = section.addParagraph();
				newReference.appendText(reference.getReferenceName()+", "+reference.getReferenceOrganization()+", "+
				reference.getReferenceEmail() + ", " + reference.getReferencePhoneNumber());
				newReference.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
				newReference.getListFormat().applyBulletStyle();
			}
		}
	}
	
	public void addMemberships(Section section, UndergradResearchResume undergradResume) {
		if(undergradResume.getMemberships().size() > 0) {
			Paragraph membershipsHeader = section.addParagraph();
			TextRange membershipsTR = membershipsHeader.appendText("Memberships");
			membershipsTR.getCharacterFormat().setFontSize(14);
			membershipsTR.getCharacterFormat().setBold(true);
			membershipsHeader.getFormat().setBeforeAutoSpacing(false);
			membershipsHeader.getFormat().setBeforeSpacing(10);
			
			for(String membership: undergradResume.getMemberships()) {
				Paragraph newParagraph = section.addParagraph();
				newParagraph.appendText(membership);
				newParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
				newParagraph.getListFormat().applyBulletStyle();
			}
		}
	}
	
	public void addConferences(Section section, UndergradResearchResume undergradResume) {
		if(undergradResume.getConferences().size() > 0) {
			Paragraph conferencesHeader = section.addParagraph();
			TextRange conferencesTR = conferencesHeader.appendText("Conferences");
			conferencesTR.getCharacterFormat().setFontSize(14);
			conferencesTR.getCharacterFormat().setBold(true);
			conferencesHeader.getFormat().setBeforeAutoSpacing(false);
			conferencesHeader.getFormat().setBeforeSpacing(10);
			
			for(String conference: undergradResume.getConferences()) {
				Paragraph newParagraph = section.addParagraph();
				newParagraph.appendText(conference);
				newParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
				newParagraph.getListFormat().applyBulletStyle();
			}
		}
	}
	
	public void addProjects(Section section, TechnicalResume techResume) {
		
	}

	/**
	 * Logic to save word doc to file
	 * @param document document to be saved
	 * @param docTitle name of the file (file path) to be saved
	 * @return
	 */
	public int saveFile(Document document, String docTitle) {
		try {
			document.saveToFile(destination, FileFormat.Docx);
			System.out.println("Thanks for using ResumeBuilder! Finishing program.");
			return successfulSave;
		} catch (Exception e) {
			if (destination.contentEquals("")) {
			
				System.out.println("No file path given, file saved in default file path: \"output/resume.docx\"");
				document.saveToFile("output/resume" + docTitle + ".docx", FileFormat.Docx);
				return noFilePathGiven;
			} else {
				System.out.println("Invalid File Path, file saved in default file \"output/resume.docx\"");
				document.saveToFile("output/resume" + docTitle + ".docx", FileFormat.Docx);
				return defaultFile;
			}
			
		}
	}
	
	public int createStandardResume() {
		StandardResume standardResume = (StandardResume)resume;
		Document document = new Document();
		Section section = document.addSection();
		String docTitle = "";
		if(resume.getContactInfo() != null) {
			addContactInfo(section);
			String name = resume.getContactInfo().getName();
			docTitle = name.replaceAll("\\s", "");
			
		}
		addEducation(section);
		addJobs(section);
		addSkills(section, standardResume);
		
		return saveFile(document, docTitle);
	}
	
	public int createFederalResume() {
		FederalResume federalResume = (FederalResume)resume;
		Document document = new Document();
		Section section = document.addSection();
		String docTitle = "";
		if(resume.getContactInfo() != null) {
			addContactInfo(section);
			String name = resume.getContactInfo().getName();
			docTitle = name.replaceAll("\\s","");
		}
		addFederalInfo(section);
		addFederalJobs(section, federalResume);
		addJobs(section);
		addActivities(section, federalResume);
		addEducation(section);
		addSkills(section, federalResume);
		addReferences(section);
		return saveFile(document, docTitle);
		
	}
	
	public int createUndergradResearchResume() {
		UndergradResearchResume undergradResearchResume = (UndergradResearchResume)resume;
		Document document = new Document();
		Section section = document.addSection();
		String docTitle = "";
		if(resume.getContactInfo() != null) {
			addContactInfo(section);
			String name = resume.getContactInfo().getName();
			docTitle = name.replaceAll("\\s","");
		}
		
		addEducation(section);
		addJobs(section);
		addActivities(section, undergradResearchResume);
		addConferences(section, undergradResearchResume);
		addMemberships(section,undergradResearchResume);
		addCertifications(section, undergradResearchResume);
		addSkills(section, undergradResearchResume);
		return saveFile(document, docTitle);
	}
	
	public int createTechnicalResume() {
		TechnicalResume technicalResume = (TechnicalResume)resume;
		Document document = new Document();
		Section section = document.addSection();
		String docTitle = "";
		if(resume.getContactInfo() != null) {
			addContactInfo(section);
			String name = resume.getContactInfo().getName();
			docTitle = name.replaceAll("\\s","");
		}
		
		addJobs(section);
		addEducation(section);
		addProjects(section, technicalResume);
		addCertifications(section, technicalResume);
		addSkills(section, technicalResume);
		return saveFile(document, docTitle);
	}
}