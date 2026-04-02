import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Stats2 {
	
	public static void main(String[] args) 
	{

		File dataFile;
		FileReader in;
		BufferedReader readFile;
		FileWriter out; 
		BufferedWriter writeFile;
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		Scanner userinput = new Scanner(System.in);
		
		String fileName;
		
		String stuName, score;
		int numStu;
		double scoreValue;
		double lowScore = 100;
		double highScore = 0;
		double avgScore;
		double totalScore = 0;
		int numScores = 0;
		
		//Write data to file
		System.out.println("Enter the file name: ");
		fileName = userinput.next();
		System.out.println("How many students: ");
		numStu = userinput.nextInt();
		
		try
		{
			dataFile = new File(fileName);
			out = new FileWriter(dataFile);
			writeFile = new BufferedWriter(out);
			
			for(int i = 0; i < numStu; i++)
			{
				System.out.println("Enter student name: ");
				stuName = userinput.next();
				
				System.out.println("Enter test score: ");
				score = userinput.next();
				
				writeFile.write(stuName);
				writeFile.newLine();
				writeFile.write(score);
				writeFile.newLine();
			}
			writeFile.close();
			out.close();
			System.out.println("Data written to file.");
		}
		catch(IOException e)
		{
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}
		
		
		//Read data from file and process
		try
		{
			dataFile = new File(fileName);
			in = new FileReader(dataFile);
			readFile = new BufferedReader(in);
			
			while((stuName = readFile.readLine()) != null)
			{
				score = readFile.readLine();
				System.out.println(stuName + " " + score);
				
				numScores += 1;
				scoreValue = Double.parseDouble(score);
				totalScore += scoreValue;
				
				if(scoreValue < lowScore)
				{
					lowScore = scoreValue;
				}
				if(scoreValue > highScore)
				{
					highScore = scoreValue;
				}
			}
			
			avgScore = totalScore / numScores;
			
			System.out.println("Low score = " + percent.format(lowScore/100));
			System.out.println("High score = " + percent.format(highScore/100));
			System.out.println("Average = " + percent.format(avgScore/100));
			
			readFile.close();
			in.close();
			
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
		
	}
}
