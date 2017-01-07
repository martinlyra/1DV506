package ml224ec_lab4;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Histogram {

	private static final int INTERVAL_RANGE = 10;
	private static final int INTERVAL_SORT_COUNT = 10;
	private static final List<Integer> FREQUENCY_LIST = new ArrayList<Integer>();
	//private static final List<List<Integer>> FREQUENCY_DEFINES = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {

		if (args.length < 1) 
		{
			System.out.println("Error: No file arguments specified.");
			return;
		}
		
		Path path = Paths.get(args[0]);
		
		try {
			List<String> buffer = Files.readAllLines(path);
			
			// stats
			for (int i = 0; i < buffer.size(); i++)
			{
				int I = Integer.parseInt(buffer.get(i)); // turn string into int
				
				int m = (I - 1); // required for X1 - (X+1)0 ranges, eg. 11 - 20
				int n = m - m%INTERVAL_RANGE;
				int N = n/INTERVAL_RANGE; // reduce the selected integer into an index
				
				// Expand..
				int length = FREQUENCY_LIST.size();
				int diff = N - length + 1; // offset by one for intervals
				if (diff > 0) // ..if the location at selected index does not exist
					for (int a = 0; a < diff; a++) // for every non-existent slot
					{
						FREQUENCY_LIST.add(0); // reserve a slot
						//FREQUENCY_DEFINES.add(new ArrayList<Integer>());
					}
				// end expand
				
				int count = FREQUENCY_LIST.get(N) + 1; // count++
				FREQUENCY_LIST.set(N, count);
				//FREQUENCY_DEFINES.get(N).add(I);
			}
			// end stats
			
			// prepare for output
			int count = 0;
			int countOther = 0;
			List<String> output = new ArrayList<String>();
			for (int i = 0; i < FREQUENCY_LIST.size(); i++)
			{
				int c = FREQUENCY_LIST.get(i);
				count += c;
				if (i < INTERVAL_SORT_COUNT)
				{
					int lower = 1 + INTERVAL_RANGE*i;
					int upper = INTERVAL_RANGE + INTERVAL_RANGE*i;
					//System.out.print(FREQUENCY_DEFINES.get(i));
					
					String asterisks = new String(new char[c]).replace('\0', '*');
					
					output.add(String.format("%d - %d: %s\n", lower, upper, asterisks));
				}
				else
					countOther += c;
			}
			// end pre-output
			
			// output
			System.out.printf(
						"%d integers has been read from %s\n"
					+ 	"Integers in the interval [%d - %d]: %d\n"
					+ 	"Other: %d"
					, count + countOther, args[0] // row 1
					, 1, INTERVAL_SORT_COUNT * INTERVAL_RANGE, count // row 2
					, countOther); // row 3
			
			Iterator<String> it = output.iterator();
			while (it.hasNext())
				System.out.print(it.next());
			// end output
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
