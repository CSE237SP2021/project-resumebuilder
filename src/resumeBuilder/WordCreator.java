package resumeBuilder;

import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;

public class WordCreator {
	private StandardResume resume;
	private String destination;
	
	public WordCreator(StandardResume resume, String destination) {
		this.resume = resume;
		this.destination = destination;
	}
	
	public void createWordDocument() {
		Document document = new Document();
		//TODO: create methods out of this inevitable mess
		
		Section section1 = document.addSection();
		Paragraph name = section1.addParagraph();
		name.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
		name.getFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);	
		TextRange tr = name.appendText(resume.getContactInfo().getName()+ "\n");
		tr.getCharacterFormat().setBold(true);
		tr.getCharacterFormat().setFontSize(18);
		
		Paragraph otherPersonalInfo = section1.addParagraph();
		otherPersonalInfo.appendText(resume.getContactInfo().getEmail());
		otherPersonalInfo.appendText("       "+resume.getContactInfo().getPhoneNumber());
		Tab tab2 = otherPersonalInfo.getFormat().getTabs().addTab(28);
		tab2.setJustification(TabJustification.Left);
		otherPersonalInfo.appendText("       "+resume.getContactInfo().getAddress());
		
		Paragraph skillsHeader = section1.addParagraph();
		TextRange skillsTR = skillsHeader.appendText("Skills");
		skillsTR.getCharacterFormat().setFontSize(14);
		skillsHeader.applyStyle(BuiltinStyle.Heading_1);
		for(String skill: resume.getSkills()) {
			Paragraph newParagraph = section1.addParagraph();
			newParagraph.appendText(skill);
			newParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
			newParagraph.getListFormat().applyBulletStyle();
		}
		try {
			document.saveToFile(destination, FileFormat.Docx);
		} catch (Exception e) {
			System.out.println("Invalid File Path, file saved in default file \"output/resume.docx\"");
			document.saveToFile("output/resume.docx", FileFormat.Docx);
		}
	}
}
