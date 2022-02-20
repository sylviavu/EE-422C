package assignment2;

/*
 * EE422C Project 2 (Mastermind) submission by Sylvia Vu
 * Replace <...> with your actual data. 
 * Name: Sylvia Vu
 * UT EID: sav987
 * Slip days used: <1>
 * Spring 2020
 */


/**
 * Class responsibilities:
 * Checks validity of the user's guess (valid color, valid length, valid case)
 * @author sylviavu
 *
 */
public class GuessInfo {
	
	int codeSize = GameConfiguration.pegNumber;
	String[] validColors = GameConfiguration.colors;
	int numGuesses;
	String userGuess;
	
	
	/**
	 * constructor for guessInfo
	 */
	public GuessInfo(String guess) {
		
		this.userGuess = guess;
	}
	
	/**
	 * checks the validity of a guess:
	 * checks if user requests to see HISTORY
	 * ensures that user guess is the correct length (same as peg number)
	 * checks if user input is all uppercase
	 * 
	 * IF THE PROGRAM RETURNS:
	 * 1 = VALID GUESS
	 * 0 = user requested HISTORY
	 * -1 = INVALID GUESS
	 */
	public int isGuessValid() {
		
		String guessStr;
		char c;
		
		// check for history request
		if(userGuess.equals("HISTORY")) {
			return 0;
		}
		
		// check length
		else if(userGuess.length() != codeSize) {
			return -1;
		}
		
		
		// check for color validity and implement case-sensitivity
		for(int i=0; i<userGuess.length(); i++) {
			c = userGuess.charAt(i);
			guessStr = Character.toString(c);
			
			if(Character.isLowerCase(c)) {
				return -1;
			}
			
			if(isColorValid(guessStr) == -1)
				return -1;
		}
		
		return 1;
	}
	
	/** 
	 * checks if input color is acceptable 
	 * VALID INPUT COLORS: B G O P R Y
	 */
	public int isColorValid(String guessChar) {
		
		for(int i=0; i<validColors.length; i++) {
			if(guessChar.equals(validColors[i])) {
				return 1;
			}
		}
		
		return -1;
	}
		

}
