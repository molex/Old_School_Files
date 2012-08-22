#include <stdio.h>

main()

{
     //Variable declaration and initializations 
     int iCurrency=0;
     int startover_or_exit=0;
     float US_Dollar=0;           
     float Euro=0;
     float Mexican_Peso=0;
     float British_Pound=0;
     float Japanese_Yen=0;
     float Jamaican_Dollar=0;
     
     while(startover_or_exit !=2)
{
     printf("\n\t\tCurrency Conversion\n");
     printf("\n\t\tC Program Version 5\n");
     printf("\n\t\tby Codell L. Jackson\n");
     printf("\n\tPOS370 Instrutor Dr. Shaykhian\n");
     
     printf("\n\n    With this program you can convert the US Dollar\n");
     printf("\n to foreign currency, go ahead and enter a Dollar amount.\n\n");
     scanf("%f",&US_Dollar); 
     printf("\nWhat currency would you like to convert to?\n\n\t1 Euro\n\t2 Mexican_Peso\n\t3 British_Pound\n\t4 Japanese_Yen\n\t5 Jamaican_Dollar\n");
     scanf("\t%i",&iCurrency);
     printf("\n  Your choice was\n");
     
     //Below statement will calculate the dollar amount you enter
     Euro=US_Dollar*.68;         
     Mexican_Peso=US_Dollar*10.15;
     British_Pound=US_Dollar*.54;
     Japanese_Yen=US_Dollar*109.37;
     Jamaican_Dollar=US_Dollar*.73;
     //Below are the verification statments
     switch(iCurrency){
         case 1:
             printf("  Euro\n\n");
             printf("  %.2f\n",Euro);                      
             break; 
         case 2:
             printf("  Mexican_Peso\n");
             printf("  %.2f\n",Mexican_Peso); 
             break;
         case 3:
             printf("  British_Pound\n");
             printf("  %.2f\n",British_Pound);
             break;
         case 4:
             printf("  Japanese_Yen\n");
             printf("  %.2f\n",Japanese_Yen);
             break;
         case 5:
             printf("  Jamaican_Dollar\n");
             printf("  %.2f\n",Jamaican_Dollar);
             break;
         default:
             printf(" an invalid choice, make a selection 1-5.\n");
} 
            
printf("\n\n  Would you like to start over or exit?\n");
printf("  Press 1 to start over or 2 to exit.\n");
scanf("%d",&startover_or_exit);//User decides if they want to startover or exit          

  if(startover_or_exit == 1);//Will return to main screen

 else if(startover_or_exit==2);//This will exit the program
 system("CLS");
 printf("\n           See you later!!\n");
 printf("\n Press any key to close this window.\n");
}
getch(); //Getch statement holds the screen 
}

