package resumeBuilder;

import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;

public class WordCreator {
	private Resume resume;
	private String destination;
	
	public WordCreator(Resume resume, String destination) {
		this.resume = resume;
		this.destination = destination;
	}
	
	public void createWordDocument() {
		Document document = new Document();
		
		Section section = document.addSection();
		Paragraph p1 = section.addParagraph();
		p1.appendText(resume.getContactInfo().getName());
		try {
			document.saveToFile(destination, FileFormat.Docx);
		} catch (Exception e) {
			System.out.println("Invalid File Path, file saved in default file \"output/resume.docx\"");
			document.saveToFile("output/resume.docx", FileFormat.Docx);
		}
	}
}
