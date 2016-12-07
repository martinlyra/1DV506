package ml224ec_lab3;

public class Point {

	private int positionX = 0, positionY = 0;
	
	public Point() {} // default constructor
	
	public Point(int x, int y)
	{
		positionX = x;
		positionY = y;
	}
	
	public void move(int x, int y)
	{
		positionX += x;
		positionY += y;
	}
	
	public void moveToXY(int x, int y)
	{
		positionX = x;
		positionY = y;
	}
	
	public boolean isEqualTo(Point other)
	{
		return positionX == other.positionX && positionY == other.positionY;
	}
	
	public double distanceTo(Point other)
	{
		return Math.sqrt(Math.pow(positionX - other.positionX, 2) + Math.pow(positionY - other.positionY, 2));
	}
	
	public String toString()
	{
		return "(" + positionX + "," + positionY + ")"; 
	}
}
