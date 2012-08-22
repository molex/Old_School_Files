/*
   C++ 2     	   OO Mortgage calculator
   Programmer:	   Mike Brown
   E-Mail:         Molex333@gmail.com
   Date:		   September 29, 2009
   Program Name:   loan.cpp
   Version:		   Version 1.0
   Purpose:		   This is the main file loan.cpp which will get the loan information, calculate the loan, and then display the results
*/

#include "Loan.h"
#include <math.h>
#include <iomanip>
#include <iostream>

using namespace std;

//This is the default constructor for the Loan class. Initializing all values to 0
Loan::Loan() {
	loanAmount = 0.00;
	rate = 0.00;
	term = 0;
}

//This is the constructor for the Loan class taking 3 parameter
Loan::Loan(double loanAmountEntered, double rateEntered, int termEntered){
	loanAmount = loanAmountEntered;
	rate = rateEntered;
	term = termEntered;
}

//Below are the getters for loanAmount, rate,monthlyInterestRate, term, and numMonths
double Loan::getLoanAmount() const {
	return loanAmount;
}

double Loan::getRate() const {
	return rate;
}
double Loan::getMonthlyInterestRate() const{
	return monthlyInterestRate;
}

int Loan::getTerm() const {
	return term;
}
int Loan::getNumMonths() const{
	return numMonths;
}

//below are the setters for the loanAmount, rate, and term
void Loan::setLoanAmount(double loanAmountEntered){
	loanAmount = loanAmountEntered;
}
void Loan::setRate(double RateEntered){
	rate = RateEntered;
}

void Loan::setMonthlyInterestRate(double rate) {
	monthlyInterestRate = (rate / (12*100));
}

void Loan::setTerm(int termEntered){
	term = termEntered;
}
void Loan::setNumMonths(int term){
	numMonths = (term * 12);
}

/**
 * This method uses the formula: M = P * ( J / (1 - (1 + J) ** -N))
 * where M is the monthlyPayment, P is the totalLoan, J is the monthlyInterestRate,
 * and N is the NumMonths. The formula should then result in
 * returning the total monthly payment.
 */

double Loan::payEachMonth(double monthlyInterest,double loanAmount,int numMonths){
	double base = (1 + monthlyInterest); //base if the exponential equation
    int exponent = (-1 * numMonths); //exponent of the equation
    double denominator = pow (base,exponent); //base ** exponent
	double payPerMonth = loanAmount * (monthlyInterest / (1 - denominator));
    return payPerMonth;
}
/**
 * This method takes the monthly interest rate and multiplies it by the loanAmount and creates the monthly interest
 */

double Loan::getMonthlyInterest(double totalLoan, double monthlyInterestRate){
	double monthlyInterest = (totalLoan * monthlyInterestRate);
	return monthlyInterest;
}

/**
 * This method determines the amount that is paid to the principal each month by taking the total
 * payment and subtracting the amount of interest.
 */

double Loan::getPrincipalPaid(double monthlyPayment, double monthlyInterest){
	double principalPayment = (monthlyPayment - monthlyInterest);
	return principalPayment;
}

/**
 * This method takes the starting balance and subtracts the principal paid for that month.
 * Then returns the remaining balance as the currentBalance.
 */

double Loan::getCurrentBalance(double principalPayment, double startingBalance){
	double currentBalance = (startingBalance - principalPayment);
	return currentBalance;
}


//This method displays the end result of the calculations
void Loan::display(double loanAmount,double monthlyInterest,int numMonths) {
	//initialize and declare local variables
	double monthlyPayments,principalPayment;
	double startingBalance = loanAmount;
	double currentBalance = startingBalance;
	int paymentNumber = 1;

	cout << "Payment number | Starting Balance  | Principal  |  Interest  |  Ending Balance" << endl;
	while(paymentNumber <= numMonths){
	    monthlyPayments = payEachMonth(monthlyInterestRate,loanAmount,numMonths);
		monthlyInterest = getMonthlyInterest(currentBalance,monthlyInterestRate);
		principalPayment = getPrincipalPaid(monthlyPayments,monthlyInterest);
		currentBalance = getCurrentBalance(principalPayment,startingBalance);
		cout <<  setiosflags(ios::fixed) << setprecision(2) << "      " << paymentNumber <<"          " << startingBalance <<"             "<< principalPayment << "        " <<monthlyInterest<<"          " << currentBalance << endl;
		cout << endl;;
		paymentNumber++;
				
		if (paymentNumber % 10 == 0){
            system("pause");
		    cout << "Payment number | Starting Balance  | Principal  |  Interest  |  Ending Balance" << endl;
		    cout << endl;
		}

		startingBalance = currentBalance;
	}

}

//loop control
bool keepGoing(){
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
int main(void){

//declare variables
double newLoanAmount,newRate,newMonthlyInterestRate ;
int newTerm, newNumMonths;
Loan newLoan;

do{
	// print prompts and get input	
    cout <<"Please enter the total loan amount: " <<endl;
	cin >>newLoanAmount;
    cin.clear(); 
    cin.ignore(256, '\n');
	if (newLoanAmount <= 0 ){
		cout << "Please enter a positive numeric value!"<<endl;
		cout<<endl;
		break;
	}
	newLoan.setLoanAmount(newLoanAmount);
    cout << "Please enter the interest rate in percent: " <<endl;
	cin >>newRate;
	cin.clear(); 
	cin.ignore(256, '\n');
	if (newRate <= 0 ){
		cout << "Please enter a positive numeric value!"<<endl;
		cout<<endl;
		break;
	}
	newLoan.setRate(newRate);
	cout << "Please Enter the term of the loan in years: " <<endl;
	cin >> newTerm;
	cin.clear(); 
	cin.ignore(256, '\n');
	if (newTerm <= 0 ){
		cout << "Please enter a positive numeric value!"<<endl;
		cout<<endl;
		break;
	}
	newLoan.setRate(newRate);
	cout << endl;
	
	newLoan.setMonthlyInterestRate(newRate);
	newLoan.setNumMonths(newTerm);
	newMonthlyInterestRate = newLoan.getMonthlyInterestRate();
	newNumMonths = newLoan.getNumMonths();

	//display results
	newLoan.display(newLoanAmount,newMonthlyInterestRate,newNumMonths);
}while(keepGoing() == true);

}//end main
