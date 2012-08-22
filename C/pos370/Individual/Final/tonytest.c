#include <stdio.h>
#include <stdlib.h>

void main()
{

// Initilazation of currency variables
                 float Euro = 0.6815;
               float Riyal = 3.7503;
               float Dinar = 0.2673;
               float Rands = 8.110;
                 float LBP = 1501.0101;
    double USD;  
     char sInput[50];

  //display the title currency conversion
  printf("\nCurrency Conversion ");
  printf("\n~~~~~~~~~~~~~~~~~~~ ");
  printf("\n ");
 
  printf("\nPlease enter a U.S Dollar (USD) value to convert: ");  
  scanf("%s", sInput); 

 if (isdigit(sInput[0])) 
 {
USD = atol (sInput);  
  
  /* Print U.S. Dollar to Euro conversion */
  printf("\n %.2f U.S. Dollars equals %.2f European (EURO)", USD, USD*Euro);
  /* Print U.S. Dollar to SAR conversion */
  printf("\n %.2f U.S. Dollars equals %.2f Saudi Arabian Riyal (SAR)", USD, USD*Riyal);
  /* Print U.S. Dollar to KWD conversion */
  printf("\n %.2f U.S. Dollars equals %.2f Kuwaiti Dinar (KWD)", USD, USD*Dinar);
  /* Print U.S. Dollar to ZAR conversion */
  printf("\n %.2f U.S. Dollars equals %.2f South African Rands (ZAR)", USD, USD*Rands);
  /* Print U.S. Dollar to LBP conversion */
  printf("\n %.2f U.S. Dollars equals %.2f Lebanese Pound (LBP)", USD, USD*LBP);
}
else 
{
  printf("\n\ninvalid entry, please exit the system immediately");

  //instructions for closing window
 printf("\n Please press enter to close window ");
} 
 getch();

} //end main function
 

