#!usr/bin/perl
print"please enter a new string on each line. When you are done press CTRL-Z: \n";
chomp(@list = <stdin>);
@reverse_lines = reverse @list;
print @reverse_lines;