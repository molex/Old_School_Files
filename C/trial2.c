#include <stdio.h>

main()
{
int iResponse = 0;
printf("Enter a number from 1 to 10: ");
scanf("%d", &iResponse);

if (iResponse <1 || iResponse >10)
	printf("\nNumber not in range\n");
else
	printf("\nThank You!\n");
	pause();
}//end main

