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

		// Greating user and explaining rules
		System.out.println("Welcome to Hangman!");
		System.out.println(); // Line break
		System.out.println("Rules of the game: ");
		System.out.println("In this game you will have 6 lives to guess the right letters that are in the hidden word");
		System.out.println("Every letter that you guess wrong will cause you to lose a life");
		System.out.println("If you lose all 6 lives and the hangman is drawn, you lose!");
		System.out.println("If you guess all letters in the hidden word, you win!");
		System.out.println(); // Line break

		System.out.println("*ONLY LOWER CASE LETTERS ALLOWED*");
		System.out.println("Lets see if you can win...");
		System.out.println(); // Line break

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

		boolean finished = false; // Creating boolean for finished variable
		int lives = 6; // Number of lives player will have
		// loop will continue to happen until game ends, finish == true
		System.out.println("-----------------------------------");
		System.out.println("There are " + textArray.length + " letters in the word."); // Lets player know how many
																						// letters are in hidden word
		System.out.print("Type any letter to start the game: ");
		System.out.println(); // Line break

		while (finished == false) { 

			System.out.println(); // Line break
			System.out.println("****************************");
			System.out.println(); // Line break

			String letter = input.next(); // User input
			// Checks for valid input
			while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
				System.out.println("Error Input - Try Again");
				letter = input.next();
			}
			// Checks if letter is in the word
			boolean found = false;
			for (int i = 0; i < textArray.length; i++) {
				if (letter.charAt(0) == textArray[i]) {
					myAnswers[i] = textArray[i];
					found = true;
				}
			}
			// If will loop will run if the letter is not found
			if (!found) {
				lives--; // Losing a life
				System.out.println("Wrong letter");
			}
			boolean done = true;
			// Loop will run to show what letter have been used
			for (int i = 0; i < myAnswers.length; i++) {
				if (myAnswers[i] == '?') {
					System.out.print(" _");
					done = false;
				} else {
					System.out.print(" " + myAnswers[i]);
				}
			}
			System.out.println("\n" + "Lives left: " + lives);
			drawHangman(lives);

			// Chcek if the game ends

			if (done) {
				System.out.println("Congrats You Found the Word!!");
				finished = true; // Win
			}
			if (lives <= 0) {
				System.out.println("You are dead!  Study Your English");
				finished = true; // Lose
			}
		}
		System.out.println(hidden_text); // Displaying hidden word

		textScanner.close();
		input.close();
	}

	// Creating a function that will draw the hangman depending on how many lives
	// you have
	public static void drawHangman(int l) {
		if (l == 6) {
			System.out.println("|----------");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 5) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 4) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|    |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 3) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|   -|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 2) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|   -|-");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 1) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|   -|-");
			System.out.println("|   /");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|   -|-");
			System.out.println("|   /|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		}
	}

}
