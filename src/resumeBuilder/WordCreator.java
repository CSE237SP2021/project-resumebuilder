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
		String docTitle = "";
		if(resume.getContactInfo().getName() != null) {
			String name = resume.getContactInfo().getName();
			docTitle = name.replaceAll("\\s","");
		}
		if(resume instanceof StandardResume) {
			StandardResumeCreator stdCreator = new StandardResumeCreator((StandardResume)resume);
			Document document = stdCreator.createStandardResume();
			return saveFile(document, docTitle);
		} else if(resume instanceof FederalResume) {
			FederalResumeCreator fedCreator = new FederalResumeCreator((FederalResume)resume);
			Document document = fedCreator.createFederalResume();
			return saveFile(document, docTitle);
		} else if(resume instanceof UndergradResearchResume) {
			UndergradResearchResumeCreator undergradCreator = new UndergradResearchResumeCreator((UndergradResearchResume)resume);
			Document document = undergradCreator.createUndergradResearchResume();
			return saveFile(document, docTitle);
		} else {
			TechnicalResumeCreator techCreator = new TechnicalResumeCreator((TechnicalResume)resume);
			Document document = techCreator.createTechnicalResume();
			return saveFile(document, docTitle);
		}
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
}