package ml224ec_lab4.nyhetsbyra;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NyshetsbyraMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter how many newspapers to simulate: ");
		int newspaperCount = input.nextInt();
		
		System.out.print("Enter how many articles will be created: ");
		int articleCount = input.nextInt();
		
		input.close();
		
		Simulator sim = new Simulator(newspaperCount, articleCount);
		
		sim.initialize();
		sim.run();

		// Prepare for output
		List<Newspaper> nps = sim.getNewspapers();
		nps.sort(Collections.reverseOrder()); // Sorts by highest to lowest
		
		// Output time!
		System.out.printf("%d articles has been created by %d newspapers and shared across %d agencies.\n",
				sim.getNews().size(),
				sim.getNewspapers().size(),
				sim.getNewsAgencies().size());
		
		System.out.println("Scoreboard:");
		Iterator<Newspaper> nit = nps.iterator();
		while (nit.hasNext())
			System.out.println(nit.next());
	}

}
