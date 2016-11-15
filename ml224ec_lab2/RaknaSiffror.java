package ml224ec_lab2;

import java.util.*;

public class RaknaSiffror {

	private static final Scanner INPUT = new Scanner(System.in);
	
	// smells like a hack
	// for the string lookup version of the code
	//private static final String ODD = "2468";  
	//private static final String EVEN = "13579";
	
	public static void main(String[] args) {
		
		System.out.print("Ange ett heltal: ");
		Integer value = INPUT.nextInt();
		
		int amount_zero = 0;
		int amount_even = 0;
		int amount_odd = 0;
		
		char[] value_string = value.toString().toCharArray();
		
		/*
		 * String lookup version:
		 * 
		 * Let this be an evidence that Java can't do anything in the easy pragmatic way
		 * Because you can't, as opposed to many other languages, use a single char for
		 * your strings in Java. I mean - seriously?
		 *
		 * One thing Java has taught me - you don't program in Java, you *hack* in Java.
		 *
		for (int i = 0; i < value_string.length; i++)
		{
			String c = Character.toString(value_string[i]); // get the char and turn it into an useable string - in Java's very special way
			if (ODD.contains(c))
				amount_odd++;
			else if (EVEN.contains(c))
				amount_even++;
			else
				amount_zero++;
		}
		*/
		
		for (int i = 0; i < value_string.length; i++)
		{
			// get the char and turn it into an useable string
			// then into an integer
			// - in Java's very special way
			int c = Integer.parseInt(Character.toString(value_string[i])); 
			if (c == 0)
				amount_zero++;
			else if (c%2 == 0)
				amount_even++;
			else
				amount_odd++;
		}
		
		// print out the result
		System.out.printf(
				"Antal nollor: %d\n" +
				"Antal jämna: %d\n" +
				"Antal udda: %d\n"
				, amount_zero, amount_even, amount_odd);
	}

}
