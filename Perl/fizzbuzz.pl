#!usr/bin/perl
for my $i(1..100){
	if ($i % 3) == 0 && ($i % 5) == 0 {
		print "FizzBuzz";
		print "\n";
		}
	elsif ($i % 3) == 0{
		print "Fizz";
		print "\n";
		}
	elsif ($i % 5) == 0{
		print "Buzz";
		print "\n";
		}
	else {
		print $i;
		print "\n";
		}
	}
	
//perl -e 'for my $i (1..100) { my $word = ($i % 3) == 0 && ($i % 5) == 0 ? "FizzBuzz" : ($i % 3) == 0 ? "Fizz" : ($i % 5) == 0 ? "Buzz" : $i; print "$word "; } print "\n"'
