package com.github.hebra.codingexercise;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Helper {

	/**
	 * Sort a String,Integer map by the numeric value of its values in descending
	 * order.
	 * 
	 * @param srcMap
	 * @return the sorted Map, or empty Map if srcMap is null
	 */
	public static Map<String, Integer> sortMapByValues(Map<String, Integer> srcMap) {

		if (srcMap == null) {
			return Collections.emptyMap();
		}

		/*
		 * Sort the incoming Map via a Stream sorted method. The reverse call for the
		 * comparator method is necessary to return a descending order instead if
		 * ascending. The sorted Stream is then collected and mapped into a
		 * LinkedHashMap - this is important as this implementation of a Map contains
		 * the insertion order (which at this time is sorted). If just e.g. a HashMap
		 * would be used the whole process of sorting would be useless as HashMap has no
		 * guarneeed order.
		 */

		return srcMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

	}

	/**
	 * Sort the IP addresses and the websites maps and print the results according
	 * to the tasks requirements.
	 * 
	 * @param ipAddr
	 * @param websites
	 */
	public static void printResults(Map<String, Integer> ipAddr, Map<String, Integer> websites) {

		Object[] topIPs = Helper.sortMapByValues(ipAddr).keySet().toArray();
		Object[] topSites = Helper.sortMapByValues(websites).keySet().toArray();

		// Print the results
		System.out.printf("Number of unique IP addresses %s%n", ipAddr.size());
		System.out.printf("Top 3 Sites: %n\t%s %n\t%s %n\t%s %n", topSites[0], topSites[1], topSites[2]);
		System.out.printf("Top 3 IPs: %n\t%s %n\t%s %n\t%s %n", topIPs[0], topIPs[1], topIPs[2]);
	}

}
