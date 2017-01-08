package ml224ec_lab4.nyhetsbyra;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewsAgency {
	
	private List<Newspaper> registeredPapers;
	
	public NewsAgency()
	{
		registeredPapers = new ArrayList<Newspaper>();
	}
	
	// Registers newspapers to the agency,
	// any future news will be shared with this and other papers
	// registered at this agency
	public void register(Newspaper np)
	{
		if (!isRegistered(np))
		{
			registeredPapers.add(np);
			np.addAgency(this); // required to make newspapers able to publicize their articles
		}
	}
	
	// Checks whether the given newspaper is registered at this agency
	public boolean isRegistered(Newspaper np)
	{
		return registeredPapers.contains(np);
	}
	
	// Shares the given news to other newspapers registered
	// at this agency
	public void boardcast(News news)
	{
		Iterator<Newspaper> it = registeredPapers.iterator();
		
		while(it.hasNext())
		{
			Newspaper np = it.next();
			
			if (!np.hasAuthorized(news)) // do not share news they are the source of
				np.add(news);
		}
	}
}
