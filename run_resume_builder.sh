#!/bin/bash

cd src/resumeBuilder
javac *.java #Compiling all java files in a folder
java Menu #Running the program

cd ..
cd tests
javac *.java
java ContactInformationTests
java SchoolTests
java ActivityTest
java JobTest
