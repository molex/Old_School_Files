#!usr/bin/perl
my @fred = &above_average(1..10);
print "\@fred is @fred\n";
print "(should be 6 7 8 9 10)\n";
my @barney = &above_average(100, 1..10);
print"\@barney is @barney\n";
print"(should be just 100)\n";

sub average{
	if(@_ == 0){return}
	my $count = @_;
	my $sum = &total(@_);
	$sum/$count;
	}

sub total{
my $sum;
foreach(@_){
	$sum += $_;
	}
	$sum;
}

sub above_average{
	my $average = &average(@_);
	my @list;
	foreach $element (@_){
		if ($element > $average){
			push @list, $element;
			}
		}
	@list;
}	
