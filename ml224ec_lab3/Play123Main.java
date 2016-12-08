package ml224ec_lab3;

public class Play123Main {

	private static final int PLAY_COUNT = 10000;
	
	public static void main(String[] args) {
		
		int winCount = 0;
		
		for (int i = 0; i < PLAY_COUNT; i++)
		{
			if (play123()) // returns true if won
				winCount++;
		}
		
		Double winPercentage = ((double)winCount/PLAY_COUNT)*100;
		System.out.printf("Out of %d '123's, circa %d%% of the games won.",
				PLAY_COUNT, winPercentage.intValue());
	}
	
	
	private static boolean play123()
	{
		Deck deck = new Deck();
		deck.shuffleDeck();
		
		int step = 0;
		int deckSize = deck.cardsRemaining();
		for (int i = 0; i < deckSize; i++)
		{
			CardValue val = deck.takeCard().getValue();
			if ( 	(step == 0 && val == CardValue.Ace ) || // 1
					(step == 1 && val == CardValue.Two ) || // 2
					(step == 2 && val == CardValue.Three )) // 3
				return false;
			
			step = (step > 2) ? 0 : step + 1;
		}
		return true; // you are the lucky one!
	}

}
