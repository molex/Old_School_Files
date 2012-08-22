/******************************************************************************************************
   Programmer:	   Andrae Johnson
   Date:		   September 4, 2009
   Program Name:   mortgagecalculater.cpp
   Purpose:		   Calculates and display the monthly payment for a given mortgage
*******************************************************************************************************/

#include <iostream>
#include <math.h>//called for the power function
using namespace std;
//using std::cout;
//using std::endl;


double calc( double dloan, double drate, int iTerm);//calc function declaration.
int main()
{
	double loan;//Loan amount intialized and given a value
	double rate;//rate amount inialized and given a value
	double loan_balance;
	int term; //Term value declared and given a value
	int i;//coutner
	double monthlypayment = 0;
	int choice = 1;//User's

	do
	{
		//Gets the input from the user.
		cout << "Please enter the loan amount";
		cin >> loan;
		cout << "\nPlease enter the rate amount";
		cin >> rate;
		cout << "\nPlease enter the term amount";
		cin >> term;
//		Converts the following values		
		rate = ( rate / 12 ) / 100;
		term = term * 12;
		cout << endl;
		cout << "The montly payment is $" 
		 << calc(loan, rate, term);//Outputs the monthly payment and calls the calc() function for the onthly payments
		cout << endl;

		loan_balance = loan;//Outputs the information to the screen
			for (i = 1; i < ( term - 1 ); i++)
			{
				loan_balance = loan_balance - calc(loan, rate, term);
				cout << "\n For month #" << i << " Monthly Bal "<< loan_balance
					<< " Monthly Int " << loan_balance * rate;			
			}

		//Promps the use to decide if they would like to continue or exit.
		cout << "\nWould you like to continue or exit"
			 << "1: To Continue"
			 << "0: to Exit";
		cin >> choice;
	}while ( choice != 0);
	
	return 0; // Exit the program
}

double calc( double dloan, double drate, int iTerm)//This function calculates and return the monthly payment.
{
	return dloan * ( drate / (1 - pow( (1 + drate), - iTerm  ) ) );//returns the results to the main function
}

