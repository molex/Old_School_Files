#include <stdio.h>

int sportsQuestion(void);
int geographyQuestion(void);
void pause(int);


int giResponse = 0;

main()
{
do {
	
	system("clear");
	printf("\n\tTHE TRIVIA GAME\n\n");
	printf("1 \t Sports\n");
	printf("2\t Geography\n");
	printf("3\t Quit\n");
	printf("\n\n Enter your selection: ");
	scanf("%d", &giResponse);
	switch(giResponse) {
			
			case 1:
			
				if (sportsQuestion() == 4)
					printf("\nCorrect!\n");
				else
					printf("\nIncorrect\n");
				
				pause(2);
				break;
			
			case 2:
				if (geographyQuestion() == 2)
					printf("\nCorrect!\n");
				else
					printf("\nIncorrect\n");
				pause(2);
				break;
		}//end switch
		
	}while (giResponse !=3); 
	
}//end Main

int sportsQuestion(void)
{

	int iAnswer = 0;
	
	system("clear");
	printf("\tSports Question\n");
	printf("\nWhat University did NFL star Deon Sanders attend? ");
	printf("\n\n1\t University of Miami\n");
	printf("2\t California State University\n");
	printf("3\t Indiana University\n");
	printf("4\t Florida State University\n");
	printf("\n Enter your selection: ");
	scanf("%d", &iAnswer);
	
	return iAnswer;
}//end function


int geographyQuestion(void)
{

	int iAnswer = 0;

	system("clear");
	printf("\t Geography Question\n");
	printf("\n What is the state capital of Florida? ");
	printf("\n\n1\t Pensacola\n");
	printf("2\t Tallahassee\n");
	printf("3\t Jacksonville\n");
	printf("4\t Miami\n");
	printf("\n Enter your selection: ");
	scanf("%d", &iAnswer);

	return iAnswer;
}//end function

void pause(int inNum)
{

	int iCurrentTime = 0;
	int iElapsedTime = 0;
	
	iCurrentTime = time(NULL);
	
	do{
		
		iElapsedTime = time(NULL);
		
	} while ( (iElapsedTime - iCurrentTime) < inNum );
	
}
