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
	//Creating main and making a throw exception just in case there is a error reading the file object
	public static void main(String[] args) throws Exception  {
		
		//Creating file object to grab text information file
		File Dictionary = new File("/Users/marcoduran/git/Hangman/Hangman/src/Dictionary.txt"); 
		
		//Creating scanner to allow us to read file
		Scanner textScanner = new Scanner(Dictionary);
		
		//Creating an array list (string) for the words that are in dictionary 
		ArrayList<String> words = new ArrayList<>();
		

	}

}
