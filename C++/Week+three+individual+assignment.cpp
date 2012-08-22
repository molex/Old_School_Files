// C++2_Mortgage Calculator_V2.cpp : Defines the entry point for the console application.

//Programmer:  Trey Carter

//C++ II Class

//Date: October 12, 2009

//Purpose: This application will allow the user to interact with the program by allowing the user to input the amount of
//a loan then choose from a choice of terms and percentage rates. Upon execution, the application will display the monthly
//payment. Then for each payment the application will display the amount paid to interest, deduct the amount paid to the
//principal and display the remaining balance for the term of the loan chosen.
//***********************************************************************************************************************

//#include "stdafx.h"
#include <iostream>
#include <iomanip>
#include <cmath>
#include <conio.h>

using namespace std; 
using std::cin;
using std::cout;
using std::endl;


class CMortgage_Calculator			//class definition

{

public:							//allows public access

      double principal;				//class member principal

	  double balance;				// member balance

	  double monthly_payment;		//member monthly payment

	  double interest_paid;			//member interest paid

	  double paid_to_principal;		//member amount paid to principal

public:

	  void header ();			//class member function for header

	  void enter_principal();	//class member function for principal

};

void CMortgage_Calculator :: header ()				//Defines member function for the header

{

	cout << "\t\t\t C++ II CLASS MORTGAGE CALCULATOR";  //display calculator head

	cout <<endl;
	cout <<endl;

}

void CMortgage_Calculator ::enter_principal()		//Defines member function to enter pricipal

{

	cout << "\t\t\t Please enter the amount of your loan:   ";   //display option to enter mortgage amount
	cin>> principal;											 // enter principal

	cout << endl;
	cout << endl;

}

