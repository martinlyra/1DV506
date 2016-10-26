package ml224ec_lab1;

import java.util.Scanner;

public class Citat {

	public static void main(String[] args) {
		
		String text;
		@SuppressWarnings("resource")	// shut up Eclipse...
		Scanner input = new Scanner(System.in);
		
		System.out.print("Skriv in en rad text: ");
		
		text = input.nextLine();
		
		System.out.printf("\nCitat : \"%s\"\n", text);
		
	}

}
