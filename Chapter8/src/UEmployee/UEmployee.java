package UEmployee;

public class UEmployee 
{

	private String fName, lName;
	private double salary;
	
	public void Employee(String fn, String ln)
	{
		fName = fn;
		lName = ln;
	}
	
	public String toString()
	{
		return(fName + " "+ lName);
	}
	
}
