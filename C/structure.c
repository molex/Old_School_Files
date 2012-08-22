#include<stdio.h>
menu(){
       printf("\n Currency Conversion Program!\n");//display program name
       printf("\n 1. Japanese Yen");//creates a menu of available options 
       printf("\n 2. Euro");//for currency conversion
       printf("\n 3. British Pound");//valid options are any number
       printf("\n 4. Canadian Dollar");//from 1-5
       printf("\n 5. Mexican Peso");
       printf("\n 6. Quit");
       printf("\n Please select a currency to convert or Press 6 to quit\n");//ask for user input
       scanf("%d", &user_Response);