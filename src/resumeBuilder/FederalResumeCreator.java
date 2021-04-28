package resumeBuilder;

import com.spire.doc.Document;
import com.spire.doc.Section;
import com.spire.doc.documents.BorderStyle;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.TextRange;

public class FederalResumeCreator {
	private FederalResume resume;
	
	public FederalResumeCreator(FederalResume resume) {
		this.resume = resume;
	}
	
	public Document createFederalResume() {
		Document document = new Document();
		Section section = document.addSection();
		if(resume.getContactInfo() != null) {
			addContactInfo(section);
		}
		addFederalInfo(section);
		addFederalJobs(section, resume);
		addJobs(section);
		addActivities(section, resume);
		addEducation(section);
		addSkills(section, resume);
		addReferences(section);
		return document;	
	}
	
	/** Adds contact information to resume header
	 * 
	 * @param section section to add to in word doc
	 */
	public void addContactInfo(Section section) {
		if(resume.getContactInfo().getName()!=null) {
			Paragraph name = section.addParagraph();
			TextRange tr = name.appendText(resume.getContactInfo().getName()+ "\n");
			tr.getCharacterFormat().setBold(true);
			tr.getCharacterFormat().setFontSize(18);
			
			//add email/phone/address below border line
			Paragraph otherPersonalInfo = section.addParagraph();
			otherPersonalInfo.appendText(resume.getContactInfo().getEmail());
			otherPersonalInfo.appendText("       "+resume.getContactInfo().getPhoneNumber());
			otherPersonalInfo.appendText("       "+resume.getContactInfo().getAddress());
			otherPersonalInfo.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
			otherPersonalInfo.getFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);	
		}
	}

	/**  Adds citizenship status and a couple other important details for Federal resume
	  * 
	  * @param section section to add to in document
	  */
	public void addFederalInfo(Section section) {
		if(resume.getCitizenshipStatus()!=null && !resume.getCitizenshipStatus().equals("") ) {
			Paragraph citizenStatus = section.addParagraph();
			TextRange citizenTR = citizenStatus.appendText("Citizenship: ");
			citizenTR.getCharacterFormat().setBold(true);
			citizenStatus.appendText(resume.getCitizenshipStatus());
			citizenStatus.getFormat().setBeforeAutoSpacing(false);
			citizenStatus.getFormat().setBeforeSpacing(10);
		}
		
		if(resume.getFederalExperience()!=null && !resume.getFederalExperience().equals("") ) {
			Paragraph federalExperience = section.addParagraph();
			TextRange experienceTR = federalExperience.appendText("Federal Experience: ");
			experienceTR.getCharacterFormat().setBold(true);		
			federalExperience.appendText(resume.getFederalExperience());
		}
		
		if(resume.getClearance()!=null && !resume.getClearance().equals("") ) {
			Paragraph clearance = section.addParagraph();
			TextRange clearanceTR = clearance.appendText("Clearance: ");
			clearanceTR.getCharacterFormat().setBold(true);
			
			clearance.appendText(resume.getClearance());
		}
		
		if(resume.getPurposeStatement()!=null && !resume.getPurposeStatement().equals("") ) {
			Paragraph purposeHeader = section.addParagraph();
			purposeHeader.getFormat().setBeforeAutoSpacing(false);
			purposeHeader.getFormat().setBeforeSpacing(10);
			
			TextRange purposeTR = purposeHeader.appendText("Summary");
			purposeTR.getCharacterFormat().setFontSize(14);
			purposeTR.getCharacterFormat().setBold(true);
			Paragraph purpose = section.addParagraph();
			purpose.appendText(resume.getPurposeStatement());
		}
	}

	/** Adds federal jobs to word doc 
	 * 
	 * @param section section in doc to add to
	 * @param fedResume federal resume to get information from 
	 */
	public void addFederalJobs(Section section, FederalResume fedResume) {
		if(fedResume.getFederalJobs().size() > 0) {
			Paragraph jobsHeader = section.addParagraph();
			TextRange jobsTR = jobsHeader.appendText("Work Experience");
			jobsTR.getCharacterFormat().setFontSize(14);
			jobsTR.getCharacterFormat().setBold(true);
			jobsHeader.getFormat().setBeforeAutoSpacing(false);
			jobsHeader.getFormat().setBeforeSpacing(10);
			
			for(int i = 0;i <fedResume.getFederalJobs().size(); i++) {
				FederalJob federalJob = fedResume.getFederalJobs().get(i);
				
				//add company and job title
				Paragraph newJob = section.addParagraph();
				newJob.getFormat().setLeftIndent(30);
				if(i!= 0) {
					newJob.getFormat().setBeforeAutoSpacing(false);
					newJob.getFormat().setBeforeSpacing(10);
				}
				TextRange tr = newJob.appendText(federalJob.getCompany() +", ");
				tr.getCharacterFormat().setBold(true);
				tr.getCharacterFormat().setFontSize(12);
				TextRange positionTR = newJob.appendText(federalJob.getJobTitle());
				positionTR.getCharacterFormat().setItalic(true);
				
				Paragraph dates = section.addParagraph();
				dates.getFormat().setLeftIndent(30);
				dates.appendText(federalJob.getStartDate()+"-"+federalJob.getEndDate());
				
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
	
	/** Adds 'Work Experience' section to word doc
	 * 
	 * @param section section to add to in word doc
	 */
	public void addJobs(Section section) {
		if(resume.getJobs().size() > 0) {
			if(resume.getFederalJobs().size() == 0) {
				Paragraph jobsHeader = section.addParagraph();
				TextRange jobsTR = jobsHeader.appendText("Work Experience");
				jobsTR.getCharacterFormat().setFontSize(14);
				jobsTR.getCharacterFormat().setBold(true);
				jobsHeader.getFormat().setBeforeAutoSpacing(false);
				jobsHeader.getFormat().setBeforeSpacing(10);
			}
		
			for(int i = 0; i < resume.getJobs().size(); i++) {
				Job job = resume.getJobs().get(i);
				//add company and job title
				Paragraph newJob = section.addParagraph();
				newJob.getFormat().setLeftIndent(30);
				if(i !=0 || resume.getFederalJobs().size() > 0) {
					newJob.getFormat().setBeforeAutoSpacing(false);
					newJob.getFormat().setBeforeSpacing(10);
				}
				TextRange tr = newJob.appendText(job.getCompany() +", ");
				tr.getCharacterFormat().setBold(true);
				tr.getCharacterFormat().setFontSize(12);
				TextRange positionTR = newJob.appendText(job.getJobTitle());
				positionTR.getCharacterFormat().setItalic(true);
				Paragraph dates = section.addParagraph();
				dates.getFormat().setLeftIndent(30);
				dates.appendText(job.getStartDate()+"-"+job.getEndDate());
				
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

	/** Adds activities to document
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
			for(int i = 0; i< fedResume.getActivities().size();i++) {
				Activity activity = fedResume.getActivities().get(i);
				
				//add organization and activity title
				Paragraph newActivity = section.addParagraph();
				newActivity.getFormat().setLeftIndent(30);
				if(i!=0) {
					newActivity.getFormat().setBeforeAutoSpacing(false);
					newActivity.getFormat().setBeforeSpacing(10);
				}
				TextRange tr = newActivity.appendText(activity.getOrganization() +", ");
				tr.getCharacterFormat().setBold(true);
				tr.getCharacterFormat().setFontSize(12);
				TextRange positionTR = newActivity.appendText(activity.getRole());
				positionTR.getCharacterFormat().setItalic(true);
				Paragraph dates = section.addParagraph();
				dates.getFormat().setLeftIndent(30);
				dates.appendText(activity.getStartDate()+"-"+activity.getEndDate());
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
			for(int i = 0; i < resume.getSchools().size(); i ++) {
				
				School school = resume.getSchools().get(i);
				//add school info, such as name/location/dates
				Paragraph schoolName = section.addParagraph();
				schoolName.getFormat().setLeftIndent(30);
				if(i != 0) {
					schoolName.getFormat().setBeforeAutoSpacing(false);
					schoolName.getFormat().setBeforeSpacing(10);
				}
				TextRange tr = schoolName.appendText(school.getSchoolName()+ ", " +school.getSchoolLocation());
				tr.getCharacterFormat().setBold(true);
				tr.getCharacterFormat().setFontSize(12);
				Paragraph dates = section.addParagraph();
				dates.getFormat().setLeftIndent(30);
				dates.appendText(school.getStartDate()+"-"+school.getEndDate());
				
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

	/** Adds skills to word document. 
	 * 
	 * @param section section to add to in word doc
	 */
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

	/**
	  * Adds references to FederalResume
	  * @param section section to add to
	  */
	public void addReferences(Section section) {
		if(resume.getReferences().size() > 0) {
		
			Paragraph referencesHeader = section.addParagraph();
			
			TextRange referencesTR = referencesHeader.appendText("References");
			referencesTR.getCharacterFormat().setBold(true);
			referencesTR.getCharacterFormat().setFontSize(14);
			referencesHeader.getFormat().setBeforeAutoSpacing(false);
			referencesHeader.getFormat().setBeforeSpacing(10);
			
			for(References reference : resume.getReferences()) {
				Paragraph newReference = section.addParagraph();
				newReference.appendText(reference.getReferenceName()+", "+reference.getReferenceOrganization()+", "+
				reference.getReferenceEmail() + ", " + reference.getReferencePhoneNumber());
				newReference.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
				newReference.getListFormat().applyBulletStyle();
			}
		}
	}
}
