package test2;

public class Temperature {
	//Fields
	public static final String CELCIUS = "C";
	public static final String FAHRENHEIT = "F";
	//private double temp;
	private  String units;
    private double degC;
	private double degF;
	
	//Constructors
	public Temperature()
	{
		this(0.0, Temperature.CELCIUS);
	}

	public Temperature(Temperature other)
	{
		this(other.getTemperature(), other.getUnits());
	}
	
	public Temperature(double temp, String units)
	{
		this.setTemperature(temp);
		this.setUnits(units);	
	}
	
	//Methods
	public double getTemperature()
	{
		 if (this.units.equals(Temperature.CELCIUS)) 
		 {
	            return this.degC;
	     }
	        return this.degF;
	}
	
	public final void setTemperature(double temp)
	{
		
		if (this.units.equals(Temperature.CELCIUS))
		{
			this.degC = temp;
			this.degF = Temperature.toFahrenheit(temp);
		}
		else 
		{
			this.degF = temp;
			this.degC = Temperature.toCelcius(temp);
		}
	
	}
	
	public String getUnits()
	{
		return this.units;
	}
	
	public final void setUnits(String units)
	{
		if (!units.equals(Temperature.CELCIUS) && !units.equals(Temperature.FAHRENHEIT))
		{
			throw new IllegalArgumentException ("Not a valid unit dawg");
		}
		else
			this.units = units;
	}
	
	public static double toCelcius(double degF)
	{
		double cel;	
		cel = (degF - 32.0) * (5.0/9.0);
		return cel;
		
	}
	
	public static double toFahrenheit(double degC)
	{
		double fah;
		fah = degC * (9.0 / 5.0) + 32.0;
		return fah;
		
	}
	
	public String toString()
	{
		   if (this.getUnits().equals(Temperature.CELCIUS)) 
		   {
	            return this.getTemperature() + Temperature.CELCIUS;
	        }
		   else 
		   {
	            return this.getTemperature() + Temperature.FAHRENHEIT;
	        }
		
	}
	
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
			Temperature other = (Temperature) obj;
		
		 if (Double.doubleToLongBits(this.degC) != Double.doubleToLongBits(other.degC))
	            return false;
	        return true;
	}
}
