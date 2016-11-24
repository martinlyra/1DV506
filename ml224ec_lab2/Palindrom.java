package ml224ec_lab2;

import java.util.*;

public class Palindrom {

	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Skriv in text för att testa om den är ett palindrom: ");
		String input = INPUT.nextLine().trim();
		INPUT.close();
		
		char[] char_stream = input.toLowerCase().toCharArray();
		String clean = "";
		for (int i = 0; i < input.length(); i++)
		{
			char c = char_stream[i];
			if (Character.isLetter(c)) // we don't want digits or specials
				clean += c;
		}
		
		char[] clean_stream = clean.toCharArray();
		String reversed = "";
		for (int i = clean.length()-1; i >= 0; i--)
			reversed += clean_stream[i];
		
		System.out.printf("%s är %s ett palindrom.\n"
				,input
				,(reversed.compareTo(clean) == 0 ? "" : "inte")); // returns an non-zero integer if there were at least one difference
	}

}
