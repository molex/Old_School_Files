#!usr/bin/perl
print "enter some words to be alphabatized: \n";
chomp(@list= <stdin>);
@sorted = sort @list;
print "@sorted\n";
	