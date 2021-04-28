package resumeBuilder;

import com.spire.doc.Document;
import com.spire.doc.Section;
import com.spire.doc.documents.BorderStyle;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.TextRange;

public class StandardResumeCreator {
	private StandardResume resume;
	
	public StandardResumeCreator(StandardResume resume) {
		this.resume = resume;
	}
	
	public Document createStandardResume() {
		StandardResume standardResume = (StandardResume)resume;
		Document document = new Document();
		Section section = document.addSection();
		if(resume.getContactInfo() != null) {
			addContactInfo(section);
		}
		addEducation(section);
		addJobs(section);
		addSkills(section, standardResume);
		
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
}
