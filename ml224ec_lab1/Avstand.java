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
		
		firstPoint = getInput("Skriv in koordinaterna f�r den f�rsta positionen X,Y: ");
		secondPoint = getInput("Skriv in koordinaterna f�r den andra positionen X,Y: ");
		
		double distX = (firstPoint.X - secondPoint.X);
		double distY = (firstPoint.Y - secondPoint.Y);
		
		System.out.printf("Avst�ndet mellan koordinaterna �r %f", Math.sqrt(
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
				System.out.println("Det angivna v�rdet �r ej giltig, m�ste vara koordinater f�r X och Y i formattet X,Y, var v�nligen och f�rs�k igen.");
		}
	}

}
