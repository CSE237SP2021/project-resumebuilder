#!/bin/bash

javac src/resumeBuilder/*.java #Compiling all java files in a folder
cd src
java resumeBuilder.Menu #Running the program
cd ..

javac src/tests/*.java
cd tests
java tests.ContactInformationTests
java tests.SchoolTests
java tests.ActivityTest
java tests.JobTest
cd ..
