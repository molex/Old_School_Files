/*
	Chapter 5:	Programming Assignment 4
	Programmer:	Mike Brown
	Date:		March 30, 2009
	Filename:	Rooms.java
	Purpose:	This is an external class called by the Reservations.java program.
				It's constructor method recieves the number of nonsmoking and smoking rooms
				and then creates an array of empty rooms. The bookRoom() method accepts a
				boolean value and returns a room number.
*/

public class Rooms
{
	//declare class variables
	int numSmoking;
	int numNonSmoking;
	boolean occupied[];

	public Rooms (int non, int sm)
	{
		//construct an array of boolean values equal to the total number of rooms
		occupied = new boolean[sm + non];
		for(int i=0; i<(sm+non); i++)
			occupied[i] = false; //set each occupied room to false ot empty
		//initialize the number of smoking and non smoking rooms
		numSmoking = sm;
		numNonSmoking = non;
	}

	public int bookRoom(boolean smoking)
	{
		int begin, end, roomNumber = 0;

		if (!smoking)
		{
			begin = 0;
			end = numNonSmoking;
		}
		else
		{
			begin = numNonSmoking;
			end = numSmoking + numNonSmoking;
		}

		for(int i=begin; i<end; ++i)
		{
			if(!occupied[i]) //if room is not occupied
			{
				occupied[i] = true;
				roomNumber = i + 1;
				i = end;//to exit loop
			}
		}
		return roomNumber;
	}
}
