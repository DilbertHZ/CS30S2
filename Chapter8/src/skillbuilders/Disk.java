package skillbuilders;

public class Disk extends Circle
{
	private double thickness;
	
	//Overload constructor method
	public Disk(double r, double t)
	{
		super(r);
		thickness = t;
	}
	
	//Modifier
	public void setThickness(double newT)
	{
		 thickness = newT;
	}
	
	//Accessor
	public double getThickness()
	{
		return thickness;
	}
	
	public double volume()
	{
		double v;
		
		v = super.area() * thickness;
		
		return v;
	}
	
	public boolean equals(Object obj)
	{
		Disk testObj = (Disk)obj;
		
		if(testObj.getRadius() == super.getRadius() && testObj.getThickness() == thickness)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		String diskString;
		
		diskString = "The disk has a radius of " + super.getRadius() + " and a thickness of " + thickness;
		
		return diskString;
	}
}
