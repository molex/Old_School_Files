#!usr/bin/perl
my @fred = qw(1 3 5 7 9 );
my $fred_total =&total(@fred);
print "the total of \@fred is $fred_total.\n";
print "enter some numbers on seperate lines:\n";
my $user_total = &total(<stdin>);
print "the total of those numbers is $user_total.\n";

sub total{
my $sum;
foreach(@_){
	$sum += $_;
	}
	$sum;
}