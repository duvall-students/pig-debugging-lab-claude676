/**
 * CSC3465(Software Design) - Debugging Lab 
 * --> "Practicing Debugging with Pig!"
 * 
 * @revised by Xu Yan (Brandon)
 *
 */

public class ComputerPlayer extends Player{
	private final int MIN_POINTS = 15;
	
	public ComputerPlayer(){
		super("R2D2");
		/* 
		 * [*** Bug Fixes 5. ***]
		 * 
		 * this error is caused by the subclass ComputerPlayer doesn't assign the myName variable,
		 * which is inherited from the super class Player
		 * */
		myName = "R2D2";
	}

	@Override
	/*
	 *Computer will stop rolling if:
	 *	- It doesn't have 15 points yet (or MIN_POINTS)
	 *	- Stopping will win the game.
	 */
	public boolean rollAgain(int totalSoFar) {
		return (myScore + totalSoFar)<100 && totalSoFar < MIN_POINTS;
	}
}
