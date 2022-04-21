import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
			
			if (lineSplit[0].compareTo("Breakfast") == 0) {
				continue;
			}
			else if (lineSplit[0].compareTo("Lunch") == 0) {
				time = Time.LUNCH;
				continue;
			}
			else if (lineSplit[0].compareTo("Dinner") == 0) {
				time = Time.DINNER;
				continue;
			}
			else if (lineSplit[0].compareTo("Late Night") == 0) {
				time = Time.LATENIGHT;
				continue;
			}
			
			ArrayList<String> lineSplitList = (ArrayList<String>)Arrays.asList(lineSplit);
			
			ArrayList<String> ingredients = (ArrayList<String>)lineSplitList.subList(3, lineSplitList.size());
			
			FoodItem temp = new FoodItem(lineSplitList.get(0), Integer.parseInt(lineSplitList.get(1)),Integer.parseInt(lineSplitList.get(2)), time, ingredients);
			
			foodList.add(temp);
		}
		
		return foodList;
	}
}
