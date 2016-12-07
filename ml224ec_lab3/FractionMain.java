package ml224ec_lab3;

public class FractionMain {

	public static void main(String[] args) {
		
		Fraction[] fs = {
				new Fraction(),
				new Fraction(20,-5),
				new Fraction(4,4),
				new Fraction(3,21),
				new Fraction(2,0)
		};
		
		Fraction fa = new Fraction(3,2);
		Fraction fb = new Fraction(5,6);
		Fraction fc = new Fraction(-2,2);
		
		int len = fs.length;
		for (int i = 0; i < len; i++)
		{
			Fraction f = fs[i];
			
			System.out.printf("\nUnit test for Fraction with the value %s\n", f);
			System.out.printf("getNumerator\t: %d\n", f.getNumerator());
			System.out.printf("getDenominator\t: %d\n", f.getDenominator());
			System.out.printf("isNegative\t: %s\n", f.isNegative());
			System.out.printf("isVaild\t\t: %s\n", f.isVaild());
			
			System.out.printf("add(%s)\t: %s\n", fa, f.add(fa));
			System.out.printf("add(%s)\t: %s\n", fb, f.add(fb));
			System.out.printf("add(%s)\t: %s\n", fc, f.add(fc));
			
			System.out.printf("subtract(%s)\t: %s\n", fa, f.subtract(fa));
			System.out.printf("subtract(%s)\t: %s\n", fb, f.subtract(fb));
			System.out.printf("subtract(%s)\t: %s\n", fc, f.subtract(fc));
			
			System.out.printf("multiply(%s)\t: %s\n", fa, f.multiply(fa));
			System.out.printf("multiply(%s)\t: %s\n", fb, f.multiply(fb));
			System.out.printf("multiply(%s)\t: %s\n", fc, f.multiply(fc));
			
			System.out.printf("divide(%s)\t: %s\n", fa, f.divide(fa));
			System.out.printf("divide(%s)\t: %s\n", fb, f.divide(fb));
			System.out.printf("divide(%s)\t: %s\n", fc, f.divide(fc));
			
			for (int I = 0; I < len; I++ )
			{
				Fraction of = fs[I];
				System.out.printf("isEqualTo(%s)\t: %s\n", of, f.isEqualTo(of));
			}
		}

	}

}
