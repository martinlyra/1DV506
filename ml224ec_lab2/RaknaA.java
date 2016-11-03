package ml224ec_lab2;

import java.util.*;
import java.util.Map.Entry;

public class RaknaA {

	private static final Scanner INPUT = new Scanner(System.in);
	private static final Map<Character, Integer> FILTER = new HashMap<Character, Integer>();
	
	public static void main(String[] args) {
		
		FILTER.put('a', 0);
		FILTER.put('A', 0);
		
		System.out.print("Ge mig ett snitt text: ");
		String string = INPUT.nextLine();
		
		char[] text = string.toCharArray();
		for (int i = 0; i < string.length(); i++)
			if (FILTER.containsKey(text[i]))
				FILTER.replace(text[i], FILTER.get(text[i]) + 1);
		
		Iterator<Entry<Character, Integer>> it = FILTER.entrySet().iterator();
		while (it.hasNext())
		{
			Entry<Character, Integer> e = it.next();
			System.out.printf("Det finns %d av \'%s\'\n",e.getValue(),e.getKey());
		}
		
	}

}
