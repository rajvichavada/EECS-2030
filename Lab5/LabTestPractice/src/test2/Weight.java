package test2;

public class Weight {
	//fields
	public static final String KG = "kg";
	public static final double KG_PER_LB = 0.45359237;
	public static final String LB = "lb";
	

    private double kg;
    private double lb;
    private String units;

	//--------------------------------------------------------------------------------------------------------------------------------------	
	//Constructors 
	
	public Weight()
	{
		this(0.0, Weight.KG);
	}
	
	public Weight(Weight other)
	{
		this(other.get(), other.getUnits());
	}
	
	public Weight(double wt, String units)
	{
		this.set (wt);
		this.setUnits(units);
		
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//Methods
	public double get()
	{
		 if (this.units.equals(Weight.KG)) 
		 {
	        return this.kg;
	     }
	        return this.lb;
		
	}
	
	public final void set(double wt)
	{
		if (wt < 0.0)
		{
			throw new IllegalArgumentException("its negative");
		}
		
		if (this.units.equals(Weight.KG))
		{
			this.kg = wt;
			this.lb = Weight.toPounds(wt);
		}
			this.lb = wt;
			this.kg = Weight.toKilograms(wt);
	}
	
	public String getUnits()
	{
		return this.units;
	}
	
	public final void setUnits(String units)
	{
		if (!units.equals(Weight.KG) && !units.equals(Weight.LB))
		{
			throw new IllegalArgumentException ("");
		}
		
		this.units = units;
	}
	
	public static double toPounds(double kg)
	{
		double lbw = kg / Weight.KG_PER_LB;
		return lbw;
		
	}

	public static double toKilograms(double lb)
	{
		double kgw = lb * Weight.KG_PER_LB;
		return kgw;
	}
	
	public String toString()
	{
		if (this.units.equals(Weight.KG)) {
            return this.kg + " " + Weight.KG;
        } else {
            return this.lb + " " + Weight.LB;
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
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		Weight other = (Weight) obj;
		 if (Double.doubleToLongBits(this.kg) != Double.doubleToLongBits(other.kg))
		 {
	            return false;
		 }
	        return true;
	}
}//class end 
