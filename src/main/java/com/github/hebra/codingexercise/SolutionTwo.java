package com.github.hebra.codingexercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionTwo {

	public static void run(String fileName) {

		Path path = Paths.get(fileName);

		// Stop the program if the log file doesn't exist
		if (!Files.exists(path)) {
			System.err.printf("File not found %s%n", fileName);
			System.exit(-1);
		}

		try {
			// Store the IP addresses and websites in a Map to keep track of how often an IP
			// address or website was found in the log file
			Map<String, Integer> ipAddr = new HashMap<>();
			Map<String, Integer> websites = new HashMap<>();

			final Matcher matcher = getMatcher(new String(Files.readAllBytes(path)));

			while (matcher.find()) {
				String ip = matcher.group(1);
				String website = matcher.group(4);

				ipAddr.put(ip, Optional.ofNullable(ipAddr.get(ip)).orElse(0) + 1);
				websites.put(website, Optional.ofNullable(websites.get(website)).orElse(0) + 1);
			}

			Helper.printResults(ipAddr, websites);

		} catch (IOException ex) {
			System.err.println(ex.getMessage());
			System.exit(-1);
		}

	}

	/**
	 * Get a pattern matcher object for payload using the log-lines regex.
	 * 
	 * @param payload
	 * @return the Matcher for payload.
	 */
	public static Matcher getMatcher(String payload) {

		/*
		 * The regex groups the IP (starts with everything except whitespace until the
		 * first whitespace). Then any character until a double quote. The sttring
		 * within the double quotes has 3 parts (method, resource, HTTP version)
		 * separated by single whitespaces and then closed by a double quote. The rest
		 * of the line is unimportant for the current task.
		 * 
		 */
		return Pattern.compile("^(\\S+) (.+) \"(\\S+) (\\S+) (\\S+)\" .+", Pattern.MULTILINE).matcher(payload);
	}
}
