package com.hemebiotech.analytics;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class AnalyticsCounter {

	/**
	 * This method is to read and put all symptoms in a list.
	 * @param path Where located the text file to analysis.
	 * @return The raw data(symptoms) in a list or an empty list if no data.
	 */
	public List<String> readingFile(String path) {
		List<String> result;
		result = new ReadSymptomDataFromFile(path).getSymptoms();
		return result;
	}


	/**
	 * Using TreeSet to get all symptoms sorted alphabetically,
	 * and make sure no duplicate elements,
	 * then count the occurrence of each symptom in the list.
	 * @param symptoms The list to analysis.
	 * @return  A TreeMap with Key, Value pairs.
	 */
	public TreeMap<String, Integer> sortingFile(ArrayList<String> symptoms) {

		TreeSet<String> treeSetSymptoms = new TreeSet<>(symptoms);

		TreeMap<String, Integer> treeMap = new TreeMap<>();
		for (String symptom : treeSetSymptoms) {
			treeMap.put(symptom, Collections.frequency(symptoms, symptom));
		}

		return treeMap;
	}

	/**
	 * This method will write the treeMap(Key=value) line by line in a new file "results.out".
	 * @param treeMap The treeMap from the method above "sortingFile".
	 */
	public void savingFile(TreeMap<String, Integer> treeMap) {

		try (PrintWriter writer = new PrintWriter("results.out", StandardCharsets.UTF_8)){

			for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();

				writer.println(key + "=" + value);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
