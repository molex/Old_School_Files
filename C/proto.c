#include <stdio.h>

int addTwoNumbers (int,int);//function prototype

main()
{
int num1, num2;

printf("\nEnter the first number: ");
scanf("%d", &num1);
printf("\nEnter the second number: ");
scanf("%d", &num2);

printf("\nThe result is %d\n", addTwoNumbers(num1, num2));
getch();

}

//function definition

int addTwoNumbers(int operand1, int operand2)
{
return operand1 + operand2;
}
