#!/usr/bin/perl -w

use CGI;
print("Content-type: text/html\n\n");
$query = new CGI;

system("/usr/bin/java ClearSystem");
