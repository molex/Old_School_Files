/*
   Java 1      	   Basic Mortgage calculator
   Programmer:	   Mike Brown
   Date:		   March 31, 2009
   Program Name:   Mortgage.java
   Version:		   Version 1.1
   Purpose:		   Calculate Monthly payments
*/

/* New in this version:
 * Added version number to the header
 * Changed some odd spacing with the
 * Comments and made sure everything
 * was evenly indented.
*/


//import statements import basic input capability
import java.io.*;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.Locale;

public class Mortgage
{

	public static void main(String[] args)throws IOException
	{
		//declare variables
		String totalLoan, percentInterest,numYears;
		double loanAmount,annualInterestRate,monthlyInterestRate,monthlyPayments;
		int term,numMonths;

		NumberFormat df1 = NumberFormat.getInstance();
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

		//call introduction method
		introduction();

		// print prompts and get input
		totalLoan = JOptionPane.showInputDialog(null,"Please enter the total loan amount: ");
			loanAmount = Double.parseDouble(totalLoan);

		percentInterest = JOptionPane.showInputDialog (null,"Please enter the interest rate in percent: ");
			annualInterestRate = Double.parseDouble(percentInterest);

		numYears = JOptionPane.showInputDialog(null,"Please Enter the term of the loan in years: ");
			term = Integer.parseInt(numYears);

		//call getNumberOfMonths method
		numMonths = getNumberOfMonths(term);

		//call getMonthlyInterestRate method
		monthlyInterestRate = getMonthlyInterestRate(annualInterestRate);

	    //call payEachMonth method to get monthly payment amount
		monthlyPayments = payEachMonth(monthlyInterestRate,loanAmount,numMonths);

		//print results
		monthlyPayments = df1.parse(monthlyPayments);
		JOptionPane.showMessageDialog(null,"Your total monthly payments are:$ "  + monthlyPayments);
		System.exit(0);

	}//end main

		/**
		 *		introduction method
		 * 		This method takes no parameters
		 * 		This method returns nothing
		 * 		This method is used to create an introduction screen (splash)
		 * 		It is it's own method so that it can be easy to change in later weeks when
		 * 		it is no longer a "basic mortgage calculator, and so I can easily keep track of the
		 * 		version number
		 */

		public static void introduction()
		{
			System.out.println("\t\t    Basic Mortgage Calculator v2.0");
			System.out.println();
		}//end Introduction

		/**
		 * This method takes the term in years and makes it the term in months
		 * @param numberOfYears
		 * @return numberOfMonths
		 */

		 private static int getNumberOfMonths(int numberOfYears)
		 {
		 	int numberOfMonths = (numberOfYears * 12);
		 	return numberOfMonths;

		 }//End getNumberOfMonths

		 /**
		  * This method takes the annual interest rate and generates the monthly interest rate
		  * @param yearlyInterest
		  * @return monthlyInterest
		 */

		 private static double getMonthlyInterestRate(double yearlyInterestRate)
		 {
			 double monthlyInterestRate = (yearlyInterestRate / (12 * 100));
			 return monthlyInterestRate;

		 }//end getMonthlyInterestRate



		/**
		 * This method uses the formula: M = P * ( J / (1 - (1 + J) ** -N))
		 * where M is the monthlyPayment, P is the totalLoan, J is the monthlyInterestRate,
		 * and N is the NumMonths. The formula should then result in
		 * returning the total monthly payment.
		 * @param monthlyInterstAmount
		 * @param totalLoanAmount
		 * @param lengthOfLoan
		 * @return payPerMonth
		 */

			private static double payEachMonth(double monthlyInterestAmount,double totalLoanAmount,int lengthOfLoan)
			{
				double payPerMonth = totalLoanAmount * ( monthlyInterestAmount / (1 - Math.pow(1 + monthlyInterestAmount, (-lengthOfLoan))));
				return payPerMonth;

			}//endpayEachMonth

}//end class Mortgage

