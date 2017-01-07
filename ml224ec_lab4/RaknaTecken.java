package ml224ec_lab4;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class RaknaTecken {

	// MAKE SURE THE TEXT FILE IS FORMATTED WITH UTF-8
	public static void main(String[] args) {
		
		Path path = Paths.get(args[0]);
		
		try {
			List<String> buffer = Files.readAllLines(path);
			
			int upperCaseCount = 0;
			int lowerCaseCount = 0;
			int whitespaceCount = 0;
			int otherCount = 0;
			
			Iterator<String> it = buffer.iterator();
			while (it.hasNext())
			{
				String line = it.next();
				for (int i = 0; i < line.length(); i++)
				{
					Character c = line.charAt(i);
					
					if (Character.isUpperCase(c))
						upperCaseCount++;
					else if (Character.isLowerCase(c))
						lowerCaseCount++;
					else if (Character.isWhitespace(c))
						whitespaceCount++;
					else
						otherCount++;
				}
			}
			
			System.out.println("Amount uppercase letters: " + upperCaseCount);
			System.out.println("Amount lowercase letters: " + lowerCaseCount);
			System.out.println("Amount whitespaces: " + whitespaceCount);
			System.out.println("Other: " + otherCount);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
