# Programming Task Apache Log Extractor

This Spring Boot Java application shows 2 approaches to extract the number of unique IP addresses, the top 3 IP addresses and the top 3 websites visited from a standard Apache log file.

SolutionOne.java uses a simple BufferedReader with String.split to extract the necessary information.

SolutionTwo.java uses a patter matcher with a tailored regular expression to extract the IP address and the website from each line in the log file.

The subsequent processing and printing of the results is the same in both solutions and done via a Helper.java class method.

## Run program and test

First edit the file CodingExerciseApplication.java and set the right location for the Apache log file to parse.

To run the application type `./gradlew bootRun` from the project root.

To test the application run `./gradlew clean test` from the project root.
