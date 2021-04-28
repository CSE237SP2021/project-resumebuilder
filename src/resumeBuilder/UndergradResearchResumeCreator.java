package resumeBuilder;

import com.spire.doc.Document;
import com.spire.doc.Section;
import com.spire.doc.documents.BorderStyle;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.TextRange;

public class UndergradResearchResumeCreator {
	private UndergradResearchResume resume;
	
	public UndergradResearchResumeCreator(UndergradResearchResume undergradResume) {
		this.resume = undergradResume;
	}
	
	public Document createUndergradResearchResume() {
		Document document = new Document();
		Section section = document.addSection();
		if(resume.getContactInfo() != null) {
			addContactInfo(section);
		}
		
		addEducation(section);
		addJobs(section);
		addActivities(section, resume);
		addConferences(section, resume);
		addMemberships(section, resume);
		addCertifications(section, resume);
		addSkills(section, resume);
		return document;
	}
	
	/** Adds contact information to resume header
	 * 
	 * @param section section to add to in word doc
	 */
	public void addContactInfo(Section section) {
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
		
			for(int i = 0; i < resume.getJobs().size(); i++) {
				Job job = resume.getJobs().get(i);
				//add company and job title
				Paragraph newJob = section.addParagraph();
				newJob.getFormat().setLeftIndent(30);
				if(i !=0 ) {
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
	public void addActivities(Section section, UndergradResearchResume undergradResume) {
		if(undergradResume.getActivities().size() > 0) {
			Paragraph activitiesHeader = section.addParagraph();
			
			TextRange activitiesTR = activitiesHeader.appendText("Activities");
			activitiesTR.getCharacterFormat().setFontSize(14);
			activitiesTR.getCharacterFormat().setBold(true);
			activitiesHeader.getFormat().setBeforeAutoSpacing(false);
			activitiesHeader.getFormat().setBeforeSpacing(10);
			
			for(int i = 0; i< undergradResume.getActivities().size();i++) {
				Activity activity = undergradResume.getActivities().get(i);
				
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

	/**  Adds certifications to word doc
	 * 
	 * @param section section to add to in doc
	 * @param undergradResume resume object to get details from
	 */
	public void addCertifications(Section section, UndergradResearchResume undergradResume) {
		if(undergradResume.getCertifications().size() > 0) {
			Paragraph certificationsHeader = section.addParagraph();
			TextRange certificationsTR = certificationsHeader.appendText("Certifications");
			certificationsTR.getCharacterFormat().setBold(true);
			certificationsTR.getCharacterFormat().setFontSize(14);
			certificationsHeader.getFormat().setBeforeAutoSpacing(false);
			certificationsHeader.getFormat().setBeforeSpacing(10);
			
			for(int i = 0; i< undergradResume.getCertifications().size(); i++) {
				Certification certification = undergradResume.getCertifications().get(i);
				
				Paragraph newCertification = section.addParagraph();
				newCertification.getFormat().setLeftIndent(30);
				if(i!=0) {
					newCertification.getFormat().setBeforeAutoSpacing(false);
					newCertification.getFormat().setBeforeSpacing(10);
				}
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
	
	/** Adds memberships to word doc
	 * 
	 * @param section section to add to in doc
	 * @param undergradResume resume object to get details from
	 */
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
	
	/**  Adds conferences to word doc
	 * 
	 * @param section section to add to in doc
	 * @param undergradResume resume object to get details from
	 */
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
	
	/** Adds skills to word document. 
	 * 
	 * @param section section to add to in word doc
	 */
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
}
