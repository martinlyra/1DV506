package ml224ec_lab4.nyhetsbyra;

public class News {

	private Newspaper source;
	
	public News(Newspaper source)
	{
		this.source = source;
	}
	
	public Newspaper source()
	{
		return source;
	}
}
