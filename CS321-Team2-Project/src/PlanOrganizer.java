import java.util.ArrayList;

public class PlanOrganizer {
	private ArrayList<FoodItem> foodList;
	private ArrayList<FoodItem> breakList;
	private ArrayList<FoodItem> lunchList;
	private ArrayList<FoodItem> dinnerList;
	private int calorieLimit;
	private int proteinLimit;
	private ArrayList<String> allergyList;
	
	PlanOrganizer () {
		foodList = new ArrayList<FoodItem>();
		breakList = new ArrayList<FoodItem>();
		lunchList = new ArrayList<FoodItem>();
		dinnerList = new ArrayList<FoodItem>();
		calorieLimit = 0;
		proteinLimit = 0;
		allergyList = new ArrayList<String>();
	}
	
	void getFoodList(ArrayList<FoodItem> foodList) {
		this.foodList = foodList;
	}
	
	void setCalories(int calories) {
		this.calorieLimit = calories;
	}
	
	void setProtein(int protein) {
		this.proteinLimit = protein;
	}
	
	boolean checkAllergies(FoodItem food) {
		if (allergyList.isEmpty()) {
			return true;
		}
		
		for (int i = 0; i < allergyList.size(); i++) {
			if (food.getIngredients().contains(allergyList.get(1))) {
				return false;
			}
		}
		
		return true;
	}
	
	void divideFoods() {
		if (foodList.isEmpty()) {
			return;
		}
		
		for (int i = 0; i < foodList.size(); i++) {
			if (foodList.get(i).getTime() == Time.BREAKFAST) {
				breakList.add(foodList.get(i));
			} else if (foodList.get(i).getTime() == Time.LUNCH) {
				lunchList.add(foodList.get(i));
			} else {
				dinnerList.add(foodList.get(i));
			}
		}
	}
	
	void createPlan() {
		
	}
}
