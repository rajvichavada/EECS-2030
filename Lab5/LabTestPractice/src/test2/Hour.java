package test2;

public class Hour {
	//Set fields 
	public static final String AM = "AM";
	public static final String PM = "PM";
	private int hour; 
	
	
	public Hour(int hour) 
	{
		Hour.check24(hour);
		this.hour = hour;
	}
	
	public Hour(Hour other)
	{
		this.hour = other.hour;
	
	}
	
	public Hour(int hour, String ampm) 
	{
		Hour.check12(hour, ampm);
		this.setHour(hour);
        this.hour = Hour.to24HourClock(hour, ampm);
			
	}
	
	public static boolean isValid(int hour)
	{
		if (hour >= 0 && hour <= 24)
		{
			return true;
		}
		return false;
	}
	
	public static boolean isValid(int hour, String ampm)
	{
		if ((hour > 0 && hour <= 12) && (ampm.equals(Hour.AM) || ampm.equals(Hour.PM)))
		{
			return true;
		}
		return false;
	}
	
	public static void check12(int hour, String ampm)
	{
		if (Hour.isValid(hour, ampm) == false)
		{
			 throw new IllegalArgumentException("Not valid fam");
		}
	}
	
	public static void check24(int hour)
	{
		if (Hour.isValid(hour) == false)
		{
			 throw new IllegalArgumentException("Not valid fam");
		}
		
	}
	
	public static int to24HourClock(int hour, String ampm)
	{
		Hour.check12(hour, ampm);
		if (ampm.equals(Hour.AM))
		{
			if (hour == 12)
			{
				hour=0;
				return hour;
			}
			else if (hour > 12 || hour <= 11)
			{
				return hour;
			}
		}
		if (ampm.equals(Hour.PM))
		{
			if (hour >= 1 && hour <= 11)
			{
				return (12 + hour);
			}
			return hour;
		}
		return hour;
	}

	public static int to12HourClock(int hour)
	{
		Hour.check24(hour);
		if (hour == 1 || hour == 12)
		{
			return hour;
		}
		else if (hour > 12)
		{
			return hour;
		}
		else
			return 23-hour;
	}
	
	public int getHour()
	{
		return this.hour;
	}
	
	public void setHour(int hour)
	{
		this.hour = hour;
	}
	
	public void setHour(int hour, String ampm)
	{
		Hour.check12(hour, ampm);
		Hour.to24HourClock(hour, ampm);
		
	}
	
	 public boolean equals(String h) {
	        String[] parts = h.split(" ");
	        int hour = Integer.parseInt(parts[0]);
	        String ampm = parts[1];
	        boolean eq = h != null && Hour.isValid(hour, ampm);
	        if (eq) {
	            eq = this.hour == Hour.to24HourClock(hour, ampm);
	        }
	        return eq;
	    }
}
