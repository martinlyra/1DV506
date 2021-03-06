package ml224ec_lab3;

public class Pnr {

	private static final int[] DAYSINMONTH = {
			31, // JAN
			28,	// FEB (leap taken care in "isVaildDate")
			31, // MAR
			30, // APR
			31, // MAY
			30, // JUN
			31, // JUL
			31, // AUG
			30, // SEP
			31, // OCT
			30, // NOV
			31 	// DEC
	};
	
	private static final String NUMBER_FORMAT = "YYMMDD-NNNN";
	
	private static final int FIRST_PART_LENGTH = 6;
	private static final int SECOND_PART_LENGTH = 4;
	
	private static final int GENDER_DIGIT_OFFSET = 2; // starting from 0
	
	public static void main(String[] args) {
		
		String pnr1 = "870511-2426";
		String pnr2 = "781201-1139";
		String pnr3 = "890823-3193";
		
		System.out.println("functionName():");
		System.out.printf("pnr1 (%s)\n",pnr1);
		System.out.printf("pnr2 (%s)\n",pnr2);
		System.out.printf("pnr3 (%s)\n",pnr3);
		
		System.out.println("\ngetFirstPart():");
		System.out.println(getFirstPart(pnr1));
		System.out.println(getFirstPart(pnr2));
		System.out.println(getFirstPart(pnr3));
		
		System.out.println("\ngetSecondPart():");
		System.out.println(getSecondPart(pnr1));
		System.out.println(getSecondPart(pnr2));
		System.out.println(getSecondPart(pnr3));
		
		System.out.println("\nisMale():");
		System.out.println(isMale(pnr1));
		System.out.println(isMale(pnr2));
		System.out.println(isMale(pnr3));
		
		System.out.println("\nisFemale():");
		System.out.println(isFemale(pnr1));
		System.out.println(isFemale(pnr2));
		System.out.println(isFemale(pnr3));
		
		System.out.println("\nareEqual():");
		System.out.printf("pnr1, pnr1: %s\n", areEqual(pnr1, pnr1));
		System.out.printf("pnr2, pnr3: %s\n", areEqual(pnr2, pnr3));
		
		System.out.println("\nisCorrect():");
		System.out.println(isCorrect(pnr1));
		System.out.println(isCorrect(pnr2));
		System.out.println(isCorrect(pnr3));
	}
	
	public static String getFirstPart(String pnr)
	{
		return pnr.substring(0, FIRST_PART_LENGTH);
	}
	
	public static String getSecondPart(String pnr)
	{
		return pnr.substring(pnr.length() - SECOND_PART_LENGTH); // runs to the first null terminator without the second arg
	}
	
	public static boolean isMale(String pnr)
	{
		return !isFemale(pnr); // lazy
	}
	
	public static boolean isFemale(String pnr)
	{
		return isEven(getNumericValueAt(pnr,FIRST_PART_LENGTH + GENDER_DIGIT_OFFSET));
	}
	
	public static boolean areEqual(String pnr, String pnr_other)
	{
		return pnr.compareTo(pnr_other) == 0;
	}
	
	private static int getNumericValueAt(String pnr, int i)
	{
		return Character.getNumericValue(pnr.charAt(i));
	}

	private static boolean isEven(int n)
	{
		return n%2==0;
	}
	
	private static boolean isCorrect(String pnr)
	{
		String clean = pnr.replaceAll("-", ""); // clean out the non-digits (lazily)
		
		int validDigit = calculateValidityDigit(clean);
		int lastDigit = Integer.parseInt(clean.substring(clean.length()-1));
		
		/*
		 * Simpler implementation without errors elaborating the problem
		if (validDigit != lastDigit || !hasVaildDate(pnr))
			return false;
			*/
		
		if (validDigit != lastDigit)
		{
			System.out.printf("Incosistent validity number: Expected %d, got %d\n", validDigit, lastDigit);
			return false;
		}
		else if (!hasVaildDate(pnr))
		{
			System.out.println("Invaild date");
			return false;
		}
		
		return true;
	}
	
	// See the Luhn algorithm for this
	// Basically, you take each individual digit then multiply it,
	// excluding the last digit, which is the validity digit,
	// with the factor (2 - n%2), starting with 0, it gives you 2, 1, 2, 1
	// Then you add every digit present in the product number
	// (with (n - n%10)/10 + n%10, for two-digit numbers) into a single sum
	//
	// also required for isCorrect
	private static int calculateValidityDigit(String pnr)
	{
		int sum = 0;
		
		for (int i = 0; i < pnr.length() - 1; i++)
		{
			int literal = Integer.parseInt(pnr.substring(i, i+1));
			int factor = 2 - i%2; // 0%2 = 0, 1%2 = 1, 2%2 = 0 -- starting with 2
			int product = literal*factor;
			
			int remainder = product%10;
			sum += (product - remainder)/10 + remainder;
		}
		
		// second modulus needed to neutralize '10's, you'll get a 0 from '10's
		return (10 - (sum%10))%10;
	}
	
	// required for isCorrect
	private static boolean hasVaildDate(String pnr)
	{
		int day = Integer.parseInt(pnr.substring(4,6));
		int month = Integer.parseInt(pnr.substring(2,4));
		int year = Integer.parseInt(pnr.substring(0,2));
		
		if (month > 12) // whoa, not so fast!
			return false;
		
		boolean leap = isLeapYear(year);
		
		if (month == 2 && leap) // leap
		{
			if (day <= 29)
				return true;
			else
				return false;
		}

		if (day <= DAYSINMONTH[month-1]) // see top of this source file
			return true;
		
		return false;
	}
	
	// required for hasVaildDate
	private static boolean isLeapYear(int year)
	{	
		if (year%4 != 0)
			return false; 	// common
		else if (year%100 != 0)
			return true;	// leap
		else if (year%400 != 0)
			return false;	// common
		// else
		return true;		// leap
	}
}
