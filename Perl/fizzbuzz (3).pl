#!usr/bin/perl
for my $j (1..100) { 
	my $word = ($j % 3) == 0 && ($j % 5) == 0 ? "FizzBuzz" : ($j % 3) == 0 ? "Fizz" : ($j % 5) == 0 ? "Buzz" : $j;
	 print "$word ";
	 print "\n";
	  } 
	  
