package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import resumeBuilder.Activity;

class ActivityTest {

	@Test
	void testCreateActivity() {
		Activity activity = new Activity();
		String role = "president";
		String organization = "washu student union";
		String description = "managed budget allowances for different WashU clubs";
		activity.setRole(role);
		activity.setOrganization(organization);
		activity.addDescription(description);
		
		assertNull(activity.getEndDate());
		assertTrue(activity.getDescriptions().contains(description));
		assertEquals(role, activity.getRole());
		assertEquals(organization, activity.getOrganization());
	}

}
