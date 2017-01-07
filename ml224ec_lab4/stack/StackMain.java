package ml224ec_lab4.stack;

import java.util.Iterator;
import java.util.Random;

public class StackMain {

	// change this to true to invoke exceptions
	private static final boolean INVOKEEXCEPTION = false;
	
	private static final Stack[] STACKS = {
			new ArrayStack(),
			new ArrayStack(new Object[]{ 12, 13, "Hello"})
	};
	
	// list of random objects picked randomly for push()
	private static final Object[] PUSHOBJECTS = {
			144,
			899,
			"Foo",
			"Bar",
			"Bass",
			"Drum",
			"1 + 1 is 11",
			"1 + 1 is 2"
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < STACKS.length; i++)
		{
			Stack stack = STACKS[i];
			try {
				System.out.printf("isEmpty(): %s\n", stack.isEmpty());
				System.out.printf("size(): %d\n", stack.size());
				System.out.printf("Contents: %s\n\n", stack);
				
				stack.push( pick(PUSHOBJECTS) ); 
				System.out.println("Pushed in a random object using 'push(Object)'");
				
				System.out.printf("Contents: %s\n\n", stack);
				System.out.printf("Peek: %s\n", stack.peek()); // throws
				System.out.printf("Contents: %s\n\n", stack);
				System.out.printf("Pop: %s\n", stack.pop()); // throws
				System.out.printf("Contents: %s\n", stack);
				
				System.out.println("\nIterator: ");
				Iterator<Object> it = stack.iterator();
				while (it.hasNext())
					System.out.println(it.next());
				
				System.out.println("\nFor loop when not empty: ");
				if (!stack.isEmpty())
					while (stack.size() > 0)
					{
						Object o = stack.pop(); // throws
						int s = stack.size();
						
						System.out.printf("Popped out '%s'. %d elements remaining\n", o, s);
					}
				else 
					System.out.println("It was empty..\n");
				
			} catch (EmptyStackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (INVOKEEXCEPTION)
			{
				try {
					stack.peek();
				} catch (EmptyStackException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// returns a random object from an array
	private static Object pick(Object[] array)
	{
		return array[new Random().nextInt(array.length)];
	}

}
