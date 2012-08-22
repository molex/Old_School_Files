#!usr/bin/perl
print "please type a line of text: ";
chomp($text = <stdin>);
print "please enter a number: ";
chomp($num = <stdin>);
print "$text\n" x $num;