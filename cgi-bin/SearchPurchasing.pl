#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$CustomerName  = $query->param("CustomerName");
# Remove leading and trailing spacing.
$CustomerName =~ s/^\s*(\S*)\s*$/$1/;
# For security, remove some Unix metacharacters.
$CustomerName =~ s/;|>|>>|<|\*|\?|\&|\|//g;
system("/usr/bin/java SearchPurchasing '$CustomerName'");
