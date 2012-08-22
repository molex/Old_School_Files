class NumericValidator
{
    private:
        //Control variables
        bool isNumeric;
        bool hasDecimal;

    public:
        //Declare public constructor and destructor
        NumericValidator();
        ~NumericValidator();
        
        //Method Prototypes
        bool NumericValidator::evalMaxInteger(char* myStrToValidate, int digits);
        bool NumericValidator::evalStandardDouble(char* myStrToValidate);
        bool NumericValidator::evalMinTripDigitDouble(char* myStrToValidate);        

};

//Constructor
NumericValidator::NumericValidator()
{

}

//Deconstructor
NumericValidator::~NumericValidator()
{

}

//And some more validation

bool NumericValidator::evalMaxInteger(char* myStrToValidate, int digits)
{
    isNumeric = true;
    
    //Test for set max number of digits passed as parameter
    if((int)strlen(myStrToValidate) > digits)
    {
        isNumeric = false;
    }
    else
    {
        //Test chars as digits only
        for(int i=0; i < (int)strlen(myStrToValidate); i++)
        {
            if(isdigit(myStrToValidate[i]))
            {
                continue;
            }
            else
            {
                isNumeric = false;
                break;
            }
        }
    }    

    return isNumeric;
}

//and more validation hopefully this will work
bool NumericValidator::evalMinTripDigitDouble(char* myStrToValidate)
{
    isNumeric = true;
    hasDecimal = false;
    
    if((int)strlen(myStrToValidate) < 3)
    {
        isNumeric = false;
    }
    else
    {
        for(int i=0; i < (int)strlen(myStrToValidate); i++)
        {
            //Test first 3 chars as digits
            if(i < 3)
            {
                if(isdigit(myStrToValidate[i]))
                {
                    continue;
                }   
                else
                {
                    isNumeric = false;
                    break;
                }
            }

            //Test rest of chars as digits allowing for a single decimal
            if(i >= 3)
            {
                if((isdigit(myStrToValidate[i]) == 0) && (hasDecimal == false))
                {
                    if(myStrToValidate[i] == '.')
                    {
                        hasDecimal = true;
                        continue;
                    }
                    else
                    {
                        isNumeric = false;
                        break;
                    }
                } 
                else
                {
                    if((isdigit(myStrToValidate[i]) == 0) && (hasDecimal == true))
                    {
                        isNumeric = false;
                        break;
                    }
                }
            }
        }    
    }    

    return isNumeric;
}

bool NumericValidator::evalStandardDouble(char* myStrToValidate)
{
    isNumeric = true;
    hasDecimal = false;
    
    //Test chars as digits allowing for a single decimal
    for(int i=0; i < (int)strlen(myStrToValidate); i++)
    {
        if((isdigit(myStrToValidate[i]) == 0) && (hasDecimal == false))
        {
            if(myStrToValidate[i] == '.')
            {
                hasDecimal = true;
                continue;
            }
            else
            {
                isNumeric = false;
                break;
            }
        }
        else
        {
            if((isdigit(myStrToValidate[i]) == 0) && (hasDecimal == true))
            {
                isNumeric = false;
                break;
            }
        }
    }

    return isNumeric;
}
