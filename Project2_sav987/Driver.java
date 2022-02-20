package assignment2;

/*
 * EE422C Project 2 (Mastermind) submission by Sylvia Vu
 * Replace <...> with your actual data. 
 * Name: Sylvia Vu
 * UT EID: sav987
 * Slip days used: <1>
 * Spring 2020
 */



import java.util.Scanner;

public class Driver {
	
	/**
	 * 
	 * @param args
	 * 
	 * boolean test = determines if the game is in testing mode
	 * numGuesses = total number of guesses user is allowed
	 * Scanner input = object to handle user I/O
	 * 
	 */
	public static void main(String[] args) {
		
		boolean test = false;			// if args[0] == 1, set test to TRUE
		int totalGuesses = GameConfiguration.guessNumber;
		Scanner input = new Scanner(System.in);
		
		// initial greeting message
		System.out.println("Welcome to Mastermind.");
		System.out.println("Do you want to play a new game? (Y/N):");
		String play = input.nextLine();
		
		while(play.equals("Y")) {
			
			if(args.length != 0) {			
				if(args[0].equals("1")) {
					test = true;
				}
			}
			
			History history = new History();		// create new History object 
			Game beginGame = new Game(input, history, totalGuesses, test);
			play = beginGame.runGame();
			
		}
		
	}

}
