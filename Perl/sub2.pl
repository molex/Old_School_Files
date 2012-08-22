#!usr/bin/perl
my @nums = (1..1000);
my $result = &total(@nums);
print "the sum of all numbers from 1- 1000 is:\n";
print "$result";

sub total{
my $sum;
foreach(@_){
	$sum += $_;
	}
	$sum;
}
