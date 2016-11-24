package ml224ec_lab2;

import java.util.*;

public class Lonerevision {

	private static final ArrayList<Integer> INTEGERS = new ArrayList<Integer>();
	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// has to be objects so I can use 'null'
		Integer highest = 0;
		Integer lowest = null;
		boolean abort = false;
		
		System.out.println("Mata in löner, mata in 'X' när du är klar:");
		while ( !abort )
		{
			System.out.print("> ");
			String[] input = INPUT.nextLine().split(" ");
			for (int i = 0; i < input.length; i++)
			{
				if ( input[i].startsWith("X") )
					abort = true;
				else
				{
					int I = Integer.parseInt(input[i]);
					INTEGERS.add(I);
					if (I > highest)
						highest = I;
					else if (lowest == null || I < lowest) // assign this variable at beginning
						lowest = I;
				}
				if (abort)
					break;
			}
		}
		INTEGERS.sort(null);
		
		int size = INTEGERS.size();
		int sum = 0;
		for (int i = 0; i < size; i++)
			sum += INTEGERS.get(i);
		
		int average = sum/size;
		
		int median;
		if ((size % 2) > 0) // if the size is uneven, do the easy way
			median = INTEGERS.get((int)Math.floor(size/2));
		else
		{
			int i = size/2;
			median = (INTEGERS.get(i) + INTEGERS.get(i-1))/2; // lists start at 0, suffice flooring than rounding
		}
		
		int spread = highest - lowest;
		
		System.out.printf("Medianlön: %d\nMedellön: %d\nLönespridning: %d\n"
				, median, average, spread);

	}

}
