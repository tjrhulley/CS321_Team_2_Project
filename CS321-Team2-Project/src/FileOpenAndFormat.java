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
		
		for (int x = 0; x < list.size(); x++) {
			
			String[] lineSplit = list.get(x).split(",");
			ArrayList<String> lineSplitList = (ArrayList<String>)Arrays.asList(lineSplit);
			
			ArrayList<String> ingredients = (ArrayList<String>)lineSplitList.subList(3, lineSplitList.size());
			
			FoodItem temp = new FoodItem(lineSplitList.get(0), Integer.parseInt(lineSplitList.get(1)),Integer.parseInt(lineSplitList.get(2)), ingredients);
			
			foodList.add(temp);
		}
		
		return foodList;
	}
}
