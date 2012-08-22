/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part
	public void run(){
		fixColumn();
		while(frontIsClear()){
			findColumn();
		}
		
	}
	private void fixColumn(){
		turnLeft();
		while(frontIsClear()){
			makeRepairs();
		}
			
		if(beepersPresent()){
			turnAround();
			returnToBottom();
		}
		else{
			putBeeper();
			turnAround();
			returnToBottom();
		}
	}
	private void makeRepairs(){
		if(beepersPresent()){
			move();
		}
		else{ 
			putBeeper();
			move();
		}
		
			
			
	}
	private void returnToBottom(){
			while(frontIsClear()){
				move();
			}
			turnLeft();
	}
	private void findColumn(){
		for(int i=0; i<4;i++){
			move();
		}
		fixColumn();
	}
		
		

}
