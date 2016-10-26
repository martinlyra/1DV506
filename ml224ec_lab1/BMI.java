package ml224ec_lab1;

import java.util.Scanner;

public class BMI {

	private static final Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		
		float height = 0; // high
		float weight = 0; // wide, he he he
		
		height = getInput("Ange din l�ngd i meter: ");
		
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
				System.out.println("Angivna v�rdet �r ej giltig (noll eller mindre), var v�nligen och f�rs�k igen.");
		}
		return value;
	}
}
