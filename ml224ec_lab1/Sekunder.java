package ml224ec_lab1;

import java.util.Scanner;

public class Sekunder {

	private static final int HOUR_IN_MINUTES = 60;
	private static final int MINUTE_IN_SECONDS = 60;
	
	private static final int HOUR_IN_SECONDS = HOUR_IN_MINUTES*MINUTE_IN_SECONDS;
	
	public static void main(String[] args) {
		
		int seconds = 0;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Timmar: ");
		seconds += (int) input.nextFloat()*HOUR_IN_SECONDS;
		
		System.out.print("Minuter: ");
		seconds += (int) input.nextFloat()*MINUTE_IN_SECONDS;
		
		System.out.print("Sekunder: ");
		seconds += (int) input.nextFloat();
		
		System.out.printf("Totala antalet sekunder: %d\n", seconds);

	}

}
