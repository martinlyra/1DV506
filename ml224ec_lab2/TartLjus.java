package ml224ec_lab2;

public class TartLjus {

	private static final int CANDLES_PER_BOX = 24;
	private static final int MAX_AGE = 100;
	
	public static void main(String[] args) {
		
		int remaining = 0;
		int boxes = 0;
		
		for (int i = 0;i < MAX_AGE; i++)
		{
			int age = i+1;
			int bought = 0;
			
			remaining -= age;
			
			while (remaining < 0)
			{
				remaining += CANDLES_PER_BOX;
				bought++;
			}
			
			System.out.printf(
					"Till din %d:%s f�delsedag, k�p "
					+ (bought > 0 ? "%d l�d%s" : "inget") // conditional format string construction
					+ ".\n"
					, age
					, (i < 3 ? "a" : "e") // 1:a 2:a 3:e 4:e
					, bought
					, (bought > 1 ? "or" : "a") // l�dor (boxes) or l�da (box)
					);
			boxes += bought;
		}

		System.out.printf(
				"Under dina %d �r har %d l�d%s av ljus k�pts. Kvar �ver blev %s ljus."
				, MAX_AGE
				, boxes
				, (boxes > 1 ? "or" : "a") // l�dor (boxes) or l�da (box)
				, (remaining > 0 ? remaining : "inga") // number or inga (none)
				);
	}

}
