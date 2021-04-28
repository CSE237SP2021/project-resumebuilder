package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import resumeBuilder.StandardResume;
import resumeBuilder.WordCreator;

class WordCreatorTests {
	
	private static final int successfulSave =0;
	private static final int noFilePathGiven =1;
	private static final int defaultFile =2;

	@Test
	void testNoFilePathGiven() {
		StandardResume resume = new StandardResume();
		WordCreator wordCreator = new WordCreator(resume, "");
		assertEquals(wordCreator.createWordDocument(), noFilePathGiven);
		
	}
	
	@Test
	void testInvalidPath() {
		StandardResume resume = new StandardResume();
		WordCreator wordCreator = new WordCreator(resume, "invalid/file/path");
		assertEquals(wordCreator.createWordDocument(), defaultFile);
	
	}
	
	@Test
	void testValidPath() {
		StandardResume resume = new StandardResume();
		WordCreator wordCreator = new WordCreator(resume, "output/testResume.docx");
		assertEquals(wordCreator.createWordDocument(), successfulSave);
	}

}
