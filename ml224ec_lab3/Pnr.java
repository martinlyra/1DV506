package ml224ec_lab3;

public class Pnr {

	private static final String NUMBER_FORMAT = "YYMMDD-NNNN";
	//private static final String NUMBER_FORMAT_LONG = "YYYYMMDD-NNNN";
	
	private static final int FIRST_PART_LENGTH = 6;
	//private static final int FIRST_PART_LENGTH_LONG = FIRST_PART_LENGTH + 2; // 8
	private static final int SECOND_PART_LENGTH = 4;
	
	private static final int GENDER_DIGIT_OFFSET = 2; // starting from 0
	
	// private static String PERSON_NUMBER = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PERSON_NUMBER = NUMBER_FORMAT;
		
		String pnr1 = "970511-2425";
		String pnr2 = "781201-1139";
		String pnr3 = "880824-3190";
		
		System.out.println(getFirstPart(pnr1));
		System.out.println(getFirstPart(pnr2));
		System.out.println(getFirstPart(pnr3));
		
		System.out.println(getSecondPart(pnr1));
		System.out.println(getSecondPart(pnr2));
		System.out.println(getSecondPart(pnr3));
		
		System.out.println(isMale(pnr1));
		System.out.println(isMale(pnr2));
		System.out.println(isMale(pnr3));
		
		System.out.println(isFemale(pnr1));
		System.out.println(isFemale(pnr2));
		System.out.println(isFemale(pnr3));
		
		System.out.println(areEqual(pnr1, pnr1));
		System.out.println(areEqual(pnr2, pnr3));
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
	
}
