package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import resumeBuilder.School;

class SchoolTests {

	@Test
	void testSchoolCreation() {
		School school_test = new School("August 2014", "May 2018", "Bob Jones High School", "Madison, AL", 3.69);
		assertNotNull(school_test);
	}

//	@Test
//	void testAddHonorsAwards() {
//		School school_test = new School("August 2014", "May 2018", "Bob Jones High School", "Madison, AL", 3.69);
//		String honors_awards_test = "Dean's List, AP Scholar 2017";
//		school_test.addHonorsAwards(honors_awards_test);
//		assertNotNull(school_test.getHonorsAwards());
//	}
	
	@Test
	void testGetStartDate() {
		School school_test = new School("August 2014", "May 2018", "Bob Jones High School", "Madison, AL", 3.69);
		String start_date_test = school_test.getStartDate();
		assertNotNull(start_date_test);
	}
	
	@Test
	void testGetEndDate() {
		School school_test = new School("August 2014", "May 2018", "Bob Jones High School", "Madison, AL", 3.69);
		String end_date_test = school_test.getEndDate();
		assertNotNull(end_date_test);
	}
	
	@Test
	void testGetSchoolName() {
		School school_test = new School("August 2014", "May 2018", "Bob Jones High School", "Madison, AL", 3.69);
		String school_name_test = school_test.getSchoolName();
		assertNotNull(school_name_test);
		char [] name_char_array = school_name_test.toCharArray();
		for (char letter : name_char_array) {
			if (!Character.isLetter(letter) && (letter != ' ')) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}
	
	@Test
	void testGetSchoolLocation() {
		School school_test = new School("August 2014", "May 2018", "Bob Jones High School", "Madison, AL", 3.69);
		String school_location_test = school_test.getSchoolLocation();
		assertNotNull(school_location_test);
		//Add regex check for commas
	}
	
	@Test
	void testGetGPA() {
		School school_test = new School("August 2014", "May 2018", "Bob Jones High School", "Madison, AL", 3.69);
		double gpa_test = school_test.getGPA();
		assertNotNull(gpa_test);
		if ((gpa_test >= 4.0) || (gpa_test < 0.0)) {
			assertTrue(false);
		} else {
			assertTrue(true);
		}
	}

}
