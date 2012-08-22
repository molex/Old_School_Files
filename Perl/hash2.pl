#!usr/bin/perl
my (@words, %count, $word);
print "Pleas enter a bunch of words, then hit CTRL-D when you are done";
chomp(@words = <stdin>);
foreach $word(@words){
	$count{$word} += 1;
}
foreach $word(sort keys %count){
	print "$word was seen $count{$word} times. \n";
}
