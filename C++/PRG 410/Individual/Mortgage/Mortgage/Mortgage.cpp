/*
   C++ 1      	   Basic Mortgage calculator
   Programmer:	   Mike Brown
   Date:		   August 24, 2009
   Program Name:   Mortgage.cpp
   Version:		   Version 1.0
   Purpose:		   Calculate Monthly payments
*/

#include <iostream>
#include <math.h>
using std::cout;
using std::endl;

//function Prototypes
double getTermInMonths(double termInYears);
double getMonthlyInterestRate(double interestRate);
double getMonthlyPayment(double monthlyInterestRate,double totalLoan,double termInYears);
double getTotalLoanPayment(double termInMonths,double monthlyPayment);

int main(void)
{
	//declare variables
	double totalLoan = 200000.00;
	double termInYears = 30.00;
	double interestRate = 5.75;

	//convert the variables for calculation
	double termInMonths = getTermInMonths(termInYears);
	double monthlyInterestRate = getMonthlyInterestRate(interestRate);
	double monthlyPayment = getMonthlyPayment(monthlyInterestRate,totalLoan,termInYears);
	double totalLoanPayment = getTotalLoanPayment(termInMonths,monthlyPayment);

	//create output
	cout << "Mortgage Calculator Version 1.0"<< endl;
	cout << "Loan Amount| Rate | Term |Monthly Payment|Total Payments"<<endl;
	cout << totalLoan <<"     | " << interestRate << " |  " << termInYears << "  |    " << monthlyPayment
		<< "    |" <<totalLoanPayment << endl;
	system("pause.exe");
	return 0;

	


}//end main

	/* This method takes the number of years and multiplies it by 12
	* to create the number of months in the term of the loan
	*/

	double getTermInMonths(double termInYears){
		double termInMonths = (termInYears * 12);
		return termInMonths;
	}//end getTermInMonths

	/* This method takes the yearly interest rate and converts it to
	* the monthly interest rate by dividing it by the number of periods on a year (12, 1 for each month)           * multiplied by 100 (for percentage).
	*/
	double getMonthlyInterestRate(double interestRate){
		double monthlyInterestRate = (interestRate / 1200);
		return monthlyInterestRate;
	}//end getMonthlyInterestRate


	/*
	 * This method uses the formula: M = P * ( J / (1 - (1 + J) ** -N))
	 * where M is the monthlyPayment, P is the totalLoan, J is the monthlyInterestRate,
	 * and N is the termInMonths. The formula should then result in
	 * returning the total monthly payment. retrieved from: http://www.hughchou.org/calc/formula.html
	 * @TODO For some reason, if I use termInMonths in the function call, it doesn't work. It takes in              * termInYears. I can not figure this out!
	 */
	double getMonthlyPayment(double monthlyInterestRate,double totalLoan,double termInYears){
		double termInMonths = (termInYears * 12);//used instead of using termInMonths as a parameter
		double base = (1 + monthlyInterestRate); //base if the exponential equation
		double exponent = (-1 * termInMonths); //exponent of the equation
		double denominator = pow (base,exponent); //base ** exponent
		double monthlyPayment = totalLoan * (monthlyInterestRate / (1 - denominator));
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

