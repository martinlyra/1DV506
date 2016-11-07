package ml224ec_lab2;

import java.util.*;

public class HighLow {

	private static final Scanner INPUT = new Scanner(System.in);
	
	private static final int RANGE_MIN = 1;
	private static final int RANGE_MAX = 100;
	
	private static int attempts = 0;
	private static final int MAX_ATTEMPTS = 10;
	
	private static final String[] COMMENTS = {
			"Nyb�rjartur..",
			"Du hade tur idag.",
			"Str�lande!",
			"Briljant!",
			"Fint!",
			"Bra!",
			"Det var inte s� d�ligt.",
			"Nja..",
			"N�ra.",
			"Tur f�r dig."
	};
	
	public static void main(String[] args) {
		
		System.out.println("Gitta ett tal mellan 1 och 100, du har max tio f�rs�k. Anv�nd dom v�l.");
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
				System.out.printf("Gissa ett nummer, %s: f�rs�ket: ",s);
				val = INPUT.nextInt();
				if (val < RANGE_MIN || val > RANGE_MAX)
					System.out.println("Ditt nummer �r utanf�r gr�nsv�rdet, var v�nligen och f�rs�k igen");
				else
				{
					attempts++;
					break;
				}
			}
			if (val == num)
			{
				System.out.printf("Grattis, du hittade v�rdet efter %d gissningar. %s",attempts,COMMENTS[attempts]);
				return;
			}
			if (val < num) // smaller than
				System.out.println("Ledtr�d: l�g");
			else
				System.out.println("Lettr�d: h�g");
		}
		System.out.println("Du f�rlorade leken, du f�rbrukade alla dina tio f�rs�k!");
	}

}
