package ml224ec_lab2;

public class BytaPlats {

	public static void main(String[] args) {
		char[] text = { 't', 't', 'ä', 'l', ' ', 'r', 'a', 'v', ' ', 'a', 
     			't', 't', 'e', 'D' };
		
		for (int i = 0; i < Math.floor(text.length/2); i++)
		{
			int r = text.length - 1 - i;
			char c = text[r];

			text[r] = text[i];
			text[i] = c;
		}
		
		System.out.println(text);
	}

}
