#include<stdio.h>
main(){
       int x;//variable used for decrementing
       int countdown[10];//array that stores countdown clock
       
       //intitialize array
       for (x=0; x<10; x++)
           countdown[x] = x;
       //print array elements
       for (x=10; x>0; x--)//decrements x, starting at ten
           printf("\n %d", x);//displays countdown to sscreen
           
           printf("\n Go Live!!!");//when x is decremented down to 0, screen displays the words Go Live
           getch();//pauses screen to display results
           
           
           }//end main
           
           
           