package ml224ec_lab1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Konvertera {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.print("Ange grader i Fahrenheit: ");
		float degreesFahrenheit = input.nextFloat();
		
		Float degreesCelcius = (degreesFahrenheit - 32) * 5 / 9;
		
		double displayValue = ((float)Math.round(degreesCelcius*10))/10;
		
		System.out.printf("Grader i Celcius %s\n", 
				new DecimalFormat("#.#").format(displayValue)
		);
		
	}

}
