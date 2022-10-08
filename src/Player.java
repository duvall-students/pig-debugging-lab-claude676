/**
 * CSC3465(Software Design) - Debugging Lab 
 * --> "Practicing Debugging with Pig!"
 * 
 * @revised by Xu Yan (Brandon)
 *
 */

public abstract class Player {

	protected String myName;
	protected int myScore;
	private final int WIN_SCORE = 100;
	
	public Player(String myName){
		myScore = 0;
	}
	
	// Each player must provide logic for deciding to roll again
	public abstract boolean rollAgain(int totalSoFar);
	
	public String toString(){
		return myName+": "+myScore;
	}
	
	public boolean hasWon(){
		return myScore >= WIN_SCORE;
	}
	
	public void resetScore(){
		myScore = 0;
	}
	
	public void addToScore(int thisRound){
		myScore += thisRound;
	}
	
	public String getName(){
		return myName;
	}
	
	// add new code; use this method to get the score
	public int getScore(){
		return myScore;
	}
}
