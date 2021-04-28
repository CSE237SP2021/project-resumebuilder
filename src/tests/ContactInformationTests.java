package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import resumeBuilder.ContactInformation;

class ContactInformationTests {
	
	@Test
	void testContactInfoCreation () {
		ContactInformation contactinfo_test = new ContactInformation("Amy", "amy.s@gmail.com", "314-233-3333", "One Brookings Drive, St. Louis, MO 63105");
		assertNotNull(contactinfo_test); 
	}
	
	@Test
	void testGetName() {
		ContactInformation contactinfo_test = new ContactInformation("Amy", "amy.s@gmail.com", "314-233-3333", "One Brookings Drive, St. Louis, MO 63105");
		String name_test = contactinfo_test.getName();
		assertNotNull(name_test); 
		char [] name_char_array = name_test.toCharArray();
		for (char letter : name_char_array) {
			if (!Character.isLetter(letter)) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}
	
	@Test
	void testGetEmail() {
		ContactInformation contactinfo_test = new ContactInformation("Amy", "amy.s@gmail.com", "314-233-3333", "One Brookings Drive, St. Louis, MO 63105");
		String email_test = contactinfo_test.getEmail();
		assertNotNull(email_test); 
		if(email_test.contains("@") && (email_test.contains(".com"))) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	void testGetPhoneNumber() {
		ContactInformation contactinfo_test = new ContactInformation("Amy", "amy.s@gmail.com", "314-233-3333", "One Brookings Drive, St. Louis, MO 63105");
		String phone_num_test = contactinfo_test.getPhoneNumber();
		assertNotNull(phone_num_test); 
		char [] name_char_array = phone_num_test.toCharArray();
		for (char digit : name_char_array) {
			if (Character.isLetter(digit)) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}
	
	@Test
	void testGetAddress() {
		ContactInformation contactinfo_test = new ContactInformation("Amy", "amy.s@gmail.com", "314-233-3333", "One Brookings Drive, St. Louis, MO 63105");
		String address_test = contactinfo_test.getAddress();
		assertNotNull(address_test);
	}

}