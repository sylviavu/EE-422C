package assignment2;

/*
 * EE422C Project 2 (Mastermind) submission by Sylvia Vu
 * Replace <...> with your actual data. 
 * Name: Sylvia Vu
 * UT EID: sav987
 * Slip days used: <1>
 * Spring 2020
 */



import java.util.*;

public class History {

	ArrayList<String> history;
	
	/**
	 * default constructor creates a new ArrayList to hold all previous guesses
	 */
	public History() {
		history = new ArrayList<String>();
	}
	
	/**
	 * Called when a user makes a VALID guess
	 * Adds the guess to the history
	 * @param guess = user's input
	 * @param feedback = feedback pegs shown to user
	 */
	public void addToHistory(String guess, String feedback) {
		String historyEntry = guess + " -> " + feedback;		// feedback format ex: RRRR -> 0b_0w
		history.add(historyEntry);						
	}
	
	/**
	 * Called when the user inputs "HISTORY"
	 * Prints list of user's previous guesses + feedback received at the time
	 * 
	 */
	public void historyList() {
		for(int i=0; i<history.size(); i++) {
			System.out.println(history.get(i));
		}
	}
	
	
}
