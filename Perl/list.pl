#!usr/bin/perl
@names = qw(fred betty barney dino wilma pebbles bamm-bamm);
print "please enter some numbers between 1 and 7:\n";
chomp(@numbers = <stdin>);
foreach (@numbers){
	print "$names[$_ -1]\n";
	}