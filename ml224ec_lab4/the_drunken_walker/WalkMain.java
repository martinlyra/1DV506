package ml224ec_lab4.the_drunken_walker;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WalkMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the size: ");
		int size = input.nextInt();
		
		System.out.print("Enter the number of steps: ");
		int steps = input.nextInt();
		
		System.out.print("Enter the number of walkers: ");
		int walkers = input.nextInt();
		
		input.close();
		
		DrunkenWalk dk = new DrunkenWalk(steps, size, walkers);
		
		dk.simulate(); // do the actual thing
		
		int fallen = dk.getAmountOutside();
		String percentage = new DecimalFormat("#.#%").format((double)fallen/walkers);
		
		System.out.printf("Out of %d drunken walkers, %d (%s) fell into the water.", walkers, fallen, percentage);
		
	}

}
