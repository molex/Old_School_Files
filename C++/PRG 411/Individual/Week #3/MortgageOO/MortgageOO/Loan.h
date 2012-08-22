#include <iostream>

using namespace std;
/*
   C++ 2     	   OO Mortgage calculator
   Programmer:	   Mike Brown
   E-Mail:         Molex333@gmail.com
   Date:		   October 5, 2009
   Program Name:   Loan.h
   Version:		   Version 2.0
   Purpose:		   This is the header file Loan.h which will be the interface for the class Loan.
*/

class Loan {

public:
		Loan();
		Loan(double loanAmount, double rate, double term);
		double getLoanAmount()const;
		double getRate()const;
		double getMonthlyInterestRate()const;
		double getTerm() const;
		double getNumMonths()const;
		void setLoanAmount(double newLoanAmount);
		void setRate(double newRate);
		void setTerm(double newTerm);
		void setNumMonths(double newTerm);
		void setMonthlyInterestRate(double newRate);
		void display(double loanAmount,double monthlyInterestRate,double numMonths);
		double payEachMonth(double monthlyInterestRate,double loanAmount,double numMonths);
		double getMonthlyInterest(double totalLoan, double monthlyInterestRate);
		double getPrincipalPaid(double monthlyPayment, double monthlyInterest);
		double getCurrentBalance(double principalPayment, double startingBalance);
		char menuSelection();
private:
		double loanAmount,rate,monthlyInterestRate;
		double term,numMonths;
};


