/*
   C++ 1      	   Basic Mortgage calculator
   Programmer:	   Mike Brown
   E-Mail:         Molex333@gmail.com
   Date:		   September 12, 2009
   Program Name:   Mortgage.cpp
   Version:		   Version 4.0
   Purpose:		   Calculate Monthly payments
*/

#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;

//function Prototypes
        void introduction()
		{
			cout << "Basic Mortgage Calculator v4.0" << endl;
			cout << endl;
		}

		
		 int getNumberOfMonths(int numberOfYears)
		 {
		 	int numberOfMonths = (numberOfYears * 12);
		 	return numberOfMonths;
		 }

		 /**
		  * This method takes the annual interest rate and generates the monthly interest rate
		  */

		 double getMonthlyInterestRate(double yearlyInterestRate)
		 {
			 double monthlyInterestRate = (yearlyInterestRate / (12 * 100));
			 return monthlyInterestRate;
		 }

		/**
		 * This method uses the formula: M = P * ( J / (1 - (1 + J) ** -N))
		 * where M is the monthlyPayment, P is the totalLoan, J is the monthlyInterestRate,
		 * and N is the NumMonths. The formula should then result in
		 * returning the total monthly payment.
		 */

		double payEachMonth(double monthlyInterestAmount,double totalLoanAmount,int lengthOfLoan)
		{
		    double base = (1 + monthlyInterestAmount); //base if the exponential equation
            int exponent = (-1 * lengthOfLoan); //exponent of the equation
		    double denominator = pow (base,exponent); //base ** exponent
			double payPerMonth = totalLoanAmount * (monthlyInterestAmount / (1 - denominator));
			return payPerMonth;
			

		}

		 /**
		  * This method takes the monthly interest rate and multiplies it by the loanAmount and creates the monthly interest
		  */

		double getMonthlyInterest(double totalLoan, double monthlyInterestRate)
		{
			double monthlyInterest = (totalLoan * monthlyInterestRate);
			return monthlyInterest;

		}

		/**
		 * This method determines the amount that is paid to the principal each month by taking the total
		 * payment and subtracting the amount of interest.
		 */

		double getPrincipalPaid(double monthlyPayment, double monthlyInterest)
		{
			double principalPayment = (monthlyPayment - monthlyInterest);
			return principalPayment;
		}

		/**
		 * This method takes the starting balance and subtracts the principal paid for that month.
		 * Then returns the remaining balance as the currentBalance.
		 */

		double getCurrentBalance(double principalPayment, double startingBalance)
		{
			double currentBalance = (startingBalance - principalPayment);
			return currentBalance;
		}

		void createTable(double loanAmount,double monthlyInterestRate,int numMonths)
		{
			//initialize and declare local variables
			double monthlyPayments,monthlyInterest,principalPayment;
			double startingBalance = loanAmount;
			double currentBalance = startingBalance;
			int paymentNumber = 1;

			cout << "Payment number | Starting Balance  | Principal  |  Interest  |  Ending Balance" << endl;
			while(paymentNumber <= numMonths)
			{
				monthlyPayments = payEachMonth(monthlyInterestRate,loanAmount,numMonths);
				monthlyInterest = getMonthlyInterest(currentBalance,monthlyInterestRate);
				principalPayment = getPrincipalPaid(monthlyPayments,monthlyInterest);
				currentBalance = getCurrentBalance(principalPayment,startingBalance);
				cout <<  setiosflags(ios::fixed) << setprecision(2) << "      " << paymentNumber <<"          " << startingBalance <<"             "<< principalPayment << "        " <<monthlyInterest<<"          " << currentBalance << endl;
				cout << endl;;
				paymentNumber++;
				
					if (paymentNumber % 10 == 0)
					{
                         system("pause");
					     cout << "Payment number | Starting Balance  | Principal  |  Interest  |  Ending Balance" << endl;
						 cout << endl;
					}

					startingBalance = currentBalance;
			}

		}
		
		bool keepGoing()
		{
		  cout << "To Calculate another Mortgage Please press y:";
		  char yesOrNo = 'N';
		  cin >> yesOrNo;
		  cin.clear(); 
		  cin.ignore(256, '\n'); 
		      if(yesOrNo =='Y'|| yesOrNo =='y'){
    		      return true;
		      }
		      else
		        return false;
              
        }

	int main(void)
{
		//declare variables
		double loanAmount,annualInterestRate;
		int term;
		
	
		
		introduction();
		do{

		// print prompts and get input
		
  cout <<"Please enter the total loan amount: " <<endl;
  cin >>loanAmount;
  cin.clear(); 
  cin.ignore(256, '\n');
			if (loanAmount <= 0 ){
					cout << "Please enter a positive numeric value!"<<endl;
					cout<<endl;
					break;
			}
			
		

		
  cout << "Please enter the interest rate in percent: " <<endl;
		cin >> annualInterestRate;
		cin.clear(); 
		cin.ignore(256, '\n');	

		cout << "Please Enter the term of the loan in years: " <<endl;
		cin >> term;
		cin.clear(); 
		cin.ignore(256, '\n');
		cout << endl;
		
		//create variables for passing to the payment table
		int numMonths = getNumberOfMonths(term);
		double monthlyInterestRate = getMonthlyInterestRate(annualInterestRate);

		//Display Payment Table
		createTable(loanAmount,monthlyInterestRate,numMonths);
		}while(keepGoing() == true);
	}//end main
