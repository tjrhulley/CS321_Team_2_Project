import java.util.ArrayList;
import java.util.Random;

public class PlanOrganizer {
	private ArrayList<FoodItem> foodList;
	private ArrayList<FoodItem> breakList;
	private ArrayList<FoodItem> lunchList;
	private ArrayList<FoodItem> dinnerList;
	private int calorieLimit;
	private int proteinLimit;
	private ArrayList<String> allergyList;
	private ArrayList<FoodItem> mealPlan;
	
	PlanOrganizer () {
		foodList = new ArrayList<FoodItem>();
		breakList = new ArrayList<FoodItem>();
		lunchList = new ArrayList<FoodItem>();
		dinnerList = new ArrayList<FoodItem>();
		calorieLimit = 0;
		proteinLimit = 0;
		allergyList = new ArrayList<String>();
		mealPlan = new ArrayList<FoodItem>();
	}
	
	void setFoodList(ArrayList<FoodItem> foodList) {
		this.foodList = foodList;
	}
	
	void setCalories(int calories) {
		this.calorieLimit = calories;
	}
	
	void setProtein(int protein) {
		this.proteinLimit = protein;
	}
	
	void setAllergies(ArrayList<String> allergyList) {
		this.allergyList = allergyList;
	}
	
	ArrayList<FoodItem> getMealPlan() {
		return mealPlan;
	}
	
	boolean checkAllergies(FoodItem food) {
		if (allergyList.isEmpty()) {
			return true;
		}
		
		for (int i = 0; i < allergyList.size(); i++) {
			if (food.getIngredients().contains(allergyList.get(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	void divideFoods() {
		if (foodList.isEmpty()) {
			return;
		}
		
		breakList.clear();
		lunchList.clear();
		dinnerList.clear();
		
		for (int i = 0; i < foodList.size(); i++) {
			if (checkAllergies(foodList.get(i))) {
				if (foodList.get(i).getTime() == Time.BREAKFAST) {
					breakList.add(foodList.get(i));
				} else if (foodList.get(i).getTime() == Time.LUNCH) {
					lunchList.add(foodList.get(i));
				} else {
					dinnerList.add(foodList.get(i));
				}
			}
		}
	}
	
	void createPlan() {
		if ((calorieLimit <= 0) || (proteinLimit <= 0)) {
			System.out.println("Calories and protein cannot be set to 0");
			return;
		}
		
		Random rand = new Random(System.currentTimeMillis());
		int calorieTotal = 0;
		int proteinTotal = 0;
		int planCheck = 0;
		int timeCheck = 0;
		int starvationCount = 0;
		int food = 0;
		
		mealPlan.clear();
		divideFoods();
		
		while (planCheck < 2) {
			if (timeCheck == 0) {//Breakfast
				food = rand.nextInt(breakList.size());
				if ((breakList.get(food).getCalories() + calorieTotal) <= calorieLimit ) {
					mealPlan.add(breakList.get(food));
					calorieTotal += breakList.get(food).getCalories();
					proteinTotal += breakList.get(food).getProtein();
					breakList.remove(food);
				}
				timeCheck++;
			} else if (timeCheck == 1) {//Lunch
				food = rand.nextInt(lunchList.size());
				if ((lunchList.get(food).getCalories() + calorieTotal) <= calorieLimit ) {
					mealPlan.add(lunchList.get(food));
					calorieTotal += lunchList.get(food).getCalories();
					proteinTotal += lunchList.get(food).getProtein();
					lunchList.remove(food);
				}
				timeCheck++;
			} else {//Dinner
				food = rand.nextInt(dinnerList.size());
				if ((dinnerList.get(food).getCalories() + calorieTotal) <= calorieLimit ) {
					mealPlan.add(dinnerList.get(food));
					calorieTotal += dinnerList.get(food).getCalories();
					proteinTotal += dinnerList.get(food).getProtein();
					dinnerList.remove(food);
				}
				timeCheck = 0;
			}
			
			planCheck++;
			
			if ((planCheck >= 2) && (starvationCount < 20)) {
				if (mealPlan.isEmpty()) {
					System.out.println("Calorie limit too low");
					return;
				}
				
				if (calorieTotal < (calorieLimit / 2)) {
					planCheck--;
				}
				
				if (proteinTotal < proteinLimit) {
					planCheck--;
				}
			}
			
			starvationCount++;
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int x = 0; x < mealPlan.size(); x++) {
			str = mealPlan.get(x) + "\n";
		}
		return str;
	}
	
	/*void test() {
		System.out.println(breakList);
		System.out.println(lunchList);
		System.out.println(dinnerList);
	}*/
}
