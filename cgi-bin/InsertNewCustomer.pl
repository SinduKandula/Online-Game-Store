#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$UserName            = $query->param("UserName");
$Password            = $query->param("Password");
$CustomerName        = $query->param("CustomerName");
$CustomerAddress     = $query->param("CustomerAddress");
$CustomerPhoneNumber = $query->param("CustomerPhoneNumber");
system("/usr/bin/java InsertNewCustomer '$UserName' '$Password' '$CustomerName' '$CustomerAddress' '$CustomerPhoneNumber'");
