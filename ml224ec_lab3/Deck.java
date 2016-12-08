package ml224ec_lab3;

import java.util.Random;
import java.util.ArrayList;

public class Deck {

	private static final ArrayList<Card> DEFAULT_SET = generateDefaultDeck();
	
	private ArrayList<Card> currentSet = new ArrayList<Card>();
	private int takenAmount = 0; // also used as an starter index
	
	public Deck()
	{
		DEFAULT_SET.forEach( (c)->{currentSet.add(c);} );
	}
	
	public void shuffleDeck()
	{
		if (!canShuffle())
			return;
		
		Random rng = new Random();
		
		int len = currentSet.size();
		for (int i = 0; i < len; i++)
		{
			int index = rng.nextInt(len);
			Card c = currentSet.get(i); // save the old card
			currentSet.set(i, currentSet.get(index)); // replace the old
			currentSet.set(index, c); // "swap" by replacing the new card's original
		}
	}
	
	public Card[] dealCards(int amount)
	{
		Card[] cards = new Card[amount];
		
		int stopIndex = takenAmount + amount;
		for (int i = takenAmount; i < stopIndex; i++)
			cards[i - takenAmount] = currentSet.get(i);
		
		takenAmount += amount;
		return cards;
	}
	
	public Card[] getMissingCards()
	{
		Card[] cards = new Card[takenAmount];
		
		for (int i = 0; i < takenAmount; i++)
			cards[i] = currentSet.get(i);
		
		return cards;
	}
	
	public int cardsRemaining()
	{
		return currentSet.size() - takenAmount;
	}
	
	public boolean canShuffle()
	{
		int amount = currentSet.size();
		return amount == amount - takenAmount;
	}
	
	private static ArrayList<Card> generateDefaultDeck()
	{
		CardValue[] values = CardValue.values();
		CardSymbol[] symbols = CardSymbol.values();
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		for (int i = 0; i < symbols.length; i++)
		{
			for (int I = 0; I < values.length; I++)
			{
				cards.add(new Card(values[I], symbols[i]));
			}
		}
		
		return cards;
	}
	
}
