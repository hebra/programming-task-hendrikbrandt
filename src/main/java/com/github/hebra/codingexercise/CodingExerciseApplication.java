package com.github.hebra.codingexercise;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Start 19:35, End 20:25
 * 
 * 
 * For a given log file we want to know, • The number of unique IP addresses •
 * The top 3 most visited URLs • The top 3 most active IP addresses
 * 
 * @author Hendrik Brandt
 *
 */

@SpringBootApplication
public class CodingExerciseApplication {

	public static void main(String[] args) {

		String fileName = "/Users/heb/Downloads/programming-task-example-data.log";

		// Both solutions should create the same result

		// Solution using just Java BufferedReader and String.split
		SolutionOne.run(fileName);

		// Solution using a regular expression and a line matcher
		SolutionTwo.run(fileName);

	}
}
