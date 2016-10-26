package ml224ec_lab1;

import java.util.Scanner;

public class Tiden {
	
	private static final int HourInMinutes = 60;
	private static final int MinuteInSeconds = 60;
	
	private static final int HourInSeconds = HourInMinutes * MinuteInSeconds;

	public static void main(String[] args) {
		
		int totalHours;
		int totalMinutes;
		int totalSeconds;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Ange antal sekunder: ");
		int seconds = input.nextInt();
		
		totalHours = (int)Math.floor(seconds/HourInSeconds);
		seconds -= totalHours*HourInSeconds;
		
		totalMinutes = (int)Math.floor(seconds/MinuteInSeconds);
		seconds -= totalMinutes*MinuteInSeconds;
		
		totalSeconds = seconds;
		
		System.out.printf("Detta motsvarar %d timmar, %d minuter och %d sekunder.\n",totalHours, totalMinutes, totalSeconds);

	}

}
