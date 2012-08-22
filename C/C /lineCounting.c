#include <stdio.h>
/* count lines in input */
main()
{
     int c,n1,bl,tb;
     
     n1 = bl = tb = 0;
     while((c = getchar()) != EOF)
     {
          
          if (c == '\n')
               ++n1;
          if(c == '\t')
               ++tb;
          if(c == ' ')
               ++bl;
     }
     
     
     printf("%d, New Lines\n", n1);
     printf("%d, Blank Lines\n", bl);
     printf("%d, Tabs\n", tb);
}
