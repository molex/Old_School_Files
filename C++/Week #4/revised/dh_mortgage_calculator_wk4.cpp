/* Course:			C++ Week Four Mortgage Calculator
   Programmer:		Deborah L. Herting
   Program Name:	dh_mortgage_calculator_wk4.cpp
   Version:			3.0 
   Description:		This is my week four C++ program that will calculate the monthly payment for a mortgage based on values that the
					user has entered.  The program will also allow the user to enter values display the mortgage
					amoritization schedule and allow the user to enter new values or quit the program.
					It uses a single programmer created function.
*/

#include <iostream>					// inserts iostream file contents and includes all instructions needed to use input/output statements
#include <math.h>					// allows me to use math functions in my program
#include <iomanip>

using namespace std; 

float mortgage(float mthlyPymt, float principle, float term, float interest);

int main()
{
	float interest(0.00);			// the variables that will hold the user entered values for term, interest and principle
	float principle (0.00);			// are all initialized to 0.
	float term (0.00);
	float mthlyPymt (0.00); 
	char letter;
	int count;						//to keep track of mortgage payment month
    
	for (count = 0; count <= 360; count++)
	{
		do								
			{
				cout << "\n***************************************************** " ;	//the use of escape sequence \n replaces endl in moving output to the next line
				cout << "\n\t\t Deborah's Mthly Mortgage Calculator ";						
				cout << "\n\n Enter the total amount or principle of the loan: ";
					cin  >> principle;													
				
				cout << "\n Enter the interest rate for the loan: ";
					cin  >> interest;													
							interest = (interest * 0.010)/12;	

				cout << "\n Enter the term or total length of the loan in months: "; 
					cin  >> term;														
			
				cout << " \n\n The amoritization schedule for this mortgage is" ;
				cout << "**Mthly Payment**" << setw(6) << "**Principle**" << setw(6)<< "**Interest**";
				
				while (mthlyPymt > 0 && count <= 360)
				{
					cout << "\n\n" << mortgage(mthlyPymt,principle,term,interest) <<  principle << interest;
						if (count % 22 == 0)
						{
						 cout << "Press enter to display more of the amoritization schedule ";
						 count++;
						}
				    cout << "\n\n***************************************************** ";
				}
			}
		        //cout << "\n The monthly payment for this loan will be " "  \t$ " 
				//<< mortgage(mthlyPymt, principle, term, interest) << ".";  //displays the calculated mthly pymt amount.
		
			cout << "\n\n\tWould you like to enter new values? "<<endl; 
			cout << " \n\n\t(select y or Y to continue or any other key to end the program) "<<endl;
			cin  >> letter;
			
		}while ((letter == 'y') || (letter == 'Y'));	
	
	return 0;	
}

float mortgage(float mthlyPymt, float principle, float term, float interest)
{
	interest;
	mthlyPymt = principle * ((interest / (1 - pow(1 + interest , -term))));
		/*the standard mortgage calculation formula used is M = P[i(1 + i)^t] / [(1 + i)^t - i] pulled from 
		http://www.fonerbooks.com/interest.htm. 200,000(1 + 0.004916)^360 = 1.004916^360 = 5.5893134 */	

return mthlyPymt;
}
