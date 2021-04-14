# cse237-project


# The Resume Builder Project
	- Audience: job applicants, HS and college students
	- Users will choose a resume template, input prompted information, and receive a Word document of their resume

# USER STORIES (Implemented)
	- A user should be able to receive a file of their resume in the project-resumeBuilder/output folder
	- A user should be able to receive a file of their resume in their desired location
	- A user should be able to initialize the resume (Word doc) creation process
	- A user should be able to input information for a federal resume
	- A user should be able to enter their skills (depending on the template)
	- A user should be able to enter their info in any order
	- A user should be able to continuously enter honors and awards for a specific academic institution
	- A user should be able to continuously enter job responsibilities for a specific role

# USER STORIES (To-dos and In Progress)
	- A user should be able to add multiple jobs
	- A user should be able to add multiple academic institutions
	- A user should be able to add multiple clubs or volunteer activities
	- A user should be able to add multiple references
	- A user should be able to receive a file of their resume via email
	- A user should be able to receive a file of a federal resume
	- A user should be able to input info for an undergrad research resume
	- A user should be able to receive a file of an undergrad research resume
	- A user should be able to input info for a CV
	- A user should be able to receive a file of a CV

# Obstacles/Issues
	- Struggling with running our program from the command line due to external dependencies
	- Having difficulty incorporating TDD to our UI stories
	- Needed to refactor our complex/large Menu class into an interface that implements more specific methods for specific resumes
		- Had issues with command line compilation when creating packages and relying on internal class dependencies

# Running the Program from the Command Line
	- Typically: See run_resume_builder.sh
	- Right now: Please run the program via Eclipse, via the RunResumeBuilder.java class. We are experiencing trouble with external dependencies, as mentioned in obstacles/issues, so running from the command line produces errors. Make sure that the .jar files in lib are in the class path (by right-clicking on the program, going to build path, configure build path, libraries, and examining the class path).
