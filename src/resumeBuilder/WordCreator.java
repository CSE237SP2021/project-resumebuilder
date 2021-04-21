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
	
	/** Adds 'Work Experience' section to word doc
	 * 
	 * @param section section to add to in word doc
	 */
	public void addJobs(Section section) {
		if(resume.getJobs().size() > 0) {
			Paragraph jobsHeader = section.addParagraph();
			TextRange jobsTR = jobsHeader.appendText("Work Experience");
			jobsTR.getCharacterFormat().setFontSize(14);
			jobsTR.getCharacterFormat().setBold(true);
			jobsHeader.getFormat().setBeforeAutoSpacing(false);
			jobsHeader.getFormat().setBeforeSpacing(10);
		
		
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
		
	}
	
	public void addCertifications(Section section, TechnicalResume techResume) {
		
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
		
	}
	
	public void addConferences(Section section, UndergradResearchResume undergradResume) {

		
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
		
		addJobs(section);
		addActivities(section, undergradResearchResume);
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
		return saveFile(document, docTitle);
	}
}