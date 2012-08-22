/*
   C++ 1      	   Basic Mortgage calculator
   Programmer:	   Mike Brown
   Date:		   August 24, 2009
   Program Name:   Mortgage.cpp
   Version:		   Version 1.0
   Purpose:		   Calculate Monthly payments
*/

#include <iostream>
using std::cout;
using std::endl;

//function Prototypes
double getTermInMonths(double termInYears);
double getMonthlyInterestRate(double interestRate);
double getMonthlyPayment(double monthlyInterestRate,double totalLoan,double termInYears);
double getTotalLoanPayment(double terminMonths,double monthlyPayment);

int main(void)
{
	//declare variables
	double totalLoan = 200000.00;
	double termInYears = 30;
	double interestRate = 5.75;

	//convert the variables for calculation 
	double termInMonths = getTermInMonths(termInYears);
	double monthlyInterstRate = getMonthlyInterestRate(interestRate);
	double; monthlyPayment = getMonthlyPayment(monthlyInterestRate,totalLoan,termInYears);
	double totalLoanPayment = getTotalLoanPayment(terminMonths,monthlyPayment);


	/* This method takes the number of years and multiplies it by 12 
	* to create the number of months in the term of the loan
	*/

	double getTermInMonths(double termInYears){
		double termInMonths = (termInYears * 12);
		return termInMonths;
	}//end getTermInMonths

	/* This method takes the yearly interest rate and converts it to
	* the monthly interest rate.
	*/
	double getMonthlyInterestRate(double interestRate){
		double monthlyInterestRate = (interestRate / (12 * 100));
		return monthlyInterestRate;
	}//end getMonthlyInterestRate

	
	/*
	 * This method uses the formula: M = P * ( J / (1 - (1 + J) ** -N))
	 * where M is the monthlyPayment, P is the totalLoan, J is the monthlyInterestRate,
	 * and N is the termInMonths. The formula should then result in
	 * returning the total monthly payment.
	 */
	double getMonthlyPayment(double monthlyInterestRate,double totalLoan,double termInMonths){
		double monthlyPayment = totalLoan * (monthlyInterestRate / (1 -Math.pow(1 + monthlyInterestRate, (-termInMonths))));
		return monthlyPayment;
	}//end getMonthlyPayment


	/*
	 * This method multiplies the terminMonths by the monthlyPayment to determine the total
	 * paid on the loan.
	*/

	double getTotalLoanPayment(double termInMonths, double monthlyPayment){
		double totalLoanPayment = (termInMonths * monthlyPayment);
		return totalLoanPayment;
	}//end getTotalLoanPayment

}//end main