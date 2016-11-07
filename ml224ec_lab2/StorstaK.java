package ml224ec_lab2;

import java.util.*;

public class StorstaK {

	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int val = getInput("Ge mig ett positivt värde: ");
		String result = "0";
		int next = 0;
		
		for (int i = 0;;i++)
		{
			if (val < (i*(i+1)))
				break;
			else if (i != 0)
			{
				next = 2*i;
				result += " + " + next;
			}
		}
		
		System.out.printf("Resulatat är %s, %d < %d", result, next, val);
	}

	
	private static int getInput(String output)
	{
		while (true)
		{
			System.out.print(output);
			int input = INPUT.nextInt();
			if (input < 0)
				System.out.println("Den angivna värder är inte giltig; mindre än 0. Var snäll och försök igen.");
			else 
				return input;
		}
	}
}
