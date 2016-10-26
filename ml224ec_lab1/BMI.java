package ml224ec_lab1;

import java.util.Scanner;

public class BMI {

	private static final Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		
		float height = 0; // high
		float weight = 0; // wide, he he he
		
		height = getInput("Ange din längd i meter: ");
		
		weight = getInput("Ange din vikt i kilogram: ");
		
		System.out.printf("BMI: %f\n", (weight/(height*height)));
	}

	private static float getInput(String text)
	{
		float value = 0;
		while (value <= 0) {
			System.out.print(text);
			value = INPUT .nextFloat();
			if (value <= 0)
				System.out.println("Angivna värdet är ej giltig (noll eller mindre), var vänligen och försök igen.");
		}
		return value;
	}
}
