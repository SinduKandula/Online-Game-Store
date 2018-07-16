#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

$OldCustomerName        = $query->param("OldCustomerName");
$NewCustomerName        = $query->param("NewCustomerName");
$NewCustomerAddress     = $query->param("NewCustomerAddress");
$NewCustomerPhoneNumber = $query->param("NewCustomerPhoneNumber");
system("/usr/bin/java UpdateCustomer '$NewCustomerName' '$NewCustomerAddress' '$NewCustomerPhoneNumber' '$OldCustomerName'");
