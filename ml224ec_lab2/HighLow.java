package ml224ec_lab2;

import java.util.*;

public class HighLow {

	private static final Scanner INPUT = new Scanner(System.in);
	
	private static final int RANGE_MIN = 1;
	private static final int RANGE_MAX = 100;
	
	private static int attempts = 0;
	private static final int MAX_ATTEMPTS = 10;
	
	private static final String[] COMMENTS = {
			"Nybörjartur..",
			"Du hade tur idag.",
			"Strålande!",
			"Briljant!",
			"Fint!",
			"Bra!",
			"Det var inte så dåligt.",
			"Nja..",
			"Nära.",
			"Tur för dig."
	};
	
	public static void main(String[] args) {
		
		System.out.println("Gitta ett tal mellan 1 och 100, du har max tio försök. Använd dom väl.");
		int num = (int)(Math.random()*100);
		if (!(num > 0))
			num = 1;
		while (attempts < MAX_ATTEMPTS)
		{
			int val = 0;
			while (true)
			{
				String s;
				switch (attempts)
				{
					case 0:
						s = "1:a"; break;
					default:
						s =  (attempts + 1) + ":e"; break;
				}
				System.out.printf("Gissa ett nummer, %s: försöket: ",s);
				val = INPUT.nextInt();
				if (val < RANGE_MIN || val > RANGE_MAX)
					System.out.println("Ditt nummer är utanför gränsvärdet, var vänligen och försök igen");
				else
				{
					attempts++;
					break;
				}
			}
			if (val == num)
			{
				System.out.printf("Grattis, du hittade värdet efter %d gissningar. %s",attempts,COMMENTS[attempts]);
				return;
			}
			if (val < num) // smaller than
				System.out.println("Ledtråd: låg");
			else
				System.out.println("Lettråd: hög");
		}
		System.out.println("Du förlorade leken, du förbrukade alla dina tio försök!");
	}

}
