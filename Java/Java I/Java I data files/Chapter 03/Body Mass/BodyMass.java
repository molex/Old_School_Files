/*
   Chapter 3       Body Mass Assignment
   Programmer:	   Mike Brown
   Date:		   March 26, 2009
   Program Name:   BodyMass.java
   Purpose:		   Calculate the BMI of Sun Fitnesses Customers
*/
import java.io.*;

public class BodyMass{
	public static void main(String[]args) throws IOException{
		String height, weight;
		int inches, pounds;
		double kilograms, meters, index;
		BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));
		// print prompts and get input
		System.out.println("\t       The Sun Fitness Center Body Mass Index Calculator");
		System.out.println();
		System.out.print("\t\tPlease enter your height to the nearest inch: ");
			height = dataIn.readLine();
			inches = Integer.parseInt(height);
		System.out.print("\t\tEnter your weight to the nearest pound: ");
			weight = dataIn.readLine();
			pounds = Integer.parseInt(weight);
		// calculations
		meters = (inches / 39.36);
		kilograms = (pounds / 2.2);
		index = (kilograms / Math.pow(meters,2));
		// output
		System.out.println();
		System.out.println("\t\tYour BMI is: " + Math.round(index) + ".");
		System.out.println();
	}
}

