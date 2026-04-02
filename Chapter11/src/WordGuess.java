import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGuess 
 {

	public static void main(String[] args) 
	{	
		Scanner userInput = new Scanner(System.in);

		//Create a File object with the name of your file is the parameter
		File dataFile = new File("../Chapter11/src/WordList");	
		
		//Declare a File reader object
		FileReader in;
 
		//Declare a BufferedReader object
		BufferedReader readFile;
		
		//Create a random number object
		Random random = new Random();
		
		int numWords = 0;
		int wordToGuess;
		String secretWord = "";
		String wordSoFar = "";
		String userGuess = "";
		int numGuesses = 0;	

		/* select secret word */
		try {
				//initialize the file reader object to name of the file object
				in = new FileReader(dataFile);
				
                //initialize the BufferedReader object to the name of the file reader as a parameter
				readFile = new BufferedReader(in);

				//Get the number of words in the file using readFile
				while(readFile.readLine() != null)
				{
					numWords++;
				}
				
				//update the word to guess to the random object and number of words read plus one
				wordToGuess = random.nextInt(numWords) + 1;
				
				
               
				readFile.close();
				in.close();
				
				in = new FileReader(dataFile);
				readFile = new BufferedReader(in);

				//Iterate through the word to guess slots
				for (int i = 0; i != wordToGuess; i++)
	               {
						//update the secret word from the lines read from the file
						secretWord = readFile.readLine(); 
	            	   
	               }
				
				//Test to ensure that the selected line and word found are equal
				//System.out.println(wordToGuess); 
				//System.out.println(secretWord);
				
				
                //close your BufferedReader object
				readFile.close();
                //close your FileReader object
				in.close();
    	} 
		
		catch (FileNotFoundException e) 
        {
    		System.out.println("File does not exist.");
    		System.err.println("FileNotFoundException: " + e.getMessage());
		} 
		catch (IOException e) 
        {
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
    	}
		


		/* begin the game */
		System.out.println("WordGuess game.\n");

        //iterate through the secret word, and update the word so far variable to represent using dashes 
		for (int i = 0; i < secretWord.length(); i++)
		{
			wordSoFar += "-";
		}
		
		//Converts strings to char arrays
		char[] secretWordArray = secretWord.toLowerCase().toCharArray();
		char[] wordGuessArray = wordSoFar.toLowerCase().toCharArray();
		
		
		while (!Arrays.equals(secretWordArray, wordGuessArray))
		{
			//output the word so far using dashes
			System.out.println(wordGuessArray);
			
			//?? prompt for a letter
			System.out.println("Guess a letter or enter '!' to guess the word: ");
			userGuess = userInput.next().toLowerCase();
			
			/* increment number of guesses */
			numGuesses++;
			
			//Checks if the user wants the guess the entire word
			if (userGuess.equals("!")) 
			{
				System.out.println("Guess the word: ");
				
				//Updates array to the users guess
				wordGuessArray = userInput.next().toLowerCase().toCharArray();
				
				//Breaks loop
				break;
			}

			//Increments through secret word array
			for (int i = 0; i < secretWordArray.length; i++)
			{
				//Checks if the current spot in the array is equal to the users guess
				if (userGuess.charAt(0) == secretWordArray[i]) {
					//Updates the guessed word to include the guessed letter
					wordGuessArray[i] = userGuess.charAt(0);
				}
			}

		} 


		/* finish game and display message and number of guesses */
		
		System.out.println("The word was: " + secretWord);
		
		if (Arrays.equals(secretWordArray, wordGuessArray)) 
		{
			System.out.println("You won in " + numGuesses + " guesses!");
		}
		else
		{
			System.out.println("You lost with " + numGuesses + " guesses!");
		}
		
		
	}
}