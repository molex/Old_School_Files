/*
	Chapter 2:	My day app
	Programmer: Michael Brown
	Date:		March 25, 2009
	Filename:	my_Day.java
	Purpose:	This displays the system time, user name , and my day info
*/
import java.util.Date;

public class my_Day
{
	/**
	 * This program is for the purpose of displaying the My Day Application in
	 * either applet form or in the Console form.
	 * This will be used by every user to display thier daily tasks. It will
	 * display the date, the user's name, and the text "Welcome to my day!"
	 */
	public static void main(String[]args)
	{
		Date currentDate = new Date(); //Date constructor
		System.out.println();
		System.out.println("\t\t\tWelcome to my day!");
		System.out.println("\t\t\tDaily planner for Linda Nunez");
		System.out.println("\t\t\t" + currentDate);
		System.out.println();




	}
}