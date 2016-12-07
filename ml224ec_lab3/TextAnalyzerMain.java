package ml224ec_lab3;

public class TextAnalyzerMain {

	private static final String[] INPUT_TEXTS = 
		{
				"My name is Anakin Skywalker. My age is 42.",
				"Java is a delicious kind of coffee.",
				"My other van is a sword van!",
				"Did you know the least secure password is \"1234567890\"?",
				"XERXES was one puppet all along."
		};
	
	public static void main(String[] args) {
		
		for (int i = 0; i < INPUT_TEXTS.length; i++) // extension
		{
			String text = INPUT_TEXTS[i];
			System.out.printf("\nCurrent text is: '%s'\n", text); // extension
			TextAnalyzer ta = new TextAnalyzer(text);
			
			System.out.println("Char Count: "+ ta.charCount());
			System.out.println("Upper Case Count: "+ ta.upperCaseCount());
			System.out.println("Whitespace Count: "+ ta.whitespaceCount());
			System.out.println("Digit Count "+ ta.digitCount());
					
			if (ta.containsChar('x'))
				System.out.println("The text contains char \'x\'");
			if (ta.containsChar('!')) // extension
				System.out.println("The text contains char \'!\'");
					
			if (ta.containsString("nakin"))
				System.out.println("The text contains substring \"nakin\"");
			if (ta.containsString("word")) // extension
				System.out.println("The text contains substring \"word\"");
		}

	}

}
