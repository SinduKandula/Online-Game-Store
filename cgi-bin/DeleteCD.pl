#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$Title = $query->param("Title");
system("/usr/bin/java DeleteCD '$Title'");
