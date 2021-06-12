package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class AnalyticsCounter {
	
	public static void main(String[] args) {
		List<String> result;
		String path = "/Users/lime/IdeaProjects/Project2_DA_Java_biotech/Project02Eclipse/symptoms.txt";
		result = new ReadSymptomDataFromFile(path).GetSymptoms();
//		System.out.println(result);
//		System.out.println(result.size());
		countFrequencies((ArrayList<String>) result);

	}

	/**
	 * Using Collections API to get the occurrence of each string in an array list.
	 * @param list the list to analyse
	 */
	public static void countFrequencies(ArrayList<String> list) {

		// Add all your objects to the TreeSet, you will get a sorted Set.
		TreeSet<String> ts = new TreeSet<String>(list);

		for (String s : ts)
			System.out.println(s + "=" + Collections.frequency(list, s));
	}

}
