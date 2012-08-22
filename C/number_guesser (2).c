#include <stdio.h>
main()
{
int random_Number = 0;
int user_Response = 0;
char iResponse = '\0';
srand(time());
random_Number = (rand() % 10) +1;

printf("\nDo you want to play? y or n: ");
scanf("%c", &iResponse);

if (iResponse == 'y' || iResponse == 'Y'){

	printf("\nGuess a number between 1 and 10: ");
	scanf("%d", &user_Response);

		if (user_Response == random_Number)
			printf("\n You guessed right\n");
		else {
			printf("\nSorry, you guessed wrong\n");
			printf("The correct guess was %d\n", random_Number);
      }//end else
}//end if
else
	printf("\n Good Bye!!");

}//end main
