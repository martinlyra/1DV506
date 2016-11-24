package ml224ec_lab2;

public class BytaPlats {

	public static void main(String[] args) {
		char[] text = { 't', 't', '�', 'l', ' ', 'r', 'a', 'v', ' ', 'a', 
     			't', 't', 'e', 'D' };
		
		for (int i = 0; i < Math.floor(text.length/2); i++)
		{
			int r = text.length - 1 - i;
			
			char c = text[r]; // prepare swapping
			text[r] = text[i]; // swap
			text[i] = c; // finish swapping
		}
		
		System.out.println(text);
	}

}
