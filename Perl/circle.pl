#!usr/bin/perl
print"Please Enter a radius:";
chomp($radius = <stdin>);
$pi = 3.141592654;
$circ = $radius * (2 * $pi);
if ($radius <=  0){
$circ = 0;
}
print "the circumference for a circle with a radius of 12.5 \n";
print "is: $circumference";

