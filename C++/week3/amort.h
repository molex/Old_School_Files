class AmortizationCalculator : public MortgageCalculator
{
    private:
        //Calculation variables
        double interestPaid;
        double principalPaid;
        double principalBalance;
        
    public:
        //Public constructor and destructor
        AmortizationCalculator();
        ~AmortizationCalculator();

        //Method prototypes
        double AmortizationCalculator::getInterestPaid();
        double AmortizationCalculator::getPrincipalPaid();
        double AmortizationCalculator::getPrincipalBalance();
        double AmortizationCalculator::setPrincipalBalance();
        double AmortizationCalculator::calculateMonthlyInterest();
        double AmortizationCalculator::calculatePrincipalPaid();
        double AmortizationCalculator::calculateNewPrincipalBalance();

};

//Constructor
AmortizationCalculator::AmortizationCalculator()
{

}

//Deconstructor
AmortizationCalculator::~AmortizationCalculator()
{

}



//Get Methods for AmortizationCalculator: all variables
double AmortizationCalculator::getInterestPaid()
{
    calculateMonthlyInterest();
    return interestPaid;
}

double AmortizationCalculator::getPrincipalPaid()
{
    calculatePrincipalPaid();
    return principalPaid;
}

double AmortizationCalculator::getPrincipalBalance()
{
    calculateNewPrincipalBalance();
    return principalBalance;
}


double AmortizationCalculator::setPrincipalBalance()
{
    principalBalance = getLoanAmount();
    return principalBalance;
}



double AmortizationCalculator::calculateMonthlyInterest()
{
    interestPaid = principalBalance * getMonthlyRate();
    return interestPaid;
}

double AmortizationCalculator::calculatePrincipalPaid()
{
    principalPaid = getMonthlyPayment() - interestPaid;
    return principalPaid;
}
        
double AmortizationCalculator::calculateNewPrincipalBalance()
{
    principalBalance = principalBalance - principalPaid;
    if(principalBalance > 0.00)
    {
        return principalBalance;
    }
    else
    {   
        principalBalance = 0.00;
        return principalBalance;
    }
}
