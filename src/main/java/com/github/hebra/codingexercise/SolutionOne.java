package com.github.hebra.codingexercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This solution of the problem uses just pure JDK built-in features w/o any
 * additional external libraries.
 * 
 * @author Hendrik Brandt
 *
 */
public class SolutionOne {

	public static void run(String fileName) {

		Path path = Paths.get(fileName);

		// Stop the program if the log file doesn't exist
		if (!Files.exists(path)) {
			System.err.printf("File not found %s%n", fileName);
			System.exit(-1);
		}

		// Load the file into a buffered reader
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile())))) {

			// Store the IP addresses and websites in a Map to keep track of how often an IP
			// address or website was found in the log file
			Map<String, Integer> ipAddr = new HashMap<>();
			Map<String, Integer> websites = new HashMap<>();

			// Read the file line per line until EOF
			String line = "";
			while ((line = br.readLine()) != null) {

				String[] chunks = line.split(" ");

				// Chunk 0 is the IP address, chunk 6 the website
				//
				// Check if there is already an entry in the map, if not add a new one, if yes
				// increase by 1
				ipAddr.put(chunks[0], Optional.ofNullable(ipAddr.get(chunks[0])).orElse(0) + 1);
				websites.put(chunks[6], Optional.ofNullable(websites.get(chunks[6])).orElse(0) + 1);
			}

			Helper.printResults(ipAddr, websites);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			System.exit(-1);
		}

	}
}
