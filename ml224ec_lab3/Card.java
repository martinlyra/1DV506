package ml224ec_lab3;

enum CardValue
{
	Two		("Two"),
	Three	("Three"),
	Four	("Four"),
	Five	("Five"),
	Six		("Six"),
	Seven	("Seven"),
	Eight	("Eight"),
	Nine	("Nine"),
	Ten		("Ten"),
	Knight	("Knight"),
	Queen	("Queen"),
	King	("King"),
	Ace		("Ace");
	
	private final String name;
	
	private CardValue(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name;
	}
}

enum CardSymbol
{
	Spades		("Spades"),
	Clubs		("Clubs"),
	Diamonds	("Diamonds"),
	Hearts		("Hearts");
	
	private final String name;
	
	private CardSymbol(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name;
	}
}

public class Card {
	private final CardValue value;
	private final CardSymbol symbol;
	
	public Card(CardValue value, CardSymbol symbol)
	{
		this.value = value;
		this.symbol = symbol;
	}
	
	public CardValue getValue()
	{
		return value;
	}
	
	public CardSymbol getSymbol()
	{
		return symbol;
	}
	
	public String toString()
	{
		return symbol.toString() + " " + value.toString();
	}
}
