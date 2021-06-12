package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class AnalyticsCounter {

	public static void main(String[] args) {
		List<String> result;
		String path = "/Users/lime/IdeaProjects/Project2_DA_Java_biotech/Project02Eclipse/symptoms.txt";
		result = new ReadSymptomDataFromFile(path).GetSymptoms();

		ArrayList<String> sortedData = countFrequencies((ArrayList<String>) result);
		writeFile(sortedData);
	}

	/**
	 * Using Collections API to get the occurrence of each string in an array list.
	 * @param list the list to analyse
	 * @return  a string list
	 */
	public static ArrayList<String> countFrequencies(ArrayList<String> list) {

		// Add all your objects to the TreeSet, you will get a sorted Set.
		TreeSet<String> ts = new TreeSet<String>(list);
		ArrayList<String> newResult = new ArrayList<>();
		for (String s : ts) {
//			System.out.println(s + "=" + Collections.frequency(list, s));
			newResult.add(s + "=" + Collections.frequency(list, s));
		}
		return newResult;
	}

	public static void writeFile(ArrayList<String> list) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("results.out", "UTF-8");

			for (String st : list) {
				writer.println(st);
			}
			writer.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
