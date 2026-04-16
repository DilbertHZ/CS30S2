/*

Program: CountVowels.java          Last Date of this Revision: April 9, 2026

Purpose: An application that counts the number of vowels within a file.

Author: Hunter Zahn, 
School: CHHS
Course: Computer Programming 30
 

*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountVowels 
{

   public static void main(String[] args) 
   {
       File textFile;
       FileReader in;
       BufferedReader readFile;
       String fileName;
       String lineInFile, lowercaseText;
       int vowelSum = 0;
       int vowelName = 0;
       String vowels = "aeiou";
       
       Scanner userInput = new Scanner(System.in);

       /* prompt the user for the name of the file */
       System.out.println("Enter the file name: ");
       fileName = userInput.next();

       /* count the vowels in the file */
       try {
                //new File object required
    	   		textFile = new File(fileName); 
    	   		
                //new File reader object required
    	   		in = new FileReader(textFile);
    	   		
                //new BufferedReader object required
    	   		readFile = new BufferedReader(in);
				
    	   		while((lineInFile = readFile.readLine()) != null)
				{
    	   			//as lines are read convert them to lower case
    	   			lowercaseText = lineInFile.toLowerCase();
    	   			
    	   			//iterate through the lower case text
    	   			for (int i = 0; i < lowercaseText.length(); i++)
    	   			{
    	   				//using the String class 
                        //check if each character traverse through is a vowel
    	   				if (vowels.contains(String.valueOf(lowercaseText.charAt(i))))
	   					{
    	   				//update total vowels
	   						vowelSum++;
	   					}
    	   			}

				}
    	   		
    	   		//User wants to know the number of vowels inside a file name
    	   		//iterates through file name
    	   		for (int i = 0; i < textFile.getName().length(); i++)
	   			{
    	   		//using the String class 
                    //check if each character traverse through is a vowel
	   				if (vowels.contains(String.valueOf(fileName.charAt(i))))
   					{
	   					vowelName++;
   					}
	   			}
    	   		
    	   		//Prints vowel count
    	   		System.out.println("The file " + fileName + " contains " + vowelSum + " vowels. Its name contains " + vowelName + " vowels.");
    	   		
    	   		//close BufferedReader object
    	   		readFile.close();
    	   		//close FileReader object
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
