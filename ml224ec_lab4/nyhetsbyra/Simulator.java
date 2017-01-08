package ml224ec_lab4.nyhetsbyra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {

	private Random rand;
	
	private List<News> news;
	private List<Newspaper> newspapers;
	private List<NewsAgency> newsAgencies;
	
	private final int maxNewspapers;
	private final int maxArticles;
	private final int maxAgencies;
	
	public Simulator(int newpaperCount, int articleCount)
	{
		rand = new Random();
		news = new ArrayList<News>();
		newspapers = new ArrayList<Newspaper>();
		newsAgencies = new ArrayList<NewsAgency>();
		
		maxNewspapers = newpaperCount;
		maxArticles = articleCount;
		maxAgencies = 1; // currently does simulate only one, schedule cuttings
	}
	
	// Setup all necessary for an simulation
	public void initialize()
	{
		for (int i = 0; i < maxNewspapers; i++) // Create all the newspapers
			newspapers.add(new Newspaper());
		
		for (int i = 0; i < maxAgencies; i++) // Create all the agencies (currently only one)
		{
			NewsAgency na = new NewsAgency();
			newsAgencies.add(na);
			for (int j = 0; j < newspapers.size(); j++) // register all the newspapers!
				na.register(newspapers.get(j));
		}
	}
	
	// Run an simulation of the scenario
	public void run()
	{
		for (int i = 0; i < maxArticles; i++)
		{
			Newspaper np = newspapers.get(rand.nextInt(maxNewspapers)); // pick an random newspaper
			
			news.add(np.createNews()); // the latter function returns an instance of News
			
			if (np.hasUnpublicizedNews())
				np.publicize();
		}
	}
	
	public List<News> getNews()
	{
		return news;
	}
	
	public List<Newspaper> getNewspapers()
	{
		return newspapers;
	}
	
	public List<NewsAgency> getNewsAgencies()
	{
		return newsAgencies;
	}
}
