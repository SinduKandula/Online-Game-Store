#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$CustomerID          = $query->param("CustomerID");
$CDASIN              = $query->param("CDASIN");
system("/usr/bin/java InsertPurchasing '$CustomerID' '$CDASIN'");
