package assignment2;
import java.util.*;

public class Computer {

	static Response lastResponse;
	// other static or non-static variables

	static {
		// static initialization block. Use if required.
	}

	public static void setLastResponse (Response r) {
		lastResponse = r;
	}

	public static void reset () {
		lastResponse = null;
		// other reset tasks, TBD
	}
	
	public static String pickNextGuess () {
		// TBD
		return null;
	}
}
