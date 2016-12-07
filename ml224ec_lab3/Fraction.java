package ml224ec_lab3;

public class Fraction {
	
	final int numerator, denominator;
	final Double result;
	
	final boolean vaild;
	
	public Fraction()
	{
		this(1,1);
	}
	
	public Fraction(int numerator, int denominator)
	{
		int gcd = this.gcd(numerator, denominator);
		
		this.numerator = numerator/gcd;
		this.denominator = denominator/gcd;
		
		if (denominator == 0)
		{
			this.result = null;
			vaild = false;
			return;
		}
		
		this.result = (double) (numerator/denominator);
		vaild = true;
	}
	
	public Fraction add(Fraction other)
	{
		int n = (numerator * other.denominator) + (other.numerator * denominator);
		int d = (denominator * other.denominator);
		return new Fraction(n,d);
	}
	
	public Fraction subtract(Fraction other)
	{
		int n = (numerator * other.denominator) - (other.numerator * denominator);
		int d = (denominator * other.denominator);
		return new Fraction(n,d);
	}
	
	public Fraction multiply(Fraction other)
	{
		int n = (numerator * other.numerator);
		int d = (denominator * other.denominator);
		return new Fraction(n,d);
	}
	
	public Fraction divide(Fraction other)
	{
		int n = (numerator * other.denominator);
		int d = (denominator * other.numerator);
		return new Fraction(n,d);
	}
	
	// the recursive implementation of Greatest Common Divisor according to 
	// the Euclidean algorithm page on Wikipedia
	// quick tests show that it gives the same result regardless order of a or b
	private int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
	
	public boolean isEqualTo(Fraction other)
	{
		return (numerator == other.numerator && denominator == other.denominator);
	}
	
	public String toString()
	{
		if (vaild)
		{
			if (numerator == 0)
				return "0";
			else if (numerator == denominator)
				return "1";
		}
		return numerator + "/" + denominator;
	}
	
	public boolean isNegative()
	{
		return result != null && result < 0;
	}
	
	public boolean isVaild()
	{
		return vaild;
	}
	
	public int getNumerator()
	{
		return numerator;
	}
	
	public int getDenominator()
	{
		return denominator;
	}
}
