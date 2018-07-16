#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$NewCDTitle = $query->param("NewCDTitle");
$NewCDPrice = $query->param("NewCDPrice");
$OldCDTitle = $query->param("OldCDTitle");
system("/usr/bin/java UpdateCD '$NewCDTitle' '$NewCDPrice' '$OldCDTitle'");
