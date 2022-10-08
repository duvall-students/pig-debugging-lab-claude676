/**
 * CSC3465(Software Design) - Debugging Lab 
 * --> "Practicing Debugging with Pig!"
 * 
 * @revised by Xu Yan (Brandon)
 *
 */

import java.util.Random;

public class Game {
	private Player player1;
	private Player player2;
	private Random die;
	private Spinner spinner;
	private final String LOSER_SPIN = "grunt";
	private final int LOSER_ROLL = 1;
	
	public Game(){
		/* 
		 * [*** Bug Fixes 1. ***]
		 * 
		 * this error is caused by repeatedly (twice) defining the objects "player1" and "player2" since
		 * they are already been declared as the global variable in this class and there is no need to declare
		 * them again as the instance variable inside the Game() constructor
		 * */
//		Player player1 = new GUIPlayer();
//		Player player2 = new ComputerPlayer();
		player1 = new GUIPlayer();
		player2 = new ComputerPlayer();
		die = new Random();
		spinner = new Spinner();
	}
	
	/*
	 * Method will play one game between the players.
	 */
	public void playGame(){
		printStartGameMessage();
		Player whoseTurn = player1;
		while(!winner()){
			int roundScore = takeATurn(whoseTurn);
			whoseTurn.addToScore(roundScore);
			// Switch whose turn it is.
			if(whoseTurn == player1){
				whoseTurn = player2;
			}
			else{
				whoseTurn = player1;
			}
		}
		printEndGameMessage();
	}
	
	/*
	 * One player's turn.  Ends because
	 * - roll a 1
	 * - spin a "GRUNT"
	 * - or Player decides to stop
	 * 
	 * Return the number of points to add to the player
	 */
	public int takeATurn(Player whoseTurn){
		int roundScore = 0;
		boolean keepGoing = true;
		printStartRoundMessage(whoseTurn);
		while(keepGoing){
			/* 
			 * [*** Bug Fixes 3. ***]
			 * 
			 * this error is caused by the .nextInt(n) will return a pseudorandomly chosen int value 
			 * between zero (inclusive) and the bound n (exclusive); therefore, 0 may occur as the result
			 * */
//			int roll = die.nextInt(7);
			int roll = die.nextInt(6) + 1;
			String spin = spinner.spin();
			System.out.println(roll+ " "+ spin);
			
			/* 
			 * [*** Bug Fixes 7. ***]
			 * 
			 * this error is caused by placing the wrong order of each if-else statement;
			 * the priority of the 
			 * */
//			if(roll == LOSER_ROLL){
//				System.out.println("Lose a turn.");
//				return 0;
//			}
//			else if(spin == LOSER_SPIN.toUpperCase()){
//				System.out.println("Too bad!  Lose all your points.");
//				whoseTurn.resetScore();
//				return 0;
//			}			
			/* 
			 * [*** Bug Fixes 6. ***]
			 * 
			 * this error is caused by implementing the wrong approach to compare the value of the 
			 * String type variable; since String is an object, here out to use .equals() function
			 * to compare two values rather than using ==
			 * */
//			if(spin == LOSER_SPIN.toUpperCase()){
			if(spin.equals(LOSER_SPIN.toUpperCase())){
				System.out.println("Too bad!  Lose all your points.");
				whoseTurn.resetScore();
				return 0;
			}
			else if(roll == LOSER_ROLL){
				System.out.println("Lose a turn.");
				return 0;
			}
			else{
				roundScore = roundScore + roll;
				System.out.println("Round total is currently: "+roundScore);
				keepGoing = whoseTurn.rollAgain(roundScore);
			}
		}
		return roundScore;
	}
	
	// True if one of the players has won the game.
	public boolean winner(){
		/* 
		 * [*** Bug Fixes 4. ***]
		 * 
		 * this error is caused by applying the wrong Logical Operators; 
		 * "player1.has Won() && player.has Won()" would be true if and only if both "player1" and "player2" 
		 * won the game, whereas it was impossible to reach "true" under the current game rule
		 * */
//		return player1.hasWon() && player2.hasWon();
		return player1.hasWon() || player2.hasWon();
	}
	
	/* 
	 * These methods are for printing messages to the console to follow the game.
	 */
	public void printStartRoundMessage(Player whoseTurn){
		// add new code; use the format to separate each specific section of output
		System.out.println(".....................................");
		System.out.println("New Round!  "+ whoseTurn.getName()+" 's turn."); 
		System.out.println(player1);
		System.out.println(player2);
	}
	
	public void printEndGameMessage(){
		// add new code; use the format to separate each specific section of output
		System.out.println("-------------------------------------");
		if(player1.hasWon()){
			// add new code; print out the winner's final score
			System.out.println(player1.getName() + "'s score is: " + player1.getScore());
			System.out.println("Winner is "+player1.getName());
		}
		else{
			// add new code; print out the winner's final score
			System.out.println(player2.getName() + "'s score is: " + player2.getScore());
			System.out.println("Winner is "+player2.getName());
		}
	}
	
	public void printStartGameMessage(){
		System.out.println("Let's Play Pig!");
	}
}
