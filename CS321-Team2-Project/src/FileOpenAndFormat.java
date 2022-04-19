import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOpenAndFormat {

	
	
	public File openFile() {
		File foodList = new File("foodList.csv");
		
		return foodList;
	}
	
	public ArrayList<String> lineRead(File filename) throws FileNotFoundException {
		Scanner scnr = new Scanner(filename);
		ArrayList<String> lines = new ArrayList<>();
	
		while (scnr.hasNextLine()) {
			lines.add(scnr.nextLine());
		}
		
		scnr.close();
		
		return lines;
	}
	
	public ArrayList<FoodItem> format(ArrayList<String> list) {
		
		ArrayList<FoodItem> foodList = new ArrayList<>();
		
		for (int x = 0; x < list.size(); x++) {
			String[] lineSplit = list.get(x).split(",");
			List<String> lineSplitList = Arrays.asList(lineSplit);
			List<String> ingredients = lineSplitList.subList(3, lineSplitList.size());
			FoodItem temp = new FoodItem(lineSplitList.get(0), Integer.parseInt(lineSplitList.get(1)),Double.parseDouble(lineSplitList.get(2)), ingredients);
			foodList.add(temp);
		}
		
		return foodList;
	}
	
	public static void main(String[] args) {
		

	}

}
