//Mike Brown Currency Conversion Program
//Version 0.2
#include <stdio.h>

main()//begin main function
{
              //initialize currency variables
              float yen = .00910;
              float euro = 1.47689;
              float pound = 1.85254;
              float canadian_Dollar = .95685;
              float peso = .9877;
              
              printf("\n Currency Conversion Program!");//display program name
              printf("\n Please select a currency to convert\n");//ask for user input
              printf("\n 1. Japanese Yen");//creates a menu of available options 
              printf("\n 2. Euro");//for currency conversion
              printf("\n 3. British Pound");//valid options are any number
              printf("\n 4. Canadian Dollar");//from 1-5
              printf("\n 5. Mexican Peso");
              getch();//holds window open so results can be seen
}//end main function


