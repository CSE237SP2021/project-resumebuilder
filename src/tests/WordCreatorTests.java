package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import resumeBuilder.StandardResume;
import resumeBuilder.WordCreator;

class WordCreatorTests {

	@Test
	void testWordCreationValidPath() {
		StandardResume resume = new StandardResume();
		WordCreator wordCreator = new WordCreator(resume, "");
		assertEquals(wordCreator.createWordDocument(), 1);
		
	}
	
	@Test
	void testWordCreationInvalidPath() {
		StandardResume resume = new StandardResume();
		WordCreator wordCreator = new WordCreator(resume, "output/testName.docx");
		assertEquals(wordCreator.createWordDocument(), 0);
	
	}

}
