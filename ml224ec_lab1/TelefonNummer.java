package ml224ec_lab1;

import java.util.Random;

public class TelefonNummer {

	private static final String PHONE_NUMBER_FORMAT = "0XXX-ZXXXXX";
	
	public static void main(String[] args) {

		String phoneNumber = "";
		Random rng = new Random();
		
		for (int i = 0; i < PHONE_NUMBER_FORMAT.length(); i++)
		{
			char c = PHONE_NUMBER_FORMAT.charAt(i);
			
			if (isDigit(c) || c == '-')	// skip actual digits or dashes
				phoneNumber += c;
			else if (c == 'X')			// generate a single-digit number
				phoneNumber += rng.nextInt(10);
			else if (c == 'Z')			// generate a single-digit number, that is not a zero
			{
				int a = rng.nextInt(10);
				phoneNumber += a > 0 ? a : 1; // if we receive a zero, append with '1' instead
			}
			
		}

		System.out.println(phoneNumber);
		
	}
	
	private static final String DIGITS = "1234567890";
	
	private static boolean isDigit(char c)
	{
		// if indexOf() returns -1 it couldn't find it because it does not exist within array/string
		return DIGITS.indexOf(c) > -1;	// true if found (a number larger than -1)
	}

}
