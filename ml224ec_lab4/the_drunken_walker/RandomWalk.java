package ml224ec_lab4.the_drunken_walker;

import java.util.Random;

public class RandomWalk {

	private enum Direction {
		NORTH,
		EAST,
		SOUTH,
		WEST;
		
		public static Direction pick()
		{
			return Direction.values()[new Random().nextInt(Direction.values().length)];
		}
	}
	
	private int position_x;
	private int position_y;
	private int steps;
	
	private final int maxSteps;
	private final int maxDistance;
	
	public RandomWalk(int maxSteps, int size) {
		position_x = position_y = steps = 0;
		
		this.maxSteps = maxSteps;
		maxDistance = size;
	}
	
	public void takeStep()
	{
		Direction dir = Direction.pick();
		
		switch (dir)
		{
		case NORTH:
			position_x++; break;
		case EAST:
			position_y++; break;
		case SOUTH:
			position_x--; break;
		case WEST:
			position_y--; break;
		}
		
		steps++;
	}
	
	public boolean moreSteps()
	{
		return steps < maxSteps;
	}
	
	public boolean inBounds()
	{
		return 	within(position_x, -maxDistance, maxDistance) &&
				within(position_y, -maxDistance, maxDistance);
	}
	
	public void walk()
	{
		while (moreSteps())
		{
			takeStep();
			if (!inBounds())
				break;
		}
	}
	
	private boolean within(int x, int lower, int upper)
	{
		return lower <= x && x <= upper;
	}
	
	public String toString()
	{
		return String.format("Steps taken: %d, Current position: (%d,%d)", steps, position_x, position_y);
	}

}
