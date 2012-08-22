/*
   Java 1      	   Basic Mortgage calculator
   Programmer:	   Mike Brown
   Date:		   April 14, 2009
   Program Name:   Mortgage.java
   Version:		   3.0
   Purpose:		   Calculate Monthly payments
*/

//import statements import basic input capability
import java.io.*;

public class Mortgage
{

	public static void main(String[] args)throws IOException
	{
		//declare variables
		String totalLoan, percentInterest,numYears;
		double loanAmount,annualInterestRate,monthlyInterestRate;
		int term,numMonths;

		//constructor for user input reader
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

		//call introduction method
		introduction();

		// print prompts and get input
		System.out.print("\t\tPlease enter the total loan amount: ");
			totalLoan = dataIn.readLine();
			loanAmount = Double.parseDouble(totalLoan);

		System.out.print("\t\tPlease enter the interest rate in percent: ");
			percentInterest = dataIn.readLine();
			annualInterestRate = Double.parseDouble(percentInterest);

		System.out.print("\t\tPlease Enter the term of the loan in years: ");
			numYears = dataIn.readLine();
			term = Integer.parseInt(numYears);

		System.out.println();

		//call getNumberOfMonths method
		numMonths = getNumberOfMonths(term);

		//call getMonthlyInterestRate method
		monthlyInterestRate = getMonthlyInterestRate(annualInterestRate);

		//call createTable Method
		createTable(loanAmount,monthlyInterestRate,numMonths);

	}//end main

	/**		introduction method
	 * 		This method takes no parameters
	 * 		This method returns nothing
	 * 		This method is used to create an introduction screen (splash)
	 * 		It is it's own method so that it can be easy to change in later weeks when
	 * 		it is no longer a "basic mortgage calculator, and so I can easily keep track of the
	 * 		version number
	 */

		public static void introduction()
		{
			System.out.println("\t\t   Basic Mortgage Calculator v3.0");
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
		 }//end getNumberOfMonths

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
		 * This method creates and prints the amortization table for a loan using the parameters specified by the user.
		 * @param loanAmount
		 * @param monthlyInterestRate
		 * @param numMonths
		 */

		public static void createTable(double loanAmount,double monthlyInterestRate,int numMonths)throws IOException
		{
			//initialize and declare local variables
			String checkForEnter;
			double monthlyPayments,monthlyInterest,principalPayment;
			double startingBalance = loanAmount;
			double currentBalance = startingBalance;
			int paymentNumber = 1;

			BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));


			while(startingBalance > 0.00)
			{
				monthlyPayments = payEachMonth(monthlyInterestRate,loanAmount,numMonths);
				monthlyInterest = getMonthlyInterest(currentBalance,monthlyInterestRate);
				principalPayment = getPrincipalPaid(monthlyPayments,monthlyInterest);
				currentBalance = getCurrentBalance(principalPayment,startingBalance);
				System.out.println("Payment number  Starting Balance   Principal    Interest    Ending Balance");
				System.out.printf( "      %d            %.2f        %.2f       %.2f           %.2f  ",paymentNumber,startingBalance,principalPayment,monthlyInterest,currentBalance);
				System.out.println();
				paymentNumber++;
				startingBalance = currentBalance;
					if (paymentNumber % 10 == 0)
					{
						System.out.println();
						System.out.println("Please Press Enter to continue:");
						checkForEnter = dataIn.readLine();
						System.out.println();
					}//end if

			}//end while

		}//end createTable

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

		}//end payEachMonth

		 /**
		  * This method takes the monthly interest rate and multiplies it by the loanAmount and creates the monthly interest
		  * @param totalLoan
		  * @param monthlyInterestRate
		  * @return monthlyInterest
		  */

		private static double getMonthlyInterest(double totalLoan, double monthlyInterestRate)
		{
			double monthlyInterest = (totalLoan * monthlyInterestRate);
			return monthlyInterest;

		}//end getMonthlyInterest

		/**
		 * This method determines the amount that is paid to the principal each month by taking the total
		 * payment and subtracting the amount of interest.
		 * @param monthlyPayment
		 * @param monthlyInterest
		 * @return principalPayment
		 */

		private static double getPrincipalPaid(double monthlyPayment, double monthlyInterest)
		{
			double principalPayment = (monthlyPayment - monthlyInterest);
			return principalPayment;
		}//end getPrincipalPayment

		/**
		 * This method takes the starting balance and subtracts the principal paid for that month.
		 * Then returns the remaining balance as the currentBalance.
		 * @param principalPayment
		 * @param startingBalance
		 * @return currentBalance
		 */

		private static double getCurrentBalance(double principalPayment, double startingBalance)
		{
			double currentBalance = (startingBalance - principalPayment);
			return currentBalance;
		}//end getCurrentBalance

}//end class






