/****************************************************************************
 *
 * Created by: Matthew Lourenco
 * Created on: Feb 2018
 * This program calculates the amount of time food should be in the microwave
 *      based of the type of food and the amount.
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MicrowaveTimer {

	public static void main(String[] args) {
		// Calculates the time an item should spend in the microwave
		String[] food = {"sub", "pizza", "soup"};
		HashMap<String,Double> foodTimeInMicrowave=new
				HashMap<String,Double>();
		foodTimeInMicrowave.put("sub", 1.0);
		foodTimeInMicrowave.put("pizza", 0.75);
		foodTimeInMicrowave.put("soup", 1.75);
		Boolean choiceInList = false;
		String foodItem = null;
		String numberOfItems = null;
		int numberOfItemsI = 0;
		double timeInMicrowave = 0.0;
		
		//Get food choice
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(System.in));
		while(true) {
			System.out.println("Enter the item you want to microwave "
					+ "(sub/pizza/soup): ");
			try {
				//Get user input
				foodItem = reader.readLine();
			} catch (IOException noInput) {
				noInput.printStackTrace();
			}
			//Find food choice in list
			for(String item: food) {
				if(foodItem.equals(item)) {
					choiceInList = true;
					break;
				}
			}
			if(choiceInList) {
				break;
			} else {
				System.out.println("Please enter sub, pizza, or soup.");
			}
		}
		
		//get number of items
		while(true) {
			System.out.println("Enter the amount of " + foodItem + " you are "
					+ "putting into the microwave (Max 3): ");
			try {
				//Get user input
				numberOfItems = reader.readLine();
			} catch (IOException noInput) {
				noInput.printStackTrace();
			}
			try {
				//Convert string to int
				numberOfItemsI = Integer.parseInt(numberOfItems);
			} catch (NumberFormatException stringInput) {
				System.out.println("Please enter a  whole number.");
			}
			//Check if number entered is between 1 and 3
			if(numberOfItemsI<1) {
				System.out.println("Please put at least one " + foodItem +
						" in the microwave.");
			} else if(numberOfItemsI>3) {
				System.out.println("The microwave is too small to fit more "
						+ "than three in the microwave.");
			} else {
				//Calculate time in microwave
				timeInMicrowave = foodTimeInMicrowave.get(foodItem) +
						((numberOfItemsI - 1) * foodTimeInMicrowave.
								get(foodItem)
								* 0.5);
				break;
			}
		}
		System.out.println("Put your food in the microwave for "
				+ (int) Math.ceil(timeInMicrowave * 60) + " seconds.");
	}
}