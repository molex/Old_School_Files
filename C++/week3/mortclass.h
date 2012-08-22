class MortgageCalculator
{
    private:
        //Class term variables
        double loanAmount;
        double interestRate;
        int loanTermYears;
                
        //Class calculation variables
        double monthlyRate;
        double monthlyPayment;
        int loanTermMonths;
    
    public:
        //Declare public constructor and destructor
        MortgageCalculator();
        MortgageCalculator(double amount, double rate, int termYears);
        ~MortgageCalculator();

        //Method Prototypes
        double MortgageCalculator::getLoanAmount();
        double MortgageCalculator::getInterestRate();
        int MortgageCalculator::getLoanTermYears();
        double MortgageCalculator::getMonthlyRate();
        int MortgageCalculator::getLoanTermMonths();        
        double MortgageCalculator::getMonthlyPayment();
        void MortgageCalculator::setLoanAmount(double amount);
        void MortgageCalculator::setInterestRate(double rate);
        void MortgageCalculator::setLoanTermYears(int termYears);
        void MortgageCalculator::calculateMonthlyRate();
        void MortgageCalculator::calculateTermMonths();
        double MortgageCalculator::calculateMonthlyPayment();
        
};

//Default Constructor
MortgageCalculator::MortgageCalculator()
{

}

//Custom Constructor
MortgageCalculator::MortgageCalculator(double amount, double rate, int termYears)
{
    loanAmount = amount;
    interestRate = rate;
    loanTermYears = termYears;
}

//Destructor
MortgageCalculator::~MortgageCalculator()
{

}



//Get Methods for MortgageCalculator: all variables
double MortgageCalculator::getLoanAmount()
{
    return loanAmount;
}

double MortgageCalculator::getInterestRate()
{
    return interestRate;
}

int MortgageCalculator::getLoanTermYears()
{
    return loanTermYears;
}

double MortgageCalculator::getMonthlyRate()
{
    calculateMonthlyRate();
    return monthlyRate;
}

int MortgageCalculator::getLoanTermMonths()
{
    calculateTermMonths();
    return loanTermMonths;
}

double MortgageCalculator::getMonthlyPayment()
{
    calculateMonthlyPayment();
    return monthlyPayment;
}

//Set Methods for MortgageCalculator: term variables
void MortgageCalculator::setLoanAmount(double amount)
{
    loanAmount = amount;
}

void MortgageCalculator::setInterestRate(double rate)
{
    interestRate = rate;
}

void MortgageCalculator::setLoanTermYears(int termYears)
{
    loanTermYears = termYears;
}



void MortgageCalculator::calculateMonthlyRate()
{
    monthlyRate = interestRate/(12 * 100);
}

void MortgageCalculator::calculateTermMonths()
{
    loanTermMonths = loanTermYears * 12;
}

double MortgageCalculator::calculateMonthlyPayment()
{
    //Local method calls
    calculateMonthlyRate();
    calculateTermMonths();

    double divisor = (1 - pow((1 + monthlyRate), -loanTermMonths));
    double multiplier = (monthlyRate / divisor);

    monthlyPayment = loanAmount * multiplier;

    return monthlyPayment;
}

