package ml224ec_lab1;

import java.util.Scanner;

public class KortNamn {

	public static void main(String[] args) {
		
		String outputName = "";
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Förnman: ");
		String firstName = input.nextLine();
		
		System.out.print("Efternamn: ");
		String lastName = input.nextLine();
		
		if (firstName.length() > 1)
			outputName += firstName.substring(0,1) + ". ";
		else
			outputName += firstName + " ";
		
		if (lastName.length() > 4)
			outputName += lastName.substring(0,4) + ".";
		else 
			outputName += lastName;
		
		System.out.printf("Kortnamn: %s\n", outputName);
		
	}

}
