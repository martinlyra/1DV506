package ml224ec_lab2;

import java.util.Random;

public class Frekvenstabell {
	
	/*
	 * Key-Value pair class used for the object-oriented (OO) version of the implementation
	private static class KeyValuePair<T1,T2> {
		public T1 Key;
		public T2 Value;
		
		public KeyValuePair(T1 key, T2 value)
		{
			this.Key = key;
			this.Value = value;
		}
	}*/
	
	private static final int[] FREQUENCY_TABLE =
		{
				0,0,0,0,0,0
		};
	/*
	private static final KeyValuePair[] FREQUENCY_TABLE = 
		{
				new KeyValuePair<Integer, Integer>(1,0),
				new KeyValuePair<Integer, Integer>(2,0),
				new KeyValuePair<Integer, Integer>(3,0),
				new KeyValuePair<Integer, Integer>(4,0),
				new KeyValuePair<Integer, Integer>(5,0),
				new KeyValuePair<Integer, Integer>(6,0)
		};
	*/
	
	private static final int MAX_DICE_ROLLS = 6000;
	private static final Random DICE = new Random();
	
	public static void main(String[] args) {
		
		for (int i = 0; i < MAX_DICE_ROLLS; i++)
		{
			// generates a number between 0 and 5, 0 corresponds 1 and 5 as 6
			int number = DICE.nextInt(6); 
			// More OO, but also more ugly, version
			// if this wasn't for Java, it would been more beautiful
			//FREQUENCY_TABLE[number].Value++; 
			
			// Simple version, nice and clean!
			FREQUENCY_TABLE[number]++;
		}
		
		System.out.printf("Frekvenstabell över %d slag med en d6:\n", MAX_DICE_ROLLS);
		for (int i = 0; i < FREQUENCY_TABLE.length; i++)
		{
			// OO version
			//KeyValuePair<Integer, Integer> pair = FREQUENCY_TABLE[i];
			//System.out.printf("%d: %d\n", pair.Key, pair.Value);
			//
			// Simple version
			System.out.printf("%d: %d\n", i+1, FREQUENCY_TABLE[i]);
		}

	}

}
