package ml224ec_lab4.stack;

import java.util.Iterator;

public class ArrayStackIterator implements Iterator<Object> {

	private Object[] arrayStack;
	private int position;
	
	public ArrayStackIterator() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayStackIterator(Object[] arrayStack)
	{
		this.arrayStack = arrayStack;
		position = this.arrayStack.length - 1;
	}

	@Override
	public boolean hasNext() {
		return (position) >= 0;
	}

	@Override
	public Object next() {
		return arrayStack[position--];
	}

}
