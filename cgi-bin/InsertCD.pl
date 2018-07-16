#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$CDASIN = $query->param("CDASIN");
$Title  = $query->param("Title");
$Price  = $query->param("Price");

system("/usr/bin/java InsertCD '$Title' '$Price'");
