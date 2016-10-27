package ml224ec_lab1;

import java.util.Random;

public class TelefonNummer {

	private static final String PhoneNumberFormat = "0XXX-ZXXXXX";
	
	public static void main(String[] args) {

		String phoneNumber = "";
		Random rng = new Random();
		
		for (int i = 0; i < PhoneNumberFormat.length(); i++)
		{
			char c = PhoneNumberFormat.charAt(i);
			
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
	
	private static final String Digits = "1234567890";
	
	private static boolean isDigit(char c)
	{
		return Digits.indexOf(c) > -1;
	}

}
