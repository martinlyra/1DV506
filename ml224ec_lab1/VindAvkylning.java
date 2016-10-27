package ml224ec_lab1;

import java.util.Scanner;

public class VindAvkylning {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Double result;
		
		System.out.print("Ange temperatur i Celcius: ");
		double temperature = input.nextDouble();
		
		System.out.print("Ange vindhastigheten: ");
		double windSpeed = input.nextDouble();
		
		result = 33 + (temperature - 33)*(0.474 + 0.454*Math.sqrt(windSpeed)-(0.0454*windSpeed));
		
		System.out.printf("Effektiv temperatur: %d grader Celcius", Math.round(result));
		
	}

}
