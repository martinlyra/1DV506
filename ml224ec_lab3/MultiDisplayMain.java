package ml224ec_lab3;

public class MultiDisplayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MultiDisplay md = new MultiDisplay();
		
		md.setDisplayMessage("Hello world!");
		md.setDisplayCount(4);
		md.display();
		
		md.display("I dream of being an useful library!", 2);
		
		System.out.println("The current message stored in Multidisplay: \"" + md.getDisplayMessage() + '"');
	}

}
