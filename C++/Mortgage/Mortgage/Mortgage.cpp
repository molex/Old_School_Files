/*
   C++ 1      	   Basic Mortgage calculator
   Programmer:	   Mike Brown
   Date:		   September 7, 2009
   Program Name:   Mortgage.cpp
   Version:		   Version 2.0
   Purpose:		   Calculate Monthly payments
*/

#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;

//function Prototypes
double getTermInMonths(double termInYears);
double getMonthlyInterestRate(double interestRate);
double getMonthlyPayment(double monthlyInterestRate,double totalLoan,double termInYears);
double getTotalLoanPayment(double termInMonths,double monthlyPayment);

int main(void)
{
	//declare variables 
	double totalLoan = 0.00;
	double termInYears = 0.00;
	double interestRate = 0.00;
	bool keepGoing = true;

	//get user input

	cout << "Mortgage Calculator Version 2.0"<< endl;
	while (keepGoing){
	cout << "Please enter a loan amount, or to end enter -1: " << endl;
	cin >> totalLoan;
	cin.clear(); 
	cin.ignore(256, '\n');
	if (totalLoan == 0 || totalLoan < -1){
		cout << "Please enter a positive numeric value!"<<endl;
		cout<<endl;
		continue;
	}
	else if (totalLoan == -1){
     keepGoing = false;
	 break;
    }
    
	
	cout << "Please enter the term in years: " <<endl;
	cin >> termInYears;
	cin.clear(); 
	cin.ignore(256, '\n');
	cout << "Please enter the interest rate: " <<endl;
	cin >> interestRate;
	cin.clear(); 
	cin.ignore(256, '\n');

	//convert the variables for calculation 
	double termInMonths = getTermInMonths(termInYears);
	double monthlyInterestRate = getMonthlyInterestRate(interestRate);
	double monthlyPayment = getMonthlyPayment(monthlyInterestRate,totalLoan,termInYears);
	double totalLoanPayment = getTotalLoanPayment(termInMonths,monthlyPayment);
	
	
	cout << "Loan Amount| Rate | Term |Monthly Payment|Total Payments"<<endl;
	cout << setiosflags(ios::fixed) << setprecision(2)<<totalLoan <<"     | " << interestRate << " |  " << termInYears << "  |    " << monthlyPayment
		<< "    |"  << totalLoanPayment << endl;
	}

}

	/* This method takes the number of years and multiplies it by 12 
	* to create the number of months in the term of the loan
	*/

	double getTermInMonths(double termInYears){
		double termInMonths = (termInYears * 12);
		return termInMonths;
	}

	/* This method takes the yearly interest rate and converts it to
	* the monthly interest rate by dividing it by the number of periods on a year (12, 1 for each month)   
    * multiplied by 100 (for percentage).
	*/
	double getMonthlyInterestRate(double interestRate){
		double monthlyInterestRate = (interestRate / 1200);
		return monthlyInterestRate;
	}

	
	/*
	 * This method uses the formula: M = P * ( J / (1 - (1 + J) ** -N))
	 * where M is the monthlyPayment, P is the totalLoan, J is the monthlyInterestRate,
	 * and N is the termInMonths. The formula should then result in
	 * returning the total monthly payment. retrieved from: http://www.hughchou.org/calc/formula.html
	 */
	double getMonthlyPayment(double monthlyInterestRate,double totalLoan,double termInYears){
		double termInMonths = (termInYears * 12);//used instead of using termInMonths as a parameter
		double base = (1 + monthlyInterestRate); //base if the exponential equation
		double exponent = (-1 * termInMonths); //exponent of the equation
		double denominator = pow (base,exponent); //base ** exponent
		double monthlyPayment = totalLoan * (monthlyInterestRate / (1 - denominator));
		return monthlyPayment;
	}


	/*
	 * This method multiplies the terminMonths by the monthlyPayment to determine the total
	 * paid on the loan.
	*/

	double getTotalLoanPayment(double termInMonths, double monthlyPayment){
		double totalLoanPayment = (termInMonths * monthlyPayment);
		return totalLoanPayment;
	}
