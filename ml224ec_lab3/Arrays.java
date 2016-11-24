package ml224ec_lab3;

public class Arrays {
	
	public static int sum(int[] array)
	{
		int r = 0;
		for (int i = 0; i < array.length; i++)
			r += array[i];
		return r;
	}

	public static String toString(int[] array)
	{
		int len = array.length;
		String content = "";
		for (int i = 0; i < len; i++)
			content += (i > 0 ? " " : "") + array[i] + (i == (len - 1) ? "" : ",");
		return String.format("[ %s ]", content);
	}
	
	public static int[] addN(int[] array, int n)
	{
		int len = array.length;
		int[] new_a = new int[len + 1];
		for (int i = 0; i < new_a.length; i++)
		{
			if (i < len)
				new_a[i] = array[i];
			else
				new_a[i] = n;
		}
		return new_a;
	}
	
	public static int[] reverse(int[] array)
	{
		int len = array.length;
		int[] new_a = new int[len];
		for (int i = len, ia = 0; i > 0; i--, ia++)
			new_a[ia] = array[i-1];
		return new_a;
	}
	
	public static boolean hasN(int[] array, int n)
	{
		for (int i = 0; i < array.length; i++)
			if (array[i] == n)
				return true;
		return false;
	}
	
	public static int[] replaceAll(int[] array, int old_int, int new_int)
	{
		int len = array.length;
		for (int i = 0; i < len; i++)
		{
			int pick = array[i];
			if (pick == old_int)
				array[i] = new_int;
		}
		return array;
	}
	
	public static int[] sort(int[] array)
	{
		int length = array.length;
		int[] sorted = array.clone();
		
		// I had to look at a C implementation of this algorithm to find
		// the most optimal way to implement sorting
		for (int i = 0; i < length; i++) // pick our first number
		{
			for (int j = i + 1; j < length; j++) // pick our second number
			{
				// Is the first number bigger than the second number?
				if (sorted[i] > sorted[j]) 
				{
					// Swap array location
					int a = sorted[i];
					sorted[i] = sorted[j];
					sorted[j] = a;
				}
			}
		}
		return sorted;
	}
	
	public static boolean hasSubsequence(int[] array, int[] sequence)
	{
		if (sequence.length < 1)
			return false;
		
		int len = array.length;
		int seqlen = sequence.length;
		int count = 0;	// must match with "seqlen" for the function to return true
		
		for (int i = 0; i < len; i++)
		{
			// are we getting past the limit (length)? Then it is an automatic false
			if ((i + 1 + seqlen - count) > len) 
				return false;
			if (array[i] == sequence[count])
				count++;
			else
				count = 0;
			if (count == seqlen)
				return true;
		}
		return false;
	}
}
