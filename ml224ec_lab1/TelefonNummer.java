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
			
			if (isDigit(c) || c == '-')
				phoneNumber += c;
			else if (c == 'X')
				phoneNumber += rng.nextInt(9);
			else if (c == 'Z')
			{
				int a = rng.nextInt(9);
				phoneNumber += a > 0 ? a : 1;
			}
			
		}

		System.out.println(phoneNumber);
		
	}
	
	private static final String DIGITS = "1234567890";
	
	private static boolean isDigit(char c)
	{
		return DIGITS.indexOf(c) > -1;
	}

}
