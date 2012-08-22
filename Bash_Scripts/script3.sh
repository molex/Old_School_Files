#!/bin/bash
FILES="*"
num_Files=`ls $1|wc -l`
COUNTER=0
for f in $FILES ;
do 
   somestuff=`grep -o $2 $f |wc -l`
   if [ $somestuff -gt 0 ]; 
   then
   echo "file $f: found $somestuff occurences of word $2"
   elif [ $somestuff -eq 0 ];
   then
      let COUNTER=COUNTER+1  
   fi
done
if [ $COUNTER -eq $num_Files ];
then
echo "No file with word $2 found in directory $1"
fi
