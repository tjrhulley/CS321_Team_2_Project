import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOpenAndFormat {
	
	public static File openFile(String name) {
		File foodList = new File(name);
		
		return foodList;
	}
	
	public static ArrayList<String> lineRead(File filename) throws FileNotFoundException {
		Scanner scnr = new Scanner(filename);
		ArrayList<String> lines = new ArrayList<>();
	
		while (scnr.hasNextLine()) {
			lines.add(scnr.nextLine());
		}
		
		scnr.close();
		
		return lines;
	}
	
	public static ArrayList<FoodItem> format(ArrayList<String> list) {
		
		ArrayList<FoodItem> foodList = new ArrayList<>();
		
		Time time = Time.BREAKFAST;
		
		for (int x = 0; x < list.size(); x++) {
			
			String[] lineSplit = list.get(x).split(",");
			
			if (lineSplit[0].contains("Breakfast")) {
				continue;
			}
			else if (lineSplit[0].contains("Lunch")) {
				time = Time.LUNCH;
				continue;
			}
			else if (lineSplit[0].contains("Dinner")) {
				time = Time.DINNER;
				continue;
			}
			else if (lineSplit[0].contains("Late Night")) {
				time = Time.LATENIGHT;
				continue;
			}
			
			List<String> lineSplitList = Arrays.asList(lineSplit);
			
			List<String> ingredients = lineSplitList.subList(3, lineSplitList.size());
			
			FoodItem temp = new FoodItem(lineSplitList.get(0), Integer.parseInt(lineSplitList.get(1).replaceAll("[^0-9]", "")),Integer.parseInt(lineSplitList.get(2).replaceAll("[^0-9]", "")), time, ingredients);
			
			foodList.add(temp);
		}
		
		return foodList;
	}
}
