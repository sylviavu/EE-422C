package assignment2;

import java.util.*;
/*
 * EE422C Project 2 (Mastermind) submission by Sylvia Vu
 * Replace <...> with your actual data. 
 * Name: Sylvia Vu
 * UT EID: sav987
 * Slip days used: <1>
 * Spring 2020
 */


public class Feedback {
	
	int black;
	int white;
	String[] user;
	String[] secret;
	boolean used;
	
	String feedback;
	
	/**
	 * Feedback constructor
	 * @param guess = the user's newest guess
	 * @param secCode = codemaker code
	 * 
	 */
	public Feedback(GuessInfo guess, String secCode) {
		
		user = guess.userGuess.split("");
		this.secret = secCode.split("");
		generateFeedback();
		feedback = black + "b_" + white + "w";		// format ex: 0b_1w
		
	}
	
	/**
	 * Compare guess to the secret code
	 * Generate feedback pegs according to game rules
	 * 
	 */
	public void generateFeedback() {
		
		ArrayList<Integer> usedGuess = new ArrayList<Integer>();
		ArrayList<Integer> checkIndex = new ArrayList<Integer>();
		
		// if guess aligns in color AND index with secret code
		for(int i=0; i<user.length; i++) {
			if(user[i].equals(secret[i])) {
				black++;
				usedGuess.add(i);
				checkIndex.add(i);
			}
		}
		
		for(int i=0; i<user.length; i++) {
				
				for(int j=0; j<user.length; j++) {
					
					// check for correct color but incorrect index 
					// (!checkIndex.contains(i)) covers cases involving duplicates
					if(user[i].equals(secret[j]) && !(checkIndex.contains(j)) && !(usedGuess.contains(i))) {
						white++;
						checkIndex.add(j);
						usedGuess.add(i);
				}
			}
		}

	}	
}
	
	
	
	
	


