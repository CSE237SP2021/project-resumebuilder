package resumeBuilder;

import com.spire.doc.Document;
import com.spire.doc.Section;
import com.spire.doc.documents.BorderStyle;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.TextRange;

public class TechnicalResumeCreator {
	private TechnicalResume resume;
	
	public TechnicalResumeCreator(TechnicalResume resume) {
		this.resume = resume;
	}
	
	public Document createTechnicalResume() {
		TechnicalResume technicalResume = (TechnicalResume)resume;
		Document document = new Document();
		Section section = document.addSection();
		if(resume.getContactInfo() != null) {
			addContactInfo(section);
		}
		
		addJobs(section);
		addEducation(section);
		addProjects(section, technicalResume);
		addCertifications(section, technicalResume);
		addSkills(section, technicalResume);
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

	/** Adds skills to word document. 
	 * 
	 * @param section section to add to in word doc
	 */
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

	public void addCertifications(Section section, TechnicalResume techResume) {
		if(techResume.getCertifications().size() > 0) {
			Paragraph certificationsHeader = section.addParagraph();
			TextRange certificationsTR = certificationsHeader.appendText("Certifications");
			certificationsTR.getCharacterFormat().setBold(true);
			certificationsTR.getCharacterFormat().setFontSize(14);
			certificationsHeader.getFormat().setBeforeAutoSpacing(false);
			certificationsHeader.getFormat().setBeforeSpacing(10);
			
			for(int i = 0; i< techResume.getCertifications().size(); i++) {
				Certification certification = techResume.getCertifications().get(i);
				
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

	public void addProjects(Section section, TechnicalResume techResume) {
		if(techResume.getProjects().size() > 0) {
			Paragraph projectsHeader = section.addParagraph();
			TextRange projectsTR = projectsHeader.appendText("Projects");
			projectsTR.getCharacterFormat().setBold(true);
			projectsTR.getCharacterFormat().setFontSize(14);
			projectsHeader.getFormat().setBeforeAutoSpacing(false);
			projectsHeader.getFormat().setBeforeSpacing(10);
			
			for(int i = 0; i< techResume.getProjects().size(); i++) {
				Project project = techResume.getProjects().get(i);
				
				Paragraph newProject = section.addParagraph();
				newProject.getFormat().setLeftIndent(30);
				if(i!=0) {
					newProject.getFormat().setBeforeAutoSpacing(false);
					newProject.getFormat().setBeforeSpacing(10);
				}
				TextRange certificationTitle = newProject.appendText(project.getProjectName()+", " + project.getStartDate() + project.getEndDate());
				certificationTitle.getCharacterFormat().setBold(true);
				certificationTitle.getCharacterFormat().setFontSize(12);
				Paragraph projectSum = section.addParagraph();
				projectSum.getFormat().setLeftIndent(60);
				projectSum.appendText(project.getProjectSummary());
			}
		}
	}
}
