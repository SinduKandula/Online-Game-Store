#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$UserName = $query->param("UserName");
$Password = $query->param("Password");
$UserName =~ s/^\s*(\S*)\s*$/$1/;
$UserName =~ s/;|>|>>|<|\*|\?|\&|\|//g;
system("/usr/bin/java IndexPage $UserName $Password");
