package ml224ec_lab3;

public class DeckMain {

	private static final int HAND_AMOUNT = 2;
	
	public static void main(String[] args) {

		Deck deck = new Deck();
		
		System.out.printf("Cards in the deck: %d\n", deck.cardsRemaining());
		System.out.printf("Can the deck be shuffled? %s\n",
				( deck.canShuffle() ? "Yes": "No"));
		deck.shuffleDeck();
		Card[] hand = deck.takeCards(HAND_AMOUNT);
		System.out.printf("%d cards has been dealt for your hand\n", HAND_AMOUNT);
		
		System.out.printf("Cards remaining: %d\n", deck.cardsRemaining());
		System.out.printf("Can the deck be shuffled? %s\n\n",
				( deck.canShuffle() ? "Yes": "No"));
		
		System.out.println("Cards in your hand:");
		for (int i = 0; i < hand.length; i++)
			System.out.printf("- The %s card\n", hand[i].toString().toLowerCase());
	}

}
