package ml224ec_lab2;

import java.util.*;

public class OmvandOrdning {
	
	private static final ArrayList<Integer> INTEGERS = new ArrayList<Integer>();
	private static final Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		
		int count = 0;
		int input = 0;
		
		System.out.println("Mata in positiva tal; avsluta med negativt tal.");
		while (input > -1)
		{
			System.out.printf("Tal %d: ", count++);
			input = INPUT.nextInt();
			if (input < 0)
				break;
			INTEGERS.add(input);
		}
		INPUT.close();

		System.out.printf("Antal positiva tal: %d\nBaklänges: ", INTEGERS.size());
		for (int i = INTEGERS.size()-1; i >= 0; i--)
			System.out.printf("%d ", INTEGERS.get(i));
	}

}
