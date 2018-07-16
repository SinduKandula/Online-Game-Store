#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$Title = $query->param("Title");
# Remove leading and trailing spacing.
$Title =~ s/^\s*(\S*)\s*$/$1/;
$Title =~ s/;|>|>>|<|\*|\?|\&|\|//g;
system("/usr/bin/java SearchCD '$Title'");
