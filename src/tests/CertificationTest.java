package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import resumeBuilder.Certification;

class CertificationTest {
	@Test
	void testCreateCertification() {
		Certification certification = new Certification();
		String dateEarned = "May 2018";
		String title = "First Aid Certification";
		String hostName = "American Red Cross";
		certification.setCertificationTitle(title);
		certification.setDateEarned(dateEarned);
		certification.setHostName(hostName);
		
		assertNull(certification.getDetails());
		assertEquals(title, certification.getCertificationTitle());
		assertEquals(dateEarned, certification.getDateEarned());
		assertEquals(hostName, certification.getHostName());
	}
}
