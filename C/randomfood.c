#include<stdio.h>
#include<stdlib.h>

main(){
int i1 = 0;
//int iRandomNum = 0;
//srand(time(NULL));
//i1= rand()  % 3;
printf("\nPlease enter a number from 1-3 or press 0 to exit");
scanf("%d", &i1);

switch (i1 ){
case 1:
    printf("\nMcDonalds");
    break;
    
    
case 2 :
    printf("\nSubway");
    break;
    
    
case 3 :
    printf("\nTaco Bell");
    break;
    
default :
        printf("\nPlease Enter a valid number(1-3)");
        goto main();    
    
}//end switch
getch();
}//end Main
