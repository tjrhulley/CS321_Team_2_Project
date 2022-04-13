
public class FoodItem {
	private String name;
	private String time; //Breakfast, Lunch, Dinner
	private int calories;
	private float protein;
	private String[] allergies;
	
	FoodItem (String name, String time, int calories, float protein, String[] allergies) {
		this.name = name;
		this.time = time;
		this.calories = calories;
		this.protein = protein;
		this.allergies = allergies;
	}
	
	String getName() {
		return name;
	}
	
	String getTime() {
		return time;
	}
	
	int getCalories() {
		return calories;
	}
	
	float getProtein() {
		return protein;
	}
	
	String[] getAllergies() {
		return allergies;
	}
}
