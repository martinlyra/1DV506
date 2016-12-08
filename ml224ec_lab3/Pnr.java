package ml224ec_lab3;

public class Pnr {

	private static final String NUMBER_FORMAT = "YYMMDD-NNNN";
	
	private static final int FIRST_PART_LENGTH = 6;
	private static final int SECOND_PART_LENGTH = 4;
	
	private static final int GENDER_DIGIT_OFFSET = 2; // starting from 0
	
	public static void main(String[] args) {
		
		String pnr1 = "970511-2424";
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
	
	// see the Luhn algorithm for this
	// Basically, you take each individual digit then multiply it
	// with the factor (2 - n%2), starting with 0, it gives you 2, 1, 2, 1
	// Then you add every digit present in the product number
	// (with (n - n%10)/10 + n%10, for two-digit numbers) into a single sum
	private static boolean isCorrect(String pnr)
	{
		String clean = pnr.replaceAll("-", ""); // clean out the non-digits (lazily)
		int sum = 0;
		
		for (int i = 0; i < clean.length(); i++)
		{
			int literal = Integer.parseInt(clean.substring(i, i+1));
			int factor = 2 - i%2; // 0%2 = 0, 1%2 = 1, 2%2 = 0 -- starting with 2
			int product = literal*factor;
			
			int remainder = product%10;
			sum += (product - remainder)/10 + remainder;
		}
		
		return (sum%10) == 0;
	}
}
