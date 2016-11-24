package ml224ec_lab2;

import java.util.*;

public class Baklanges {
	
	private static final Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Mata in ett textrad: ");
		char[] input = INPUT.nextLine().toCharArray();
		INPUT.close();
		String output = "";
		
		for (int i = input.length-1; i >= 0; i--)
		{
			output += input[i];
		}
		
		System.out.printf("Baklänges: %s\n", output);
		
	}

}
