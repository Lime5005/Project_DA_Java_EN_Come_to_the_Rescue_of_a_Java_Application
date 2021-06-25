import com.hemebiotech.analytics.AnalyticsCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();

        // Reading:
        String path = "/Users/lime/IdeaProjects/Project2_DA_Java_biotech/Project02Eclipse/symptoms.txt";
        List<String> symptomList = analyticsCounter.readingFile(path);
        // Sorting:
        TreeMap<String, Integer> sortedData = analyticsCounter.sortingFile((ArrayList<String>) symptomList);
        // Saving:
        analyticsCounter.savingFile(sortedData);

    }
}
