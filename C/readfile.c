#include <stdio.h>
main()
{
      FILE *pRead;
      char name[10];
      
      pRead = fopen("names.dat", "r");
      
      if (pRead)
         printf("\nFile cannot be opened\n");
      else{
          printf("\nContents of names.dat\n\n");
          fscanf(pRead, "%s", name);
          }
      while (!feof(pRead) ){
            
            printf("%s\n", name);
            fscanf(pRead, "%s", name);
            getch();
            
}
}


