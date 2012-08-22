

# include <iostream>
# include <iomanip>
# include <string.h>
# include <ctype.h>
# include <math.h>
# include "validation.h"
# include "mortclass.h"
# include "amort.h"

using namespace std;






//Time for a little validation here


//A little input/output action

class InputOutput
{
    private:
        //Return variables
        double amt;
        double rate;
        int term;
        int listSelection;
        
        //Local input variables
        char caAmt[50];
        char caRate[50];
        char caYears[50];
        char caSelect[1];

        //Control variables
        bool newCalc;
        bool isNum;
        char recaluate[3];
        char quit[3];

        //Instance of Object
        NumericValidator myNumericValidator;
        
    public:
        //Declare public constructor and destructor
        InputOutput();
        ~InputOutput();

        
        double InputOutput::amountInput();
        double InputOutput::rateInput();
        int InputOutput::termInput();
        int InputOutput::loanSelectionInput();
        bool InputOutput::mortCalcRecalculate();
        bool InputOutput::confirmExit();
        void InputOutput::mortCalcOutput(double myAmount, double myRate, int myTermYears, double myPayment);
        void InputOutput::amortTableWelcomeOutput();
        void InputOutput::amortTableMPHdrOutput();
        void InputOutput::amortTableTitleOutput();
        void InputOutput::amortTableHeaderOutput();
        void InputOutput::amortTableOutput(int payNum, double myPaymt, double myPrincipalPd, double myInterestPd, double myPrincipalBal);

};

//Constructor
InputOutput::InputOutput()
{

}

//Destructor
InputOutput::~InputOutput()
{

}



double InputOutput::amountInput()
{   
    cout << "\nPlease enter dollar amount of loan. (Ex500000): ";
    cin >> caAmt;
    isNum = myNumericValidator.evalMinTripDigitDouble(caAmt);
    if(isNum)
    {
        amt = atof(caAmt);
        return amt;
    }
    else 
    {
        cout << "\nIvalid input please ultilize example provided\n\n";
        amt = 0.00;
        return amt;
    }        
}    

double InputOutput::rateInput()
{
    cout << "Please input interest rate (Ex 5.25) ";
    cin >> caRate;
    isNum = myNumericValidator.evalStandardDouble(caRate);
    if(isNum)
    {
        rate = atof(caRate);
        return rate;
    }
    else
    {
        cout << "\nPlease follow example provided. You have entered an incorrect amount!!\n\n";
        rate = 0.00;
        return rate;
    }
}

int InputOutput::termInput()
{
    cout << "Please enter length of loan. (Ex 25)";
    cin >> caYears;
    isNum = myNumericValidator.evalMaxInteger(caYears, 2);
    if(isNum)
    {
        term = atoi(caYears);
        return term;
    }
    else
    {
        cout << "\nPlease follow example provided. You have entered an incorrect value!!\n\n";
        term = 0;
        return term;        
    }
}

int InputOutput::loanSelectionInput()
{
    cout << "Choose your rate terms and rate from menu provided below.\n"
         << "  1) 7 years with 5.35% interest\n"
         << "  2) 15 years with 5.5% interest\n"
         << "  3) 30 years with 5.75% interest\n"
         //<< "  4) Don't like those options? Choose your own\n\n"
         << "Please enter your choice: ";
    cin >> caSelect;
    isNum = myNumericValidator.evalMaxInteger(caSelect, 1);
    if(isNum && ((atoi(caSelect) > 0) && (atoi(caSelect) <= 4)))
    {   
        listSelection = atoi(caSelect);
        return listSelection;
    }
    else
    {
        cout << "\That is not an option please try again!!\n\n";
        listSelection = -1;
        return listSelection;
    }
}



bool InputOutput::mortCalcRecalculate()
{
    cout << "\nWant to calculate another loan? (Y)ay or (N)ay: ";
    cin >> recaluate;
    
    switch(recaluate[0])
    {
        case 'y':
        case 'Y':
            newCalc = true;
            return newCalc;            
        case 'n':
        case 'N':
            newCalc = false;
            return newCalc;
        default:
            cout << "\nThat was not an option please try again";
            mortCalcRecalculate();        
    }
}

bool InputOutput::confirmExit()
{
    cout << "\nYour not going to leave me now are you? (Y)ay or (N)ay";
    cin >> quit;

    switch(quit[0])
    {
        case 'y':
        case 'Y':
            newCalc = false;
            return newCalc;
        case 'n':
        case 'N':
            newCalc = true;
            return newCalc;
        default:
            cout << "\nThat was not a valid option please try again!!!!!!";
            confirmExit();
    }
}



void InputOutput::mortCalcOutput(double myAmount, double myRate, int myTermYears, double myPayment)
{
    cout << setiosflags(ios::fixed)
         << setprecision(2)
         << endl << endl << "WOW!! Your monthly payment on a loan of $" << myAmount << endl 
         << "over a term of " << myTermYears 
         << " years at " << myRate 
         << "% interest is: " 
         << "$" << myPayment << endl
         << "---------------------------------------------\n\n";
}

void InputOutput::amortTableWelcomeOutput()
{
    cout << "Welcome to the house of horrors where you see your money get lost in a mortgage.\n\n";
    cout << "Okay the directions on the screen are going to guide you through the process\n\n";
}

