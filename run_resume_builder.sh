#!/bin/bash

javac -cp lib/jaxb-api-2.2.jar:lib/Spire.Doc.jar src/resumeBuilder/*.java #Compiling all java files in a folder
java -cp "lib/jaxb-api-2.2.jar:lib/Spire.Doc.jar:src" resumeBuilder.RunResumeBuilder #Running the program
