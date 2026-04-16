package skillbuilders;

public class Circle 
{
	private static double Pi = 3.14;
	private double radius;
	
	//Default constructor method
	public Circle()
	{
		radius = 1;
	}
	
	//Overload the default constructor 
	public Circle(double r)
	{
		radius = r;
	}
	
	//Modifier 
	public void setRadius(double newR)
	{
		radius = newR;
	}
	
	//Accessor
	public double getRadius()
	{
		return radius;
	}
	
	public double area()
	{
		double circleArea;
		
		circleArea = Pi * radius * radius;
		return(circleArea);
	}
	
	public boolean equals(Object obj)
	{
		Circle testObj = (Circle)obj;
		
		if(testObj.getRadius() == radius)
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
		String circleString;
		
		circleString = "Circle has radius " + radius;
		return(circleString);
	}
}
