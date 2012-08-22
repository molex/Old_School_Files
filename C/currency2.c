//Mike Brown Currency Conversion Program
#include <stdio.h>

main()//begin main function
{
              //initialize currency variables
              float yen = .00910;
              float euro = 1.47689;
              float pound = 1.85254;
              float canadian_Dollar = .95685;
              float peso = .9877;
              int user_Response = 0;
              float conversion_Amount = 0;
              float total_Dollars=0;
              
              printf("\n Currency Conversion Program!\n");//display program name
              printf("\n 1. Japanese Yen");//creates a menu of available options 
              printf("\n 2. Euro");//for currency conversion
              printf("\n 3. British Pound");//valid options are any number
              printf("\n 4. Canadian Dollar");//from 1-5
              printf("\n 5. Mexican Peso");
              printf("\n Please select a currency to convert, option 1 is the only functioning  choice\n");//ask for user input
              scanf("%d", &user_Response);
              
              if(user_Response == 1){//If the user selects option 1
                               printf("\nYou Chose Japanese Yen");
                               printf("\n Please enter the amoount of Yen you would like to convert:\n ");//ask user how much yen they have to convert
                               scanf("%f", &conversion_Amount);//store that amount into the variable and prepare for conversion
                               total_Dollars = (yen * conversion_Amount);//multiply yen * conversion amount 
                               printf("\n Your total is: $ %.2f", total_Dollars);//display american dollar amount
                               }
              else
                               printf("\nPlease enter a valid option(1)");//tells user to select a valid option
              getch();//holds window open so results can be seen
}//end main function




