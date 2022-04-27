import java.io.*;

public class MealPlanr {

	public static void main(String[] args) {
		try {
			FileOpenAndFormat.format(FileOpenAndFormat.lineRead(FileOpenAndFormat.openFile("foodList.csv")));
		}
		catch (FileNotFoundException exc) {
			System.out.println("File Not Found");
			System.exit(0);
		}
		
		

	}

}
