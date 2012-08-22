//Mike Brown Currency Conversion Program Version 2.0
#include <stdio.h>//standard input output



main()//begin main function
{
              //initialize currency variables
              float yen = .00910;
              float euro = 1.47689;
              float pound = 1.85254;
              float canadian_Dollar = .95685;
              float peso = .9877;
              char user_Response[10];//variable to store user selection
              float conversion_Amount = 0;//stores amount of currency to be converted
              float total_Dollars=0;//stores total American Dollars after conversion
              int valid_Response;
 while(valid_Response){
              
              printf("\n Currency Conversion Program!\n");//display program name
              printf("\n 1. Japanese Yen");//creates a menu of available options 
              printf("\n 2. Euro");//for currency conversion
              printf("\n 3. British Pound");//valid options are any number
              printf("\n 4. Canadian Dollar");//from 1-5
              printf("\n 5. Mexican Peso");
              printf("\n 6. Quit");
              printf("\n Please select a currency to convert or Press 6 to quit\n");//ask for user input
              scanf("%d", &user_Response);//used to select conversion type
              if(isdigit(user_Response[0])) 
 {
             
             valid_Response = atol(user_Response);
              switch (valid_Response){
              
              case 1://when user selects 1 from menu
                                    printf("\nYou Chose Japanese Yen");
                                    printf("\n Please enter the amount of Yen you would like to convert:\n ");
                                    scanf("%f", &conversion_Amount);//stores conversion amount
                                    total_Dollars = (yen * conversion_Amount);//calculates conversion amount
                                    printf("\n Your total is: $ %.2f", total_Dollars); //displays total dollar amount
                                    break;   
                                    
              case 2 ://loop for menu selection #2
                                    printf("\nYou Chose Euro");
                                    printf("\n Please enter the amount of Euro's you would like to convert:\n ");
                                    scanf("%f", &conversion_Amount);
                                    total_Dollars = (euro * conversion_Amount);
                                    printf("\n Your total is: $ %.2f American Dollars", total_Dollars);
                                    break;
              case 3://Loop for menu selection #3
                                    printf("\nYou Chose British Pound");
                                    printf("\nPlease enter the amount of Pounds you would like to convert: \n");
                                    scanf("%f", &conversion_Amount);
                                    total_Dollars = (euro * conversion_Amount);
                                    printf("\n Your total is: $ %.2f American Dollars", total_Dollars);
                                    break;
              case 4://Loop for menu selection #4
                                    printf("\nYou Chose Canadian Dollar");
                                    printf("\nPlease enter the amount of Canadian Dollars you would like to convert: \n");
                                    scanf("%f", &conversion_Amount);
                                    total_Dollars = (canadian_Dollar * conversion_Amount);
                                    printf("\n Your total is: $ %.2f American Dollars", total_Dollars);
                                    break;
              case 5://Loop For menu selection #5 
                                    printf("\nYou Chose Mexican Peso");
                                    printf("\nPlease enter the amount of Pesos you would like to convert: \n");
                                    scanf("%f", &conversion_Amount);
                                    total_Dollars = (peso * conversion_Amount);
                                    printf("\n Your total is: $ %.2f American Dollars", total_Dollars);
                                    break;
              case 6:
                                    printf("goodbye!!!\n");
                                    system("exit");
                                    break;
              
                  }//end switch
                               
                               }//end if
                               
              
                   
              else
                  printf("\nEnter a valid input");     
                  
                  }//end while  
                             
             getch();//holds window open so results can be seen

}//end main



