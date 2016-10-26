package ml224ec_lab1;

import java.util.Scanner;

public class SummaAvTre {

	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int value = 0;
		int sum = 0;
		
		value = getInput();
		
		for (int i = 0; i < 3; i++)
			sum += Math.floor((value/Math.pow(10, i))%10);

		System.out.printf("Summan av siffrorna i heltalet är: %d\n", sum);
		
	}
	
	private static int getInput()
	{
		while (true)
		{
			System.out.print("Ange ett tresiffrigt heltal: ");
			int val = INPUT.nextInt();
			if (99 < val && val < 1000) // I can't believe that this is a hack (values between 100 and 999 are acceptable)
				return val;
			else
				System.out.println("Den angiva talet är ej godtyckligt (måste vara tre-siffrig), var vänligen och försök igen.");
		}
	}

}
