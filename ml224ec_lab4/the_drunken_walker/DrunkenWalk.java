package ml224ec_lab4.the_drunken_walker;

public class DrunkenWalk {
	
	private final int repeatCount;
	private final int size;
	private final int maxSteps;
	
	private RandomWalk currentWalker;
	
	private int amountOutside;
	
	public DrunkenWalk(int maxSteps, int size, int repeat)
	{
		this.size = size;
		this.maxSteps = maxSteps;
		repeatCount = repeat;
	}
	
	public void simulate()
	{
		for (int i = 0; i < repeatCount; i++)
		{
			currentWalker = new RandomWalk(maxSteps, size);
			
			while (currentWalker.moreSteps())
			{
				currentWalker.takeStep();
				if (!currentWalker.inBounds())
				{
					amountOutside++;
					break;
				}
			}
		}
	}

	public int getAmountOutside()
	{
		return amountOutside;
	}
}
