/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel2 extends SuperKarel {

	// You fill in this part
	public void run(){
		createRow();
		while(leftIsClear()){
			if(noBeepersPresent()){
			repositionForRowToWest();
			createRow();
			}
			else{
				repositionForRowToWest();
				createAlternateRow();
			}
			if (rightIsClear()){
				repositionForRowToEast();
				createRow();
			}
			else{
				turnAround();
			}
		}
	}
	private void createRow(){
		putBeeper();
		if(frontIsBlocked()){
			turnLeft();
		}
			
			
		while(frontIsClear()){
			move();
			if(frontIsClear()){
				move();
				putBeeper();
			}
			
		}
	}
	
		
	private void repositionForRowToWest(){
		turnLeft();
		move();
		turnLeft();
	}
	private void repositionForRowToEast(){
		turnRight();
		move();
		turnRight();
	}
	private void createAlternateRow(){
		move();
		putBeeper();
		while(frontIsClear()){
			move();
			if(frontIsClear()){
				move();
				putBeeper();
			}
			
		}
	}
		
}
