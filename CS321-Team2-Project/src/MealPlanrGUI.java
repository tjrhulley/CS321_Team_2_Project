import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class MealPlanrGUI implements ActionListener {
	
	JFrame frame = new JFrame("Meal Planr");
	
	JTextField field = new JTextField();
	
	JCheckBox milk = new JCheckBox("Milk");
	JCheckBox eggs = new JCheckBox("Eggs");
	JCheckBox treeNuts = new JCheckBox("Tree Nuts");
	JCheckBox peanuts = new JCheckBox("Peanuts");
	JCheckBox shellfish = new JCheckBox("Shellfish");
	JCheckBox fish = new JCheckBox("Fish");
	JCheckBox soy = new JCheckBox("Soy");
	JCheckBox gluten = new JCheckBox("Gluten");
	
	public void run() {
		frame.setSize(320, 300);
		frame.setLocationRelativeTo(null);
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new FlowLayout());
		
		JLabel lbl1 = new JLabel("Welcome to Meal Planr!");
		
		JTextArea lbl2 = new JTextArea("This program takes your daily calorie intake \nand allergies and provides a meal plan for you!");
		lbl2.setBackground(null);
		lbl2.setEditable(false);
		lbl2.setVisible(true);
		
		JLabel lbl3 = new JLabel("Please input desired calorie maximum:");
		
		field.setColumns(6);
		
		JLabel empty = new JLabel();
		
		JLabel lbl4 = new JLabel("Please select your allergies:");
		
		JButton enter = new JButton("Create Meal Plan");
		enter.addActionListener(this);
		
		pnl1.add(lbl1);
		pnl1.add(lbl2);
		pnl1.add(lbl3);
		pnl1.add(field);
		
		pnl1.add(empty);
		
		pnl1.add(lbl4);
		pnl1.add(milk);
		pnl1.add(eggs);
		pnl1.add(treeNuts);
		pnl1.add(peanuts);
		pnl1.add(shellfish);
		pnl1.add(fish);
		pnl1.add(soy);
		pnl1.add(gluten);
		
		pnl1.add(enter);
		
		
		frame.add(pnl1);
		frame.setVisible(true);
		
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int calories = Integer.parseInt(field.getText());
		ArrayList<String> allergies = new ArrayList<String>();
		if (milk.isSelected()) {
			allergies.add("Milk");
		}
		if (eggs.isSelected()) {
			allergies.add("Eggs");
		}
		if (treeNuts.isSelected()) {
			allergies.add("Tree Nuts");
		}
		if (peanuts.isSelected()) {
			allergies.add("Peanuts");
		}
		if (shellfish.isSelected()) {
			allergies.add("Shellfish");
		}
		if (fish.isSelected()) {
			allergies.add("Fish");
		}
		if (soy.isSelected()) {
			allergies.add("Soy");
		}
		if (gluten.isSelected()) {
			allergies.add("Gluten");
		}
		
		frame.setVisible(false);
		
		PlanOrganizer creator = new PlanOrganizer();
		
		creator.divideFoods();
		
		
		
		/*JFrame test = new JFrame();
		test.setSize(100, 100);
		System.out.println(allergies.toString());
		JLabel allergylist = new JLabel(allergies.toString());
		JLabel cal = new JLabel("" + calories);
		test.add(allergylist);
		test.add(cal);
		test.setVisible(true);*/
		
		
		
	}
	
	public static void main(String[] args) {
		MealPlanrGUI test = new MealPlanrGUI();
		test.run();
	}




}
