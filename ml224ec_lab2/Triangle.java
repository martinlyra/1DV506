package ml224ec_lab2;

import java.util.*;

public class Triangle {

	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Ange ett positivt udda tal: ");
		int val = INPUT.nextInt();
		INPUT.close();
		if ((val % 2) == 0 || val < 0) // if "val" is an even number or a number smaller than 0 (is a negative number)
		{
			System.out.println("Programfel: Förväntade ett positivt udda tal, fick annat.");
			return;
		}
		
		System.out.println("Rätvinklig triangel:");
		String triangle_a = "";
		for (int i = 1; i <= val; i++)
		{
			String buff = "";
			for (int I = 0; I < i; I++)
				buff += '*';
			triangle_a += buff + '\n';
		}
		System.out.print(triangle_a);
		
		System.out.println("Likbent triangel: ");
		String triangle_b = "";
		
		/* This is how you, as a normal sane mathematican, would do
		* int base = val/2;
		* int height = (int)Math.sqrt( (Math.pow(val, 2) - Math.pow(base, 2)) );
		*/ // But goddamn Java and all those text-only outputs
		
		// makes the number even, then divide by two, makes it uneven again by re-adding 1
		int height = (val - 1)/2 + 1; // Now with 100% text support!
		
		for (int i = 0; i < height; i++)
		{
			String buff = "";
			for (int I = 0; I < val/2 - i; I++) // SHRINK with one on each side, starting WITHOUT one in middle
				buff += ' ';
			for (int I = 0; I < i*2 + 1; I++)	// GROW with one on each side, starting WITH one in middle
				buff += '*';
			triangle_b += buff + '\n';
		}
		System.out.print(triangle_b);

	}

}
