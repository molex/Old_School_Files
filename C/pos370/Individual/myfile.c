//Show how to save your name in a data file named MyFile.txt. 


#include<stdio.h>
main(){
       FILE *pWrite;//pointer to file type
       
       char fName[10];//first name variable
       char lName[10];//last name variable
       
       
       pWrite = fopen("MyFile.txt", "w");//create file MyFile.txt
       
       if (pWrite == NULL)
          printf("\nFile not opened\n");//lets user know if the file open operation failed
       else {
            printf("\nEnter your first name,last name\n\n");//request that displays on screen for user entered data
            printf("Enter name: ");
            
            scanf("%s%s", fName,lName);//get input from user
            fprintf(pWrite, "%s %s \n", fName,lName);//write the first and last name to the file MyFile.txt
            
            fclose(pWrite);//close MyFile.txt
            
            }//end if
            
            getch();//hold window open to see results
            }//end main
            
            
            
 

