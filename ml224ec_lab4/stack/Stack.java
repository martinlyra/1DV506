package ml224ec_lab4.stack;

import java.util.Iterator;

public interface Stack {
	int size();
	
	boolean isEmpty();
	
	void push(Object element);
	
	Object pop();	// get topmost (last) element, removing from stack
	Object peek();  // get topmost (last) element, without removal
	
	Iterator<Object> iterator();
}
