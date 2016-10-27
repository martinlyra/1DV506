package ml224ec_lab1;

import java.util.Scanner;

public class Avstand {

	private static final Scanner INPUT = new Scanner(System.in);
	
	private static class Point
	{
		public int X;
		public int Y;
		
		public Point(int x, int y)
		{
			this.X = x;
			this.Y = y;
		}
	}
	
	public static void main(String[] args) {
		
		Point firstPoint;
		Point secondPoint;
		
		firstPoint = getInput("Skriv in koordinaterna för den första positionen X,Y: ");
		secondPoint = getInput("Skriv in koordinaterna för den andra positionen X,Y: ");
		
		double distX = (firstPoint.X - secondPoint.X);
		double distY = (firstPoint.Y - secondPoint.Y);
		
		System.out.printf("Avståndet mellan koordinaterna är %f", Math.sqrt(
					(distX*distX) + (distY*distY)
				));
		
	}
	
	private static Point getInput(String text)
	{
		while (true)
		{
			System.out.print(text);
			String input = INPUT.nextLine();
			String[] s = input.split(",");
			if (s.length == 2)
			{
				int X = Integer.parseInt(s[0]);
				int Y = Integer.parseInt(s[1]);
				return new Point(X,Y);
			}
			else
				System.out.println("Det angivna värdet är ej giltig, måste vara koordinater för X och Y i formattet X,Y, var vänligen och försök igen.");
		}
	}

}
