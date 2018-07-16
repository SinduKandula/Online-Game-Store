import  java.sql.*;
import  java.io.*;

class SearchCustomer 
{
 public static void  main(String args[]) throws SQLException 
 {
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  Statement Stmt  = Conn.createStatement();
  ResultSet RSet  = Stmt.executeQuery("SELECT * FROM Customer WHERE UPPER(CustomerName) like '%" + args[0].trim().toUpperCase() + "%'");  
  // ResultSet RSet  = Stmt.executeQuery("SELECT * FROM Customer WHERE CustomerName = '" + args[0].trim() + "'");  
  if(RSet.next())
  {
   System.out.println("<table Border='1'>");
   System.out.println("<tr BGColor='#FF0000'><th>Customer ID</th><th>Customer Name</th><th>Customer Address</th><th>Customer Phone Number</th></tr>");
   System.out.println("<tr><td Align='Center'>" + RSet.getInt("CustomerID") + "</td><td Align='Center'>" +  RSet.getString("CustomerName") + "</td><td Align='Center'>" + RSet.getString("CustomerAddress") + "</td><td Align='Center'>" + RSet.getString("CustomerPhoneNumber") + "</td></tr>");
   while(RSet.next())
   {
    System.out.println("<tr><td Align='Center'>" + RSet.getInt("CustomerID") + "</td><td Align='Center'>" +  RSet.getString("CustomerName") + "</td><td Align='Center'>" + RSet.getString("CustomerAddress") + "</td><td Align='Center'>" + RSet.getString("CustomerPhoneNumber") + "</td></tr>");
   }
   System.out.println("</table>");
  }
  else
  {
   System.out.println("<table Border='1'>");
   System.out.println("<tr BGColor='#FF0000'><th>Customer ID</th><th>Customer Name</th><th>Customer Address</th><th>Customer Phone Number</th></tr>");   
   System.out.println("</table><br />");
   System.out.println("<b>No Data Found !!</b>");
  } 
  RSet.close();
  Stmt.close();	 
  Conn.close();
 }
}