void InputOutput::amortTableMPHdrOutput()
{
    cout << "--------------------------------------------\n"
         << "\nLoan and Monthly Payment Information:";
}

void InputOutput::amortTableTitleOutput()
{   
    cout << "Amortization Table:\n";
}

void InputOutput::amortTableHeaderOutput()
{
    cout << "\nNumber  Payment  PrincipalPaid  InterestPaid  PrincipalBalance\n"
         << "------  -------  -------------  ------------  ----------------\n";//this space wigs me out but at least the output looks decent
}

void InputOutput::amortTableOutput(int payNum, double myPaymt, double myPrincipalPd, double myInterestPd, double myPrincipalBal)
{
    cout << setiosflags(ios::fixed)
         << setprecision(2);
    if(payNum < 10)
    {
        cout << "0" << payNum << "      ";
    }
    else
    {
        cout << payNum << "      ";
    }
    cout << myPaymt << "     "
         << myPrincipalPd << "         "
         << myInterestPd << "        "
         << myPrincipalBal 
         << endl; 
}

//In the begining there was...

int main(int argc, char *argv[])
{
    //Local method variables
    bool run = true;
    double amount;
    double rate;
    int termYears;
    double monPayment;
    double interestPd;
    double principalPd;
    double principalBal;
    int iaTerm[] = {7, 15, 30};
    double daRate[] = {5.35, 5.5, 5.75};
    
    //Local method control variables
    int paymentNumber;
    int finalPayment;
    char showNext[3];
    int loanControl;

    //Instances of objects
    AmortizationCalculator mainAmortCalc;
    InputOutput mainIO;

    //Display welcome message
    mainIO.amortTableWelcomeOutput();
    
    //Begin main program execution
    while(run == true)
    {
        //Reset all variables
        amount = 0.00;
        rate = 0.00;
        termYears = 0;
        loanControl = -1;
        monPayment = 0.00;
        interestPd = 0.00; 
        principalPd = 0.00;

                
        //Input and validation
        while(amount == 0.00)
        {
            amount = mainIO.amountInput();
        }
        while(loanControl == -1)
        {
            loanControl = mainIO.loanSelectionInput();
        }
        switch(loanControl)
        {
            case 1:
                rate = daRate[0];
                termYears = iaTerm[0];
                break;
            case 2:
                rate = daRate[1];
                termYears = iaTerm[1];
                break;
            case 3:
                rate = daRate[2];
                termYears = iaTerm[2];
                break;
            case 4:
                while(rate == 0.00)
                {
                    rate = mainIO.rateInput();
                }                
                while(termYears == 0)
                {
                    termYears = mainIO.termInput();
                }
                break;
        }

        //Instantiate MortCalc with values
        mainAmortCalc.setLoanAmount(amount);
        mainAmortCalc.setInterestRate(rate);
        mainAmortCalc.setLoanTermYears(termYears);

        //Display header and monthly payment
        mainIO.amortTableMPHdrOutput();
        monPayment = mainAmortCalc.calculateMonthlyPayment();
        mainIO.mortCalcOutput(amount, rate, termYears, monPayment);

        //Display headers
        mainIO.amortTableTitleOutput();
        mainIO.amortTableHeaderOutput();

        //Instantiate AmortCalc loop with initial values
        principalBal = mainAmortCalc.setPrincipalBalance();
        paymentNumber = 1;
        finalPayment = mainAmortCalc.getLoanTermMonths();
        showNext[0] = 'y';
        
        //AmortTable calculation and output loop
        do
        {
            //Run this set of AmortCalc calculations
            interestPd = mainAmortCalc.calculateMonthlyInterest();
            
            if(monPayment > principalBal)
            {
                monPayment = principalBal + interestPd;
            }

            principalPd = mainAmortCalc.calculatePrincipalPaid();
            principalBal = mainAmortCalc.calculateNewPrincipalBalance();      
            
            //Display values for this run
            mainIO.amortTableOutput(paymentNumber, monPayment, principalPd, interestPd, principalBal);
            
            //If AmortTable is showing a multiple of 24 payments, ask user to show more or not
            if((paymentNumber % 24) == 0 && (principalBal > 0.001))
            {
                cout << "\nDo you desire to see the rest of the table (Y)eah or (N)ay: ";
                cin >> showNext;

                switch(showNext[0])
                {
                    case 'y':
                    case 'Y':
                        ++paymentNumber;
                        mainIO.amortTableHeaderOutput();
                        continue;
                    case 'n':
                    case 'N':
                        break;
                    default:
                        ++paymentNumber;
                        mainIO.amortTableHeaderOutput();
                        continue;
                }
            }
            else
            {
                if(paymentNumber < finalPayment)
                {
                    ++paymentNumber;
                }
            }

        }while((principalBal > 0.001) && (showNext[0] == 'y' || showNext[0] == 'Y'));
        
        //Set loop control for new loan
        run = mainIO.mortCalcRecalculate();

        if(run)
        {
            continue;
        }
        else
        {
            run = mainIO.confirmExit();
        }
    }

    //Exit program
    return 0;
}
