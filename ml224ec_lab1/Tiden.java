package ml224ec_lab1;

import java.util.Scanner;

public class Tiden {
	
	private static final int HOUR_IN_MINUTES = 60;
	private static final int MINUTE_IN_SECONDS = 60;
	
	private static final int HOUR_IN_SECONDS = HOUR_IN_MINUTES*MINUTE_IN_SECONDS;

	public static void main(String[] args) {
		
		int totalHours;
		int totalMinutes;
		int totalSeconds;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Ange antal sekunder: ");
		int seconds = input.nextInt();
		
		totalHours = (int)Math.floor(seconds/HOUR_IN_SECONDS);
		seconds -= totalHours*HOUR_IN_SECONDS;
		
		totalMinutes = (int)Math.floor(seconds/MINUTE_IN_SECONDS);
		seconds -= totalMinutes*MINUTE_IN_SECONDS;
		
		totalSeconds = seconds;
		
		System.out.printf("Detta motsvarar %d timmar, %d minuter och %d sekunder.\n",totalHours, totalMinutes, totalSeconds);

	}

}
