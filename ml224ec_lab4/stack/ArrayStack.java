package ml224ec_lab4.stack;

import java.util.Iterator;

public class ArrayStack implements Stack {

	private Object[] elements;
	private int position;
	
	public ArrayStack()
	{
		elements = new Object[0];
		position = elements.length - 1;
	}
	
	public ArrayStack(Object[] elements)
	{
		this.elements = elements;
		position = elements.length - 1;
	}
	
	@Override
	public int size() {
		return elements.length;
	}

	/*
	@Override
	public boolean isEmpty() {
		if (elements.length > 0)
			for (int i = 0; i < elements.length; i++)
				if (elements[i] != null)
					return false;
		return true;
	}
	*/
	
	@Override
	public boolean isEmpty() {
		return elements.length == 0;
	}

	@Override
	public void push(Object element) {
		Object[] newArray = new Object[elements.length + 1];
		position++;
		
		for (int i = 0; i < elements.length; i++)
			newArray[i] = elements[i];
		
		newArray[position] = element;
		elements = newArray;
	}

	@Override
	public Object pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Illegal operation on empty stack!\n");
		
		Object element = elements[position]; // store the item first

		Object[] newArray = new Object[elements.length - 1];
		position--;
		
		for (int i = 0; i < newArray.length; i++)
			newArray[i] = elements[i];
		
		elements = newArray;
		return element;
	}

	@Override
	public Object peek() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Illegal operation on empty stack!\n");
		return elements[position];
	}

	@Override
	public Iterator<Object> iterator() {
		return new ArrayStackIterator(elements);
	}
	
	public String toString()
	{
		String str = "[ ";
		for (int i = 0; i < elements.length; i++)
		{
			str += elements[i].toString();
			if (i < elements.length - 1)
				str += ", ";
		}
		return str + " ]";
	}
}
