package ml224ec_lab4.nyhetsbyra;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Newspaper implements Comparable<Newspaper> {

	private int id;
	
	private static int nextID = 0; // incremented every time the constructor is called
	
	private Queue<News> pendingNews;
	
	private List<News> ownNews;
	private List<News> allNews;
	
	private List<NewsAgency> registeredAgencies;
	
	public Newspaper()
	{
		id = nextID++;
		
		pendingNews = new ArrayDeque<News>();
		
		ownNews = new ArrayList<News>();
		allNews = new ArrayList<News>();
		
		registeredAgencies = new ArrayList<NewsAgency>();
	}
	
	// Authorizes a news article
	// Returns the said article
	public News createNews()
	{
		News news = new News(this);
		pendingNews.add(news);
		add(news);
		return news;
	}
	
	// Are there self-authorized news that the newspaper had not yet
	// publicized to other papers?
	public boolean hasUnpublicizedNews()
	{
		return pendingNews.size() > 0;
	}
	
	// Returns if the source -is- this
	public boolean hasAuthorized(News news)
	{
		return news.source() == this;
	}
	
	// Publish the news to other agencies, if there are any.
	public void publicize()
	{
		while (!pendingNews.isEmpty())
		{
			News n = pendingNews.remove();
			for (int i = 0; i < registeredAgencies.size(); i++)
				registeredAgencies.get(i).boardcast(n);
		}
	}
	
	// To be used by the NewAgency class, to reference each other
	public void addAgency(NewsAgency agency)
	{
		registeredAgencies.add(agency);
	}
	
	// Add a news article to the newspaper. If it was authorized by itself,
	// it is added to its own special list dedicated its own articles it had
	// authorized
	public void add(News news)
	{
		if (news.source() == this)
			ownNews.add(news);
		allNews.add(news);
	}
	
	public int getID()
	{
		return id;
	}

	public String toString()
	{
		return String.format("(ID:%d) %d self-authorized articles of %d.", id, ownNews.size(), allNews.size());
	}
	
	// Compare by who has authorized the most original articles 
	// Tip: use Collections.reverseOrder() for highest-lowest in sort() functions
	@Override
	public int compareTo(Newspaper other) {
		return (this.ownNews.size() - other.ownNews.size());
	}
}
