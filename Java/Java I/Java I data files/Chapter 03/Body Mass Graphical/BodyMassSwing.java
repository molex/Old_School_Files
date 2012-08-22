/*
   Chapter 3       Body Mass Assignment
   Programmer:	   Mike Brown
   Date:		   March 26, 2009
   Program Name:   BodyMassSwing.java
   Purpose:		   Calculate the BMI of Sun Fitnesses Customers

*/


import javax.swing.JOptionPane;

public class BodyMassSwing
{
	public static void main(String[]args)
	{
		//declare and construct variables
		String height, weight;
		int inches, pounds;
		double kilograms, meters, index;

		// print prompts and get input
		System.out.println("\t       The Sun Fitness Center Body Mass Index Calculator");
			height = JOptionPane.showInputDialog(null, "Enter your height to the nearest inch: ");
			inches = Integer.parseInt(height);
		weight= JOptionPane.showInputDialog(null, "Enter your weight to the nearest pound: ");
			pounds = Integer.parseInt(weight);

		// calculations
		meters = (inches / 39.36);
		kilograms = (pounds / 2.2);
		index = (kilograms / Math.pow(meters,2));

		// output
		JOptionPane.showMessageDialog(null, "Your BMI is: " + Math.round(index) + ".", "Body Mass Index Calculator", JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0);

	}
}

