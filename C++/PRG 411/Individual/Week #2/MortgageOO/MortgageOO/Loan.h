//#ifndef_LOAN_H_
//#define_LOAN_H_

#include <iostream>

using namespace std;
/*
   C++ 2     	   OO Mortgage calculator
   Programmer:	   Mike Brown
   E-Mail:         Molex333@gmail.com
   Date:		   September 29, 2009
   Program Name:   Loan.h
   Version:		   Version 1.0
   Purpose:		   This is the header file Loan.h which will be the interface for the class Loan.
*/

class Loan {

public:
		Loan();
		Loan(double loanAmount, double rate, int term);
		double getLoanAmount()const;
		double getRate()const;
		double getMonthlyInterestRate()const;
		int getTerm() const;
		int getNumMonths()const;
		void setLoanAmount(double newLoanAmount);
		void setRate(double newRate);
		void setTerm(int newTerm);
		void setNumMonths(int newTerm);
		void setMonthlyInterestRate(double newRate);
		void display(double loanAmount,double monthlyInterestRate,int numMonths);
		double payEachMonth(double monthlyInterestRate,double loanAmount,int numMonths);
		double getMonthlyInterest(double totalLoan, double monthlyInterestRate);
		double getPrincipalPaid(double monthlyPayment, double monthlyInterest);
		double getCurrentBalance(double principalPayment, double startingBalance);

private:
		double loanAmount,rate,monthlyInterestRate;
		int term,numMonths;
};

//#endif
