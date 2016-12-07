package ml224ec_lab3;

public class TextAnalyzer {

	private String text;
	
	public TextAnalyzer(String text)
	{
		this.text = text;
	}
	
	public int charCount()
	{
		return text.length(); // I am not a cheater! I promise!
	}
	
	public int upperCaseCount()
	{
		int count = 0;
		
		for (int i = 0; i < text.length(); i++)
		{
			if (Character.isUpperCase(text.charAt(i)))
				count++;
		}
		
		return count;
	}
	
	public int whitespaceCount()
	{
		int count = 0;
		
		for (int i = 0; i < text.length(); i++)
		{
			if (Character.isWhitespace(text.charAt(i)))
				count++;
		}
		
		return count;
	}
	
	public int digitCount()
	{
		int count = 0;
		
		for (int i = 0; i < text.length(); i++)
		{
			if (Character.isDigit(text.charAt(i)))
				count++;
		}
		
		return count;
	}
	
	public boolean containsChar(char c)
	{
		String clean = text.toLowerCase();
		c = Character.toLowerCase(c);
		
		for (int i = 0; i < clean.length(); i++)
		{
			if (clean.charAt(i) == c)
				return true;
		}
		return false;
	}
	
	public boolean containsString(String s)
	{
		String clean = text.toLowerCase();
		String substr = s.toLowerCase();
		
		if (clean.contains(substr))
			return true;
		return false;
	}
}
