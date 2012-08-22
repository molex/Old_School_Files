#include<stdio.h>
/*Copy input to output and replace any extra spaces with a single space */
main()
{
     int c,d;
    
     while((c = getchar()) != EOF)
     {
          d =0;
     
          if (c == '\t')
          {    
               putchar("\\");
               putchar("t");
               d =1;
               
               
          }
          if(c == '\b')
          {
               putchar("\\");
               putchar("b");
               d=1;
               
          }
          if(c == '\\')
          {
               putchar("\\");
               putchar("\\");
               d=1;
               
          }
          if(d != 1)
          {
               putchar(c);
          }
     }
     return 0;
}
