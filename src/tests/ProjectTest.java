package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import resumeBuilder.Project;

class ProjectTest {
	
	@Test
	void testCreateProject() {
		Project project = new Project();
		String startDate = "March 2021";
		String name = "Resume Builder";
		String summary = "Built a Java program for users to use a resume template, input personal information (academic/work experience, skills, etc.), and generate a Microsoft Word resume.";
		project.setProjectName(name);
		project.setProjectSummary(summary);
		project.setStartDate(startDate);
		
		assertNull(project.getEndDate());
		assertEquals(name, project.getProjectName());
		assertEquals(startDate, project.getStartDate());
		assertEquals(summary, project.getProjectSummary());
	}
	
}