int main ()
{

	CMortgage_Calculator calculator;			//Declares calculator with no values

	//Declare variables

	  double principal = 0;				

	  double balance = principal;

	  double monthly_payment = 0;

	  double interest_paid = 0;

	  double paid_to_principal = 0;

	  double apr [] = {5.35,5.5,5.75};				//class member apr (%) array

	  int term [] = {7,15,30};				//class member term array

	  int loan_selection = 0;				//Choose a loan

	  char indicator ='y';			           // Character variable initialized to y


		calculator.header();			//Call the header function


		do					//begin loop

		{

		calculator.enter_principal();	//Call the enter principal function


		//Display choice of loans

			cout<< "\t\t Please Choose From the Following List of Loans";			

	cout << endl;
	cout<< endl;

	cout <<"\t\t Loan 1: 7 years @ 5.35%";

	cout << endl;
	cout<< endl;

	cout << "\t\t Loan 2: 15 years @ 5.5%";

	cout << endl;
	cout << endl;

	cout << "\t\t Loan 3: 30 years @ 5.75%";

	cout << endl;
	cout << endl;

	cout << "\t\tPlease enter your selection:   ";  
	cin >> loan_selection;		//enter numerical selection

	cout << endl;
	cout << endl;

			
			switch (loan_selection)				//switch for loan choices

			{

			case 1:			//First loan

				cout << "\t\t You have chosen 7 years @ 5.35%";

					cout << endl;

					cout << endl;

					monthly_payment = (calculator.principal * (apr [0]/100)/12) / (1-pow(1+((apr [0]/100)/12), - (term [0]*12)));  //Formula to calculate payment

					cout << endl;
					cout <<endl;

					cout <<"\t\t The monthly payment for this loan is: $" <<monthly_payment; // display monthly payment

					cout << endl;
					cout <<endl;

				for(int i = 0 ; i <= term [0]-1 ; i=i+1)   //loop for term of the loan

					{
			
							cout <<"\t\tBalance of Loan" << "\t\t\tAmount of Interest Paid" << endl;
							
				for (int j = 0; j<=12; j=j+1)     //loop for pausing the scroll

							{

							interest_paid = (calculator.principal * ((apr[0]/100)/12));  //formula for interest paid

							paid_to_principal = monthly_payment - interest_paid;         //formula for amount applied to principal

							balance = calculator.principal - paid_to_principal;			//formula to calculate remaining balance

							if (balance < 0)balance = 0;		//prevents negative difference 

							calculator.principal = balance;		// sets principal to equal balance

							

							cout <<"\t\t" <<setprecision(2) << fixed << "$" << setw(5) << balance << "\t\t\t\t$"<< setw(5) << interest_paid << endl;
							}


							cout << endl;
							cout << endl;
							cout << "Press enter to continue...";   //enter to continue to view output
							cin.get();
							cout << endl;
							cout << endl;
							
						}
							
					

					break;
			case 2:        //Loan two

				cout << "\t\t You have chosen 15 years @ 5.5%";   //display loan chosen

				cout <<endl;
				cout <<endl;

					monthly_payment = (calculator.principal * (apr [1]/100)/12) / (1-pow(1+((apr [1]/100)/12), - (term [1]*12)));  //Formula to calculate payment

					cout << endl;
					cout <<endl;

					cout <<"\t\t The monthly payment for this loan is: $" <<monthly_payment;   //display monthly payment

					cout << endl;
					cout <<endl;

				for(int i = 0 ; i <= term [1]-1 ; i=i+1)       //loop full term

					{
			
							cout <<"\t\tBalance of Loan" << "\t\t\tAmount of Interest Paid" << endl;
							
				for (int j = 0; j<=12; j=j+1)  //loop to pause

							{

							interest_paid = (calculator.principal * ((apr[1]/100)/12)); //formula for interest paid

							paid_to_principal = monthly_payment - interest_paid;   //formula for amount applied to principal

							balance = calculator.principal - paid_to_principal;// formula for balance

							if (balance < 0)balance = 0;    //prevents negative difference

							calculator.principal = balance; // sets principal equal to balance

							

							cout <<"\t\t" <<setprecision(2) << fixed << "$" << setw(5) << balance << "\t\t\t\t$"<< setw(5) << interest_paid << endl;
							}


							cout << endl;
							cout << endl;
							cout << "Press enter to continue...";  //press enter to continue to view output
							cin.get();
							cout << endl;
							cout << endl;
							
						}


				break;

			case 3:				//loan three

				cout <<" \t\t You have chosen 30 years @ 5.75%";  //display loan chosen

				cout << endl;
				cout << endl;

				monthly_payment = (calculator.principal * (apr [2]/100)/12) / (1-pow(1+((apr [2]/100)/12), - (term [2]*12)));  //Formula to calculate payment


				cout <<"\t\t The monthly payment for this loan is: $" <<monthly_payment;  //display monthly payment

					cout << endl;
					cout <<endl;

				for(int i = 0 ; i <= term [2]-2 ; i=i+1)  //loop full term

					{
			
							cout <<"\t\tBalance of Loan" << "\t\t\tAmount of Interest Paid" << endl;
							
				for (int j = 0; j<=12; j=j+1)     //loop to pause scroll

							{

							interest_paid = (calculator.principal * ((apr[2]/100)/12)); //formula for interest paid

							paid_to_principal = monthly_payment - interest_paid;		//formula for amount applied to principal

							balance = calculator.principal - paid_to_principal;			//formula for balance

							if (balance < 0)balance = 0;		//prevents negative difference

							calculator.principal = balance;     //sets principal to equal balance

							

							cout <<"\t\t" <<setprecision(2) << fixed << "$" << setw(5) << balance << "\t\t\t\t$"<< setw(5) << interest_paid << endl;
							}


							cout << endl;
							cout << endl;
							cout << "Press enter to continue...";  //enter to continue to view output
							cin.get();
							cout << endl;
							cout << endl;
							
						}


				break;

			default:      //default for improper input

				cout << "\t\t You have made an invalid choice!" <<endl;

				if ((loan_selection <=0) || (loan_selection > 3))      // if loan selection is not within from 1 to 3

				{
					system("cls");
					cout << "Please enter a new choice!!!";  //option to enter a new choice
					system("PAUSE");			//pause the system
 
					system("cls");

					return main ();  //return to main start over
}

			}

							cout << "Would you Like to choose another loan? Y or N:  "; //option to enter a new loan

							cin >> indicator;

						

								}while ((indicator == 'y') || (indicator == 'Y'));  //end while loop enter y to continue

							cin.get();  //get character from keyboard

	return 0;
}

