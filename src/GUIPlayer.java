/**
 * CSC3465(Software Design) - Debugging Lab 
 * --> "Practicing Debugging with Pig!"
 * 
 * @revised by Xu Yan (Brandon)
 *
 */

import java.util.Scanner;

public class GUIPlayer extends Player {
	private Scanner scanner;
	
	public GUIPlayer(){
		super("Human");
		System.out.println("Hello Player!  Please enter your name.");
		scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		myName = name;
	}

	@Override
	public boolean rollAgain(int totalSoFar) {
		System.out.println("Score is "+myScore+ " Round score is "+totalSoFar);
		/* 
		 * add new code; use if statement to stop the game when the score of the Human player (player1) 
		 * achieves or exceeds the wining score (100)
		 * */
		if (isHumanPlayerScoreReachWin(totalSoFar)) {
			return false;
		}
		System.out.println("Do you want to roll again? Y/N");
		String answer = scanner.nextLine();
		return answer.toUpperCase().charAt(0) == 'Y';
	}
	
	
	/* 
	 * associated new created method
	 * 
	 * for [ add new code; use if statement to stop the game when the score of the Human player (player1) 
	 * achieves or exceeds the wining score (100) ]
	 * */
	private boolean isHumanPlayerScoreReachWin(int totalSoFar) {
		return (myScore + totalSoFar)>=100;
	}
}
