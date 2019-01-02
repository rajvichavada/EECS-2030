package test2;

public class Gray {

	//FIELDS
	public static final double MAX_DOUBLE_VALUE = 1.0;
	public static final int MAX_INT_VALUE  = 255;
	public static final double	MIN_DOUBLE_VALUE = 0.0;
	public static final int	MIN_INT_VALUE = 0;
	
	private double gray;
	//------------------------------------------------------------------------------------------------------------------------------
	//Constructors
	public Gray(double g)
	{
		if (g < 0.0 || g > 1.0)
		{
			throw new IllegalArgumentException ("");
		}
		this.gray = g;
	}
	
	public Gray(int g)
	{
		this.gray = this.asInt();
	}
	
	public Gray(Gray other)
	{
		this.gray = other.gray;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	//Methods
	public int asInt()
	{
		return Gray.toInt(this.gray);
	}
	
	public double asDouble()
	{
		return this.gray;
	}
	
	public static double toDouble(int value)
	{
		return value / Gray.MAX_DOUBLE_VALUE;
	}
	
	public static int toInt(double value)
	{
		return (int) Math.round(Gray.MAX_DOUBLE_VALUE * value);
	}
	
	public static Gray fromRGB(Color c)
	{
		
	}
	
	public String toString()
	{
		
	}
	
	public int compareTo(Gray other)
	{
		
	}
	
	public boolean equals(Object obj)
	{
		
	}
	
	public static void main(String[] args)
	{
		
	}
}
