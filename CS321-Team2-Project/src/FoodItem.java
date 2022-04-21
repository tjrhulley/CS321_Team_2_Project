import java.util.*;

public class FoodItem {
	private String name;
	private Time time; //Breakfast, Lunch, Dinner
	private int calories;
	private double protein;
	private ArrayList<String> ingredients;
	
	FoodItem (String name, int calories, int protein, Time time, ArrayList<String> ingredients) {
		this.name = name;
		this.time = time;
		this.calories = calories;
		this.protein = protein;
		this.ingredients = ingredients;
	}
	
	String getName() {
		return name;
	}
	
	Time getTime() {
		return time;
	}
	
	int getCalories() {
		return calories;
	}
	
	double getProtein() {
		return protein;
	}
	
	List<String> getIngredients() {
		return ingredients;
	}
}