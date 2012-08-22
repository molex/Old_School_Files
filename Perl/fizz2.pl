#!usr/bin/perl
for $i(1..100){
	if (($i % 3) == 0 && ($i % 5) == 0) {
		print "FizzBuzz";
		print "\n";
		}
	elsif (($i % 3) == 0){
		print "Fizz";
		print "\n";
		}
	elsif (($i % 5) == 0){
		print "Buzz";
		print "\n";
		}
	else {
		print $i;
		print "\n";
		}
	}
