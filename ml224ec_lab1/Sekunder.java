package ml224ec_lab1;

import java.util.Scanner;

public class Sekunder {

	private static final int HourInMinutes = 60;
	private static final int MinuteInSeconds = 60;
	
	private static final int HourInSeconds = HourInMinutes*MinuteInSeconds;
	
	public static void main(String[] args) {
		
		float seconds = 0;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Timmar: ");
		seconds += input.nextFloat()*HourInSeconds;
		
		System.out.print("Minuter: ");
		seconds += input.nextFloat()*MinuteInSeconds;
		
		System.out.print("Sekunder: ");
		seconds += input.nextFloat();
		
		System.out.printf("Totala antalet sekunder: %d\n", seconds);

	}

}
