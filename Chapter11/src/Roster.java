import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Roster {

	public static void main(String[] args) 
	{
		File stuNameFile;
		Scanner userInput = new Scanner(System.in);
		
		String fileName;
		String firstName, lastName;
		int numStudents;
		
		//Get the file name and number from the user
		
		System.out.println("Enter the file name: ");
		fileName = userInput.next();
		stuNameFile = new File(fileName);
		
		System.out.println("Enter number of students: ");
		numStudents = userInput.nextInt();
		
		try
		{
			//Write objects to the file
			
			FileOutputStream out = new FileOutputStream(stuNameFile);
			ObjectOutputStream writeStu = new ObjectOutputStream(out);
			
			for (int i = 0; i < numStudents; i++)
			{
				System.out.println("Enter student first name: ");
				firstName = userInput.next();
				
				System.out.println("Enter student last name: ");
				lastName = userInput.next();
				
				writeStu.writeObject(new StuName(firstName, lastName));
			}
			writeStu.close();
			System.out.println("Data has been written to file.");
			
			//Read and display objects
			
			FileInputStream in = new FileInputStream(stuNameFile);
			ObjectInputStream readStuName = new ObjectInputStream(in);
			
			for (int i = 0; i < numStudents; i++)
			{
				System.out.println((StuName)readStuName.readObject());
			}
			readStuName.close();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("File does not exist.");
			System.err.println("FileNotFoundException: " + e.getMessage());
		}
		
		catch(IOException e)
		{
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}
		
		catch(ClassNotFoundException e)
		{
			System.out.println("Class could not be used to cast object.");
			System.err.println("ClassNotFoundException: " + e.getMessage());
		}
		

	}

}
