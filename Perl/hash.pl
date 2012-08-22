#!usr/bin/perl
my %last_name = qw{
fred flintstone
barney rubble
wilma flintstone
};
print "please enter a first name: \n";
chomp (my $name = <stdin>);
print "that's $name $last_name{$name}. \n";
