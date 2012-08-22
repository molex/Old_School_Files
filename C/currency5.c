//Mike Brown Currency Conversion Program
#include <stdio.h>//standard input output
#include <ctype.h>//charecter handling library

main()//begin main function
{
              //initialize currency variables
              float yen = .00910;
              float euro = 1.47689;
              float pound = 1.85254;
              float canadian_Dollar = .95685;
              float peso = .9877;
              int user_Response = 0;//variable to store user selection
              float conversion_Amount = 0;//stores amount of currency to be converted
              float total_Dollars=0;//stores total American Dollars after conversion
              
while(user_Response != 6){
              
              printf("\n Currency Conversion Program!\n");//display program name
              printf("\n 1. Japanese Yen");//creates a menu of available options 
              printf("\n 2. Euro");//for currency conversion
              printf("\n 3. British Pound");//valid options are any number
              printf("\n 4. Canadian Dollar");//from 1-5
              printf("\n 5. Mexican Peso");
              printf("\n 6. Quit");
              printf("\n Please select a currency to convert or Press 6 to quit\n");//ask for user input
              scanf("%d", &user_Response);//used to select conversion type
              //if(isdigit(user_Response)){
              if(user_Response == '1'){//when user selects 1 from menu
                                    printf("\nYou Chose Japanese Yen");
                                    printf("\n Please enter the amount of Yen you would like to convert:\n ");
                                    scanf("%f", &conversion_Amount);//stores conversion amount
                                    total_Dollars = (yen * conversion_Amount);//calculates conversion amount
                                    printf("\n Your total is: $ %.2f", total_Dollars); //displays total dollar amount   
                                    }
              else if(user_Response == 2){
                                    printf("\nYou Chose Euro");
                                    printf("\n Please enter the amount of Euro's you would like to convert:\n ");
                                    scanf("%f", &conversion_Amount);
                                    total_Dollars = (euro * conversion_Amount);
                                    printf("\n Your total is: $ %.2f American Dollars", total_Dollars);
                                    }
              else if(user_Response == 3){
                                    printf("\nYou Chose British Pound");
                                    printf("\nPlease enter the amount of Pounds you would like to convert: \n");
                                    scanf("%f", &conversion_Amount);
                                    total_Dollars = (euro * conversion_Amount);
                                    printf("\n Your total is: $ %.2f American Dollars", total_Dollars);
                                    }
              else if (user_Response == 4){
                                    printf("\nYou Chose Canadian Dollar");
                                    printf("\nPlease enter the amount of Canadian Dollars you would like to convert: \n");
                                    scanf("%f", &conversion_Amount);
                                    total_Dollars = (canadian_Dollar * conversion_Amount);
                                    printf("\n Your total is: $ %.2f American Dollars", total_Dollars);
                                    }
              else if (user_Response == 5){
                                    printf("\nYou Chose Mexican Peso");
                                    printf("\nPlease enter the amount of Pesos you would like to convert: \n");
                                    scanf("%f", &conversion_Amount);
                                    total_Dollars = (peso * conversion_Amount);
                                    printf("\n Your total is: $ %.2f American Dollars", total_Dollars);
                                    }
              else if (user_Response == 6){//exits the menu
                   printf("\nGood Bye!!");
                   break;//breaks the while loop, so that the program can exit
                   }
                            
              else
                               printf("\nPlease enter a valid option(1-6)");//menu selectioon input validation
                              // }//end menu if
              //else 
                 //  printf("\nPlease enter a valid option(1-6)");
                   
                   
}//while
                                             
              getch();//holds window open so results can be seen
}//end main function




