#!usr/bin/perl
print "what column width would you like?\n";
chomp(my $width = <stdin>);
print "enter a list of strings on seperate lines. Press CTRL-D when you are done: \n";
chomp(my @list = <stdin>);
print "1234567890" x (($width +9)/10), "\n";
foreach (@list){
 
	printf "%${width}s\n" , $_;
}
