import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * 
 */

/**
 * @author marcoduran
 *
 */
public class Main {

	/**
	 * @param args
	 */
	// Creating main and making a throw exception just in case there is a error
	// reading the file object
	public static void main(String[] args) throws Exception {

		// Creating file object to grab text information file
		File Dictionary = new File("/Users/marcoduran/git/Hangman/Hangman/src/Dictionary.txt");

		Scanner textScanner = new Scanner(Dictionary); // Creating scanner to allow us to read file
		Scanner input = new Scanner(System.in); // Creating scanner for user input

		// Creating an array list (string) for the words that are in dictionary
		ArrayList<String> words = new ArrayList<>();
		// While loop theres a next line seperating the words, the scanner will continue
		// to add words to list
		while (textScanner.hasNextLine()) {
			words.add(textScanner.nextLine());
		}

		// Creating a string that will randomize what word we get from list
		String hidden_text = words.get((int) (Math.random() * words.size())); // Casting to int so we can use
																				// math.random

		// Now that we have the words, we need to change to a CharArray

		// Declaring a CharArray
		char[] textArray = hidden_text.toCharArray(); // Allows array to check letters
		char[] myAnswers = new char[textArray.length]; // CharArray that will record answers

		// Initializing answers with question marks
		for (int i = 0; i < textArray.length; i++) {
			myAnswers[i] = '?';
		}

		boolean finished = false;
		// loop will continue to happen until game ends, finish == true
		while (finished == true) {
		System.out.println("****************************");
		
		String letter = input.next(); //User input
		//Checks for valid input
		while(letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
			System.out.println("Error Input - Try Again");
			letter = input.next();
		}
		//Checks if letter is in the word
		boolean found = false;
		
		}
	}

}
