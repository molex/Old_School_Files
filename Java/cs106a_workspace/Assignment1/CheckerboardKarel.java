/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
	public void run(){
		while(frontIsClear()){
			createRowEast();
			
		}
	}	
	private void createRowEast(){
		putBeeper();
		while(frontIsClear()){
			move();
			if(noBeepersPresent()){
			move();
			putBeeper();
			}
			else{
				moveToNextRowEast();
			}
		}
	}
	private void moveToNextRowEast(){
		turnLeft();
		if(frontIsClear()){
		move();
		turnLeft();
		createRowWest();
		}
	}
	private void createRowWest(){
		putBeeper();
		while(frontIsClear()){
			
			move();
			if(frontIsClear()){
			move();
			putBeeper();
			}
			else{
				moveToNextRowWest();
			}
		}
	}
	private void moveToNextRowWest(){
		turnRight();
		if(frontIsClear()){
		move();
		turnRight();
		createRowEast();
		}
	}
}
