package test1;

import java.util.ArrayList;
import java.util.List;

public class Practice1A {
	public static String TEST_STRING;
	
	public static String hello(String name)
	{
		return "Hello " + name;
	}
	
	public static List<Character> repeatedChars (String s)
	{
		List <Character> result = new ArrayList<Character>();
		char c;
		for (int i = 0; i < s.length(); i++)
		{
			for (int j = i+1; j < s.length(); j++)
			{
				if (s.charAt(i)==s.charAt(j))
				{
					c = s.charAt(i);
					result.add(c);
					break; 
				}
			}	
		}
		return result; 
	}
	
	public static List<Character> shuffleChars (List<Character> t)
	{
		int n = t.size();
		
		List<Character> result = new ArrayList<Character>();
		
		for(int i = 0; i < n/2; i++)
		{
			result.add(t.get(i));
			result.add(t.get(i + n/2));
		}
		return result;
	}
	
	public static String toString(List<Character> t)
	{
		int n = t.size();
		String result = "";
		if (n== 0)
		{
			throw new IllegalArgumentException ("List is Empty");
		}
		
		for (int i = 0; i < n; i++)
		{
			char c = t.get(i);
			result = result + c;
		}
		return result; 
	}
	
		public static void main (String[] args)
		{
			List <Character> ex = new ArrayList<Character>();
		}

}

