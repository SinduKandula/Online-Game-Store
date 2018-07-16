import  java.sql.*;
import  java.io.*;

class IndexPage 
{
 public static void  main(String args[]) throws SQLException 
 {
  System.out.println("<center><h2><u>Main Page</u></h2></center>");
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  Statement Stmt  = Conn.createStatement();
  ResultSet RSet  = Stmt.executeQuery("SELECT * FROM Customer WHERE UPPER(UserName) = '" + args[0].trim().toUpperCase() + "' AND Password = '" + args[1].trim() + "'");
  if(RSet.next() == false)
  {
   System.out.println("<font Color='Red'>Invalid UserName and/or Password.</font><br /><br />");
   System.out.println("<a href='http://people.aero.und.edu/~mmahmoud/513/1/index.html'>Try Again</a>");
  }
  else
  {
   System.out.println("<i><font Color='Green'>Welcome User, " + args[0] + "</font></i><br /><br />");
   System.out.println("<table>");
   if(args[0].equals( "Administrator"))
   {
    System.out.println("<form Method='Post' Action='SearchCustomer.cgi'>");
    System.out.println("<tr><td>Enter a Part of the Customer Name</td><td><input name='CustomerName' type='Text' Value='" + RSet.getString("CustomerName") + "'></td></tr>");
    System.out.println("<tr><td><input name='SearchCustomer' type='Submit' value='Search Customer'></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("<tr><td><a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/InsertCustomer.html'>Insert Customer</a></td></tr>");
    System.out.println("<tr><td><a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/UpdateCustomer.html'>Update Customer</a></td></tr>");
    System.out.println("<tr><td><a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/DeleteCustomer.html'>Delete Customer</a></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("</form>");

    System.out.println("<form Method='Post' Action='SearchCD.cgi'>");
    System.out.println("<tr><td>Enter a Part of the CD Title</td><td><input name='Title' type='Text'></td></tr>");
    System.out.println("<tr><td><input name='SearchCD' type='Submit' value='Search CD'></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("<tr><td><a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/InsertCD.html'>Insert CD</a></td></tr>");
    System.out.println("<tr><td><a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/UpdateCD.html'>Update CD</a></td></tr>");
    System.out.println("<tr><td><a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/DeleteCD.html'>Delete CD</a></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("</form>");

    System.out.println("<form Method='Post' Action='SearchPurchasing.cgi'>");
    System.out.println("<tr><td>Enter a Part of the Customer Name</td><td><input name='CustomerName' type='Text' Value='" + RSet.getString("CustomerName") + "'></td></tr>");
    System.out.println("<tr><td><input name='GetCustomerPurchasing' type='Submit' value='Get Customer Purchasing'></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("<tr><td><a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/InsertPurchasing.html'>Insert Purchasing</a></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("</form>");

    System.out.println("<form Method='Post' Action='ClearSystem.cgi'>");
    System.out.println("<tr><td><input name='ClearSystem' type='Submit' value='Clear System'></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("</form>");
   }
   else if(args[0].equals("Administrator") == false)
   {
    System.out.println("<form Method='Post' Action='SearchCustomer.cgi'>");
    System.out.println("<tr><td>Enter a Part of the Customer Name</td><td><input name='CustomerName' type='Text' Value='" + RSet.getString("CustomerName") + "'></td></tr>");
    System.out.println("<tr><td><input name='SearchCustomer' type='Submit' value='Search Customer'></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("</form>");

    System.out.println("<form Method='Post' Action='SearchCD.cgi'>");
    System.out.println("<tr><td>Enter a Part of the CD Title</td><td><input name='Title' type='Text'></td></tr>");
    System.out.println("<tr><td><input name='SearchCD' type='Submit' value='Search CD'></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("</form>");

    System.out.println("<form Method='Post' Action='SearchPurchasing.cgi'>");
    System.out.println("<tr><td>Enter a Part of the Customer Name</td><td><input name='CustomerName' type='Text' Value='" + RSet.getString("CustomerName") + "'></td></tr>");
    System.out.println("<tr><td><input name='GetCustomerPurchasing' type='Submit' value='Get Customer Purchasing'></td></tr>");
    System.out.println("<tr><td><a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/InsertPurchasing.html'>Insert Purchasing</a></td></tr>");
    System.out.println("<tr><td><br /></td></tr>");
    System.out.println("</form>");  
   }
   System.out.println("</table>");
   System.out.println("<a href='http://people.aero.und.edu/~mmahmoud/513/1/index.html'>Logout</a>");
   /*
   System.out.println("<a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/SearchCustomer.html'>Customer</a><br />");
   System.out.println("<a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/SearchCD.html'>CD</a><br />");
   System.out.println("<a href='http://people.aero.und.edu/~mmahmoud/cgi-bin/SearchPurchasing.html'>Purchasing</a>");
   */
  }
  RSet.close();
  Stmt.close();
  Conn.close();
 }
}
