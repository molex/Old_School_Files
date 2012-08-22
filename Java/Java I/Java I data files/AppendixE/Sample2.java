/*
	App. E:		Sample Program
	Programmer:	J. Starks
	Date:		October 4, 2007
	Filename:	Sample2.java
	Purpose:	This program displays simple input and output methods
*/

import java.io.*;

public class Sample2
{
	public static void main(String[] args) throws IOException
	{
		//declare variables and constructors
		String name;
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

		//get user name
		System.out.println();
		System.out.print("\t\tPlease enter your name: ");
		name = dataIn.readLine();

		//display output
		System.out.println();
		System.out.println("\t" + name + ", You have successfully compiled and run the Sample2 application.");
		System.out.println();
	}
}