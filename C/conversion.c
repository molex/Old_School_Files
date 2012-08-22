#include <stdio.h>
#include <stdlib.h>

main()
{
/* This program prompts a user to input a U.S. Dollar float value and then
   prints the conversion of the dollar value to Argentine Peso, Brazilian Real,
   British Pound, Chinese Yuan, and Euro.  */
// Version 1.1  

  float cfArgPeso = 3.026;  //Constant float for Argentine Peso to U.S dollar conversion
  float cfBrazReal = 1.642;  //Constant float for Brazilian Real to U.S dollar conversion
  float cfBritPound = 0.555;  //Constant float for British Pound to U.S dollar conversion
  float cfChinYuan = 6.8213;   //Constant float for Chinese Yuan to U.S dollar conversion
  float cfEuro = 0.6847;  //Constant float for Euro to U.S dollar conversion
  double fUSDollar;  
  char sDollarInput[10];
  
  /* Display Currency Conversion tile */
  printf("\n**********************************************");
  printf("\n********** Currency Conversion ***************");
  printf("\n**********************************************\n\n");

  
  printf("\nPlease enter a U.S Dollar value to convert: ");  //Prompt users to enter a U.S. Dollar value
  scanf("%s", sDollarInput);  //Command line to input U.S Dollar value as a string to be checked for numeric
  
  if (isdigit(sDollarInput[0])) //check to see if first character is numeric or not. If it is numeric then run currency conversions
 {
  fUSDollar = atof(sDollarInput);  //convert array string to double numeric
  
  /* Print U.S. Dollar to Argentine Peso conversion */
  printf("\n %.2f U.S. Dollars equals %.2f Argentine Pesos", fUSDollar, fUSDollar*cfArgPeso);
  /* Print U.S. Dollar to Brazilian Real conversion */
  printf("\n %.2f U.S. Dollars equals %.2f Brazilian Reals", fUSDollar, fUSDollar*cfBrazReal);
  /* Print U.S. Dollar to British Pound conversion */
  printf("\n %.2f U.S. Dollars equals %.2f British Pounds", fUSDollar, fUSDollar*cfBritPound);
  /* Print U.S. Dollar to Chinese Yuan conversion */
  printf("\n %.2f U.S. Dollars equals %.2f Chinese Yuans", fUSDollar, fUSDollar*cfChinYuan);
  /* Print U.S. Dollar to Euro conversion */
  printf("\n %.2f U.S. Dollars equals %.2f Euros", fUSDollar, fUSDollar*cfEuro);
}
else  //character inputted is not numeric
{
  printf("\n\nYou did not enter a numeric value. Re-run the program and try again");

}
 getch(); //use getch statement to pause program execution on screen to display above currency conversions   
}
