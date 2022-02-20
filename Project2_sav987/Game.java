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


public class Game {
	
	private String secretCode;
	private int numGuesses;
	
	History history;
	Scanner input;
	int valid;
	boolean test;
	
	String startGame = "Y";
	
	/**
	 * constructor for a new game
	 * @param Scanner input = user i/o
	 * @param History history = list of previous user guesses
	 * @param int totalGuesses = number of times the user can guess before the game concludes
	 * @param boolean test = determines if the game is in testing mode (show secret code)
	 */
	public Game(Scanner input, History history, int numGuesses, boolean test) {
		
		this.secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		this.input = input;
		this.history = history;
		this.numGuesses = numGuesses;
		this.test = test;
		
		// if the game is in testing mode, print the secret code followed by a blank line
		if(test) {
			System.out.println("Secret Code: " + secretCode);
			System.out.println();
		}
	}
	
	/**
	 * Helps determine the state of the game
	 * Needs to handle what happens next (prompt user, end game, checks guess validity)
	 * 
	 * @return String play = Determines subsequent game action
	 */
	public String runGame() {
		
		System.out.println();			
		System.out.println("You have " + numGuesses + " guess(es) left.");
		System.out.println("Enter guess:");
		String userGuess = input.nextLine();			// expecting input from user
		GuessInfo guess = new GuessInfo(userGuess);		// create a new GuessInfo object from the user input
		int historySize;
		
		valid = guess.isGuessValid();	// should return 1, 0, or -1
		
		// print history if valid = 0
		// if the history is currently empty
		if(valid == 0) {
			historySize = history.history.size();
			if(historySize == 0) {
				System.out.println();
				startGame = runGame();
			}
			
			// if history is not empty, print 
			else {
				history.historyList();
				System.out.println();
				startGame = runGame();
			}
		}
		
		// if guess was invalid:
		 	// print INVALID_GUESS
		 	// DO NOT SUBTRACT FROM REMAINING GUESSES
		 	// repeat game
		else if(valid == -1) {
			System.out.println("INVALID_GUESS");
			System.out.println();
			startGame = runGame();
		}
		
		// if guess was valid:
				 // check if guess was correct
				 // check if user is out of tries -> lost game
				 // repeat if user still has guesses left
				 // subtract from number of remaining guesses
				 // add to history
		else {
			
			numGuesses--;		// deduct from # of remaining guesses
			Feedback pegs = new Feedback(guess, this.secretCode);		// create a new Feedback object
			history.addToHistory(guess.userGuess, pegs.feedback);		// add the guess to the user's history
			System.out.println(history.history.get(history.history.size()-1));		// repeat the user's guess
			
			
			// if the user has run out of guesses -> game over (user lost)
			// if last guess was not correct:
				// print "you lose" statement + reveal secret code
				// blank line
				// prompt for new game
			if(numGuesses <= 0) {
				
				// if(pegs.black != GameConfiguration.pegNumber) {
					System.out.println("You lose! The pattern was " + this.secretCode);
					System.out.println();
					System.out.println("Do you want to play a new game? (Y/N):");
					startGame = input.nextLine();
				//}
			}
			
			// if the user has correctly guessed the secret code
				// print "you win"
				// blank line
				// prompt for new game
			else if(pegs.black == GameConfiguration.pegNumber) {
				System.out.println("You win!");
				System.out.println();
				System.out.println("Do you want to play a new game? (Y/N):");
				startGame = input.nextLine();
			}
			
			else {
				System.out.println();
				startGame = runGame();
			}
		
		}
		
		return startGame;

	}

	
}
