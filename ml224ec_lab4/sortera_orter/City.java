package ml224ec_lab4.sortera_orter;

public class City implements Comparable<City> {

	private final String name;
	private final int postalCode;
	
	public City(String name, int postalCode) {
		this.name = name;
		this.postalCode = postalCode;
	}
	
	public City(String name, String postalCode)
	{
		this.name = name;
		this.postalCode = Integer.parseInt(postalCode);
	}

	public String getName()
	{
		return name;
	}
	
	public int getPostalCode()
	{
		return postalCode;
	}
	
	@Override
	public int compareTo(City other) {
		int diff = this.postalCode - other.postalCode;
		
		if (diff == 0)
			return this.name.compareTo(other.name);
		return diff;
	}

	public String toString()
	{
		return postalCode + " " + name;
	}
}
