package ml224ec_lab4.sortera_orter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SorteraOrter {

	public static void main(String[] args) {

		Path path = Paths.get(args[0]);
		
		try {
			System.out.printf("Reading cities from the file: %s\n", path);
			List<String> buffer = Files.readAllLines(path);
			
			ArrayList<City> cities = new ArrayList<City>();
			Iterator<String> it = buffer.iterator();
			while (it.hasNext())
			{
				String str = it.next();
				if (str.length() == 0)
					continue;
				
				// entries are entered as "NAME;CODE"
				String[] data = str.split(";");
				if (data.length < 2)
					continue;
				
				cities.add(new City(data[0], data[1]));
			}
			
			// Prepare for output
			cities.sort(null);
			Iterator<City> cit = cities.iterator();
			
			// Output
			System.out.printf("Amount cities found: %d\n", cities.size());
			while (cit.hasNext())
				System.out.println(cit.next());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
