package skillbuilders;

public class Puck extends Disk implements Comparable
{
	private double weight;
	private boolean standard, youth;
	
	public double MIN_STD_W = 5;
	public double MAX_STD_W = 5.5;
	public double MIN_YTH_W = 4;
	public double MAX_YTH_W = 4.5;
	
	//Overload constructor method
	public Puck(double w)
	{
		super(1.5, 1);
		weight = w;
		
		if (weight >= MIN_STD_W && weight <= MAX_STD_W)
		{
			standard = true;
			youth = false;
		}
		else
		{
			standard = false;
			youth = true;
		}
	}
	
	//Accessor method
	public double getWeight()
	{
		return weight;
	}
	
	//Modifier method
	public void setWeight(double w)
	{
		weight = w;
	}
	
	public String getDivision()
	{
		String div;
		
		if(standard)
		{
			div = "Puck is standard";
		}
		else
		{
			div = "Puck is youth";
		}
		
		return div;
	}
	
	public boolean equals(Object obj)
	{
		Puck testObj = (Puck)obj;
		
		if(testObj.getDivision() == getDivision())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int compareTo(Object p)
	{
		Puck testPuck = (Puck)p;
		
		if (weight < testPuck.getWeight())
		{
			return -1;
		}
		else if (weight == testPuck.getWeight())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	public String toString()
	{
		String puckString;
		
		puckString = "The puck has a weight of " + getWeight() + " and the division is " + getDivision() + ".";
		
		return puckString;
	}
}
