#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$CustomerName  = $query->param("CustomerName");
system("/usr/bin/java DeleteCustomer '$CustomerName'"); 