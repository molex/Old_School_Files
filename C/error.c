#include <stdio.h>
main()
{
    int a;
    int iArray [10];
    
//initialize array elements
    for ( a = 0; a < 10; a++ )
        iArray[a] = a;
   //print array element contents
    for ( a = 0; a < 10; a++ )
     printf("\nTony figured the array (HOOOYAH) for index %d is %d\n",a,a);  
//instructions for closing window
 printf("\n Please press enter to close window ");
getch ();    
}
