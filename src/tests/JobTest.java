package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import resumeBuilder.Job;

class JobTest {

	@Test
	void testCreateJob() {
		Job job = new Job();
		String startDate = "June 2019";
		String company = "NASA";
		String jobTitle = "astronaut";
		job.setCompany(company);
		job.setJobTitle(jobTitle);
		job.setStartDate(startDate);
		
		assertNull(job.getEndDate());
		assertEquals(company, job.getCompany());
		assertEquals(startDate, job.getStartDate());
		assertEquals(jobTitle, job.getJobTitle());
	}
	
	@Test
	void testAddBullet() {
		Job job = new Job();
		String description = "worked with Java programming language";
		job.addBullet(description);
		assertTrue(job.getDescriptions().contains(description));
	}

}
