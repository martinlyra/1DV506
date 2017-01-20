package ml224ec_lab4;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Histogram {
	
	private static final int LIMIT_LOWER = 1;
	private static final int INTERVAL_RANGE = 10;
	private static final int INTERVAL_SORT_COUNT = 10;
	
	private static final boolean DEBUG = false; // change this to true for more verbose output
	private static final List<List<Integer>> FREQUENCY_DEFINES = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {

		if (args.length < 1) 
		{
			System.out.println("Error: No file arguments specified.");
			return;
		}
		
		Path path = Paths.get(args[0]);
		
		System.out.printf("Reading integers from %s\n...\n",path);
		try {
			List<String> buffer = Files.readAllLines(path);
			
			// stats
			for (int i = 0; i < buffer.size(); i++)
			{
				int N = 0;
				int I = Integer.parseInt(buffer.get(i)); // turn string into int
				
				if (I >= LIMIT_LOWER)
				{
					int m = (I - 1); // required for X1 - (X+1)0 ranges, eg. 11 - 20
					int n = m - m%INTERVAL_RANGE;
					N = n/INTERVAL_RANGE + 1; // reduce the selected integer into an index
				}
				
				// Expand..
				int length = FREQUENCY_DEFINES.size();
				int diff = N - length + 1; // offset by one for intervals
				
				if (diff > 0) // ..if the location at selected index does not exist
					for (int a = 0; a < diff; a++) // for every non-existent slot
						FREQUENCY_DEFINES.add(new ArrayList<Integer>()); // reserve a slot
				// end expand
				
				FREQUENCY_DEFINES.get(N).add(I);
			}
			// end stats
			
			// prepare for output
			int count = 0;
			int countOther = 0;
			List<String> output = new ArrayList<String>();
			for (int i = 0; i < FREQUENCY_DEFINES.size(); i++)
			{
				int c = FREQUENCY_DEFINES.get(i).size();
				
				int lower = 1 + INTERVAL_RANGE*(i-1);
				int upper = INTERVAL_RANGE + INTERVAL_RANGE*(i-1);
				
				if (i - 1 < INTERVAL_SORT_COUNT && i != 0)
				{
					count += c;
					
					String asterisks = new String(new char[c]).replace('\0', '*');
					
					output.add(String.format("%d - %d %s| %s\n", lower, upper, "%s", asterisks));
				}
				else
					countOther += c;
				
				if (DEBUG)
					System.out.printf("%d (%s) = %s\n", i,
							(i == 0 ? "Other" : String.format("%d - %d", lower, upper)),
							FREQUENCY_DEFINES.get(i));
			}
			
			// format the histogram with proper alignment
			int max = 0;
			for (String str : output)
			{
				int dist = str.indexOf('|');
				if (dist > max)
					max = dist;
			}
			for (int i = 0; i < output.size(); i++)
			{
				String str = output.get(i);
				int dist = str.indexOf('|');
				String space = new String(new char[max - dist]).replace('\0', ' ');
				output.set(i, String.format(str, space)); // str already has a '%s' in it
			}
			// end formating & pre-output
			
			// output
			System.out.printf(
						"%d integers read from %s\n"
					+ 	"Integers in the interval [%d - %d]: %d\n"
					+ 	"Other: %d\n"
					+ 	"Histogram\n"
					, count + countOther, path // row 1
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
