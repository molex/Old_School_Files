/*
   Chapter 3       Body Mass Assignment
   Programmer:	   Mike Brown
   Date:		   March 26, 2009
   Program Name:   BodyMass.java
   Purpose:		   Calculate the BMI of Sun Fitnesses Customers
*/
import java.io.*;
import java.util.Scanner;

public class BodyMassTest{
	public static void main(String[]args) throws IOException{
		int inches, pounds;
		double kilograms, meters, index;
		Scanner sc = new Scanner(System.in);
		// print prompts and get input
		System.out.println("\t       The Sun Fitness Center Body Mass Index Calculator");
		System.out.println();
		System.out.print("\t\tPlease enter your height to the nearest inch: ");
			inches = sc.nextInt();
		System.out.print("\t\tEnter your weight to the nearest pound: ");
			pounds = sc.nextInt();
		meters = (inches / 39.36);
		kilograms = (pounds / 2.2);
		index = (kilograms / meters);
		System.out.println("Your BMI is: " + index);
	}
}

