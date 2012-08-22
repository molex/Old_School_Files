/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class DanglingChadKarel extends SuperKarel {

	// You fill in this part
	public void run(){
		while(frontIsClear()){
		checkForVote();
		}
		
	}
	private void checkForVote(){
		move();
		while(frontIsClear()){
		
		 if(noBeepersPresent()){
			 cleanChads();
		 }
		 else{
			move();
			move();
			
		 }
		}
		
	}
	private void cleanChads(){
		turnLeft();
		while(frontIsClear()){
			move();
			if(beepersPresent()){
				while(beepersPresent()){
				pickBeeper();
				}
			}
		}
		turnAround();
		while(frontIsClear()){
			move();
			if(beepersPresent()){
				while(beepersPresent()){
				pickBeeper();
				}
			}
		}
		returnToCenter();
	}
	
	private void returnToCenter(){
		turnAround();
		move();
		turnRight();
		if(frontIsClear()){
		move();
			if(frontIsClear()){
				move();
			}
		}
	}
		
	
}
