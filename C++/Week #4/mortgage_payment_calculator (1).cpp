// mortgage_payment_calculator.cpp : Defines the entry point for the console application.
/**
 * Week 3 Assignment #1: Monthly Mortgage Payment Calculator
 *      Author: Kevin Winn
 *       Email: kwinn2877@yahoo.com
 *        Date: September 14, 2009
 *      Course: C++ Programming I - PRG/410
 *     Version: 3.0
 *     Purpose: To calculate the monthly mortgage payment based on user
 *              inputted loan properties
 * Description: Using the formula retrieved from http://www.hughchou.org/calc/formula.html, 
 *              this program will determine the monthly payment amount required for a
 *              conventional mortgage based on user specifications.
**/

#include <iostream>  //utilize iostream for writing to standard output
#include <iomanip>   //manipulate the output stream to format monetary output
#include <math.h>    //calculate exponents

using namespace std;
/**
 * This function will prompt the user to continue calculating
 * monthly mortgage payments
 * @return true if 'Y' or 'y' is inputted, false otherwise
 */
bool continueMenu()
{
	cout << "Would you like to calcuate a new mortgage? (y/n)";
	char cContinue = 'N';
	cin >> cContinue;
	cin.clear();  //reset error flag if set
	cin.ignore(256, '\n');  //ignore 256 chars or until newline
	if( toupper(cContinue)=='Y' )
		return true;

	return false;
}
/**
 * This function will prompt the user to enter a starting principle
 * amount for a new mortgage calculation.  If a negative or non-numeric
 * character is inputted the user will be re-prompted
 * @return float loan amount
 */
float getLoanAmount()
{
	float fInput = 0;
	do
	{
		cout << "Please enter the numeric mortgage amount: $";
		cin >> fInput;
		cin.clear();  //reset error flag if set
		cin.ignore(256, '\n');  //ignore 256 chars or until newline
	}while( fInput<=0 );  //non-numeric will be zero due to error
	return fInput;
}
/**
 * This function will prompt the user to enter a term in years for a 
 * new mortgage calculation.  If a negative or non-numeric character 
 * is inputted the user will be re-prompted.  Non-Integer inputs
 * will round down to the integer.
 * @return int term in years
 */
int getTermInYears()
{
	int iInput = 0;
	do
	{
		cout << "Please enter the numeric mortgage term (years): ";
		cin >> iInput;
		cin.clear();  //reset error flag if set
		cin.ignore(256, '\n');  //ignore 256 chars or until newline  
	}while( iInput<=0 );  //non-numeric will be zero due to error.  non integer will be rounded down
	return iInput;

}
/**
 * This function will prompt the user to enter an interest rate
 * for a new mortgage calculation.  If a negative or non-numeric
 * character is inputted the user will be re-prompted
 * @return float interest rate
 */
float getInterestRate()
{
	float fInput = 0;
	do
	{
		cout << "Please enter the numeric mortgage interest rate (percent): ";
		cin >> fInput;
		cin.clear();  //reset error flag if set
		cin.ignore(256, '\n');  //ignore 256 chars or until newline
	}while( fInput<=0 );  //non-numeric will be zero due to error
	return fInput;
}
/**
 * This function will calcuate and return the monthly payment based 
 * on the loan specifications passed as parameters.
 * @param float fLoanAmount - principle amount
 * @param int iTermInYears - loan term in years
 * @param float fInterestRate - interest rate as a percentage
 * @return float fMonthlyPayment
 */
float getMonthlyPayment( float fLoanAmount, int iTermInMonths, float fMonthlyInterestRate )
{
	//formula retrieved from http://www.hughchou.org/calc/formula.html
	//use the math pow function to get (monthly_interest + 1) to the -(term_in_months)
	float fFormulaDivisor = 1 - ( pow(fMonthlyInterestRate+1, iTermInMonths*-1) );
	/*********************************************************************************
	 *                                      Monthly Interest                         *
	 * Monthly Payment = -------------------------------------------------------     *                                     
	 *                   1 - ( 1 + Monthly Interest )^(Term Length in Months)*-1     *
	 *********************************************************************************/
	float fMonthlyPayment = fLoanAmount * (fMonthlyInterestRate/fFormulaDivisor);

	return fMonthlyPayment;
}
void displayAmortizationTable( float fLoanAmount, int iTermInYears, float fInterestRate )
{
	float fMonthlyInterestRate = fInterestRate/(1200);  //calculate monthly interest as a decimal
	int iTermInMonths = 12 * iTermInYears;
	//formulas retrieved from http://www.hughchou.org/calc/formula.html
	float fLoanBalance = fLoanAmount;
	float fMonthlyInterest = fLoanAmount * fMonthlyInterestRate;
	float fMonthlyPayment = getMonthlyPayment( fLoanAmount, iTermInMonths, fMonthlyInterestRate );
	for( int i=1; i<=iTermInMonths; i++ )
	{
		fMonthlyInterest = fLoanBalance * fMonthlyInterestRate;
		float fMonthlyPrinciplePaid = fMonthlyPayment - fMonthlyInterest;
		fLoanBalance -= fMonthlyPrinciplePaid;
		if( fLoanBalance<0 )
			fLoanBalance = 0;
		cout << "Month #" << i;
		cout << " - Interest Paid: " << setprecision(2) << fixed << fMonthlyInterest;
		cout << " Remaining Balance: " << fLoanBalance << endl;
		if( i%12==0 )
		{
			cout << "Press <ENTER> to continue.";
			cin.clear();  //reset error flag if set
			cin.ignore(256, '\n');  //ignore 256 chars or until newline
		}
	}
	float fMonthlyPrinciple = fMonthlyPayment - fMonthlyInterest;

	cout << getMonthlyPayment( fLoanAmount, iTermInMonths, fMonthlyInterestRate) << endl;
}
int main(int argc, char* argv[])
{
	//initialize inputs
	float fLoanAmount = 0;
	int iTermInYears = 0;
	float fInterestRate = 0;

	do
	{
		fLoanAmount = getLoanAmount();  //prompt user for principle
		iTermInYears = getTermInYears();  //prompt for term in years
		fInterestRate = getInterestRate();  //prompt for interest rate

		displayAmortizationTable( fLoanAmount, iTermInYears, fInterestRate );  //calculate and display amortization table

	}while( continueMenu()==true );  //prompt user to continue
	
	return 0;
}

