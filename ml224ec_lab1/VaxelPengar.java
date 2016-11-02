package ml224ec_lab1;

import java.util.Scanner;

public class VaxelPengar {
	
	private static class CurrencyInfo {
		public final int VALUE;
		public final CurrencyType TYPE;
		
		public CurrencyInfo(int value, CurrencyType type)
		{
			this.VALUE = value;
			this.TYPE = type;
		}
		
		public String toString()
		{
			return Integer.toString(VALUE) + "-" + (TYPE == CurrencyType.BILL ? "lappar" : "kronor");
		}
	}
	
	private enum CurrencyType {
		BILL,
		COIN
	}
	
	private static CurrencyInfo[] currencyInfos = 
		{
			new CurrencyInfo( 1000, CurrencyType.BILL ),
			new CurrencyInfo( 500, 	CurrencyType.BILL ),
			new CurrencyInfo( 100, 	CurrencyType.BILL ),
			new CurrencyInfo( 50, 	CurrencyType.BILL ),
			new CurrencyInfo( 20, 	CurrencyType.BILL ),
			new CurrencyInfo( 10, 	CurrencyType.COIN ),
			new CurrencyInfo( 5, 	CurrencyType.COIN ),
			new CurrencyInfo( 1, 	CurrencyType.COIN )
		};

	public static void main(String[] args) {
		
		double cost;
		int payment;
		int change;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Ange kostnaden: ");
		cost = input.nextDouble();
		
		System.out.print("Ange erhållet belopp: ");
		payment = input.nextInt();
		
		change = (int) Math.round(payment - cost);
		System.out.printf("Växel tillbaka: %d\n", change);
		
		int changeRemainder = change;
		for (int i = 0; i < currencyInfos.length; i++)
		{
			int value = currencyInfos[i].VALUE;
			int count = (int) Math.floor(changeRemainder/value);
			System.out.printf("%s\t: %d\n", currencyInfos[i], count);
			changeRemainder -= value*count;
		}	
		
	}

}
