package ml224ec_lab2;

import java.util.Scanner; // assigner placed a ban on arrays.. such is life

public class NastaStorsta {

	private static final int MAX_INTEGERS = 5;
	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		Integer biggest = null;
		Integer second_biggest = null;
		System.out.printf("Ange %d heltal, en åt gången (decimaler ignoreras)\n", MAX_INTEGERS);
		for (int i = 0; i < MAX_INTEGERS; i++)
		{
			System.out.printf("Ange tal %d: ", i + 1);
			int value = INPUT.nextInt();
			
			if (biggest == null || value > biggest)
			{
				second_biggest = biggest;
				biggest = value;
			}
			else if (second_biggest == null || value > second_biggest)
				second_biggest = value;
		}
		
		System.out.printf("Den näst största talet är %d",second_biggest);
		
	}

}
