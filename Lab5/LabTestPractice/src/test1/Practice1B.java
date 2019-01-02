package test1;

import java.util.ArrayList;
import java.util.List;

public class Practice1B {
	
	/*public static Integer last(List<Interger> t)
	{
		 return t.get(t.size() - 1);
		
		
	}*/
	
	public static Integer last(List<Integer> t) 
	{
        return t.get(t.size() - 1);
    }
	
	public static int totalArea(List<Integer> widths, List<Integer> heights)
	{
		int size1 = widths.size();
		int size2 = heights.size();
		int area=0;
	
		
		if (size1 != size2)
		{
			throw new IllegalArgumentException ("Lists are not of the same size");
			
		}
		else
		{
			for (int i = 0; i < size1; i++)
			{
				if (widths.get(i) > 0 && heights.get(i) > 0)
				{
					area += widths.get(i)*heights.get(i);
				}	
			}
		}
		return area;
	}
	
	public static int alternatingSum(List<Integer> t)
	{
		int sum = 0;
		for (int i = 0; i < t.size(); i=i+2)
		{
			for (int j = 0; j < t.size()-1; j=j+2)
			{
				int jj = t.get(j)*-1;
				sum += t.get(i) + jj;
				
			}
		}
		return sum;
	}
	
	public static List<Integer> encode(List<Integer> t)
	{
		List <Integer> result = new ArrayList <Integer>();
		int count = 0;
		
		for (int i=0; i < t.size(); i++)
		{
			
		}
		
	}
}
