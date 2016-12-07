package ml224ec_lab3;

public class MultiDisplay {
	
	private String currentMessage = "";
	private int displayCount = 0;
	
	public void setDisplayMessage(String text)
	{
		currentMessage = text;
	}
	
	public void setDisplayCount(int n)
	{
		displayCount = n;
	}
	
	public String getDisplayMessage()
	{
		return currentMessage; 
	}
	
	public Integer getDisplayCount()
	{
		return displayCount;
	}
	
	public void display()
	{
		for (int i = 0; i < displayCount; i++)
			System.out.println(currentMessage);
	}
	
	public void display(String text, int count)
	{
		currentMessage = text;
		displayCount = count;
		display();
	}
}
