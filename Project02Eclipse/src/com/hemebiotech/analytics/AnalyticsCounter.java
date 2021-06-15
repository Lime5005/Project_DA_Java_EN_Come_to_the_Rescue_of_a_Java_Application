package com.hemebiotech.analytics;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class AnalyticsCounter {

	/**
	 * This method will prompt all the other methods.
	 */
	public void startAnalysis() {
		// Reading:
		List<String> symptomList;
		String path = "/Users/lime/IdeaProjects/Project2_DA_Java_biotech/Project02Eclipse/symptoms.txt";
		symptomList = readingFile(path);
		// Sorting:
		ArrayList<String> sortedData = sortingFile((ArrayList<String>) symptomList);
		// Saving:
		savingFile(sortedData);

	}

	/**
	 * This method is to read and put all symptoms in a list.
	 * @param path Where located the text file to analysis.
	 * @return The raw data(symptoms) in a list or an empty list if no data.
	 */
	public List<String> readingFile(String path) {
		List<String> result;
		result = new ReadSymptomDataFromFile(path).GetSymptoms();
		return result;
	}


	/**
	 * Using TreeSet to get all symptoms sorted alphabetically,
	 * and make sure no duplicate elements,
	 * then count the occurrence of each symptom in the list.
	 * @param symptoms The list to analysis.
	 * @return  A sorted and counted list naming "sortedSymptoms".
	 */
	private ArrayList<String> sortingFile(ArrayList<String> symptoms) {

		TreeSet<String> treeSetSymptoms = new TreeSet<>(symptoms);
		ArrayList<String> sortedSymptoms = new ArrayList<>();
		for (String symptom : treeSetSymptoms) {
			sortedSymptoms.add(symptom + "=" + Collections.frequency(symptoms, symptom));
		}

		return sortedSymptoms;
	}

	/**
	 * This method will write the sortedSymptoms line by line in a new file "results.out".
	 * @param list The sortedSymptoms from the method above "sortingFile".
	 */
	public void savingFile(ArrayList<String> list) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("results.out", StandardCharsets.UTF_8);

			for (String st : list) {
				writer.println(st);
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
