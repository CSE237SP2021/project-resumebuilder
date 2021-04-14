package resumeBuilder;

import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;

public class WordCreator {
  
	private static final int successfulSave =0;
	private static final int noFilePathGiven =1;
	private static final int defaultFile =2;
  
	private StandardResume resume;
	private String destination;
	
	public WordCreator(StandardResume resume, String destination) {
		this.resume = resume;
		this.destination = destination;
	}
	
	public int createWordDocument() {
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
		addSkills(section);
		
		
		
		
		try {
			document.saveToFile(destination, FileFormat.Docx);
			System.out.println("Thanks for using ResumeBuilder! Finishing program.");
			return successfulSave;
		} catch (Exception e) {
			if (destination == "") {
			
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
	
	/** Adds 'Work Experience' section to word doc
	 * 
	 * @param section section to add to in word doc
	 */
	public void addJobs(Section section) {
		Paragraph jobsHeader = section.addParagraph();
		TextRange jobsTR = jobsHeader.appendText("Work Experience");
		jobsTR.getCharacterFormat().setFontSize(14);
		jobsTR.getCharacterFormat().setBold(true);
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
	
	/** Adds skills to word document
	 * 
	 * @param section section to add to in word doc
	 */
	public void addSkills(Section section) {
		Paragraph skillsHeader = section.addParagraph();
		TextRange skillsTR = skillsHeader.appendText("Skills");
		skillsTR.getCharacterFormat().setFontSize(14);
		skillsTR.getCharacterFormat().setBold(true);
		for(String skill: resume.getSkills()) {
			Paragraph newParagraph = section.addParagraph();
			newParagraph.appendText(skill);
			newParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
			newParagraph.getListFormat().applyBulletStyle();
		}
	}
}
