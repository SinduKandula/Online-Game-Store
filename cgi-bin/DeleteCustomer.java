import  java.sql.*;
import  java.io.*;

class DeleteCustomer 
{
 public static void  main(String args[]) throws SQLException 
 {  
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  PreparedStatement PStmt = Conn.prepareStatement("DELETE FROM Customer WHERE CustomerName = ?");
  PStmt.setString(1, args[0]);
  PStmt.execute();
  PStmt.close();

  Statement Stmt = Conn.createStatement();
  ResultSet RSet = Stmt.executeQuery("SELECT * FROM Customer");  
  System.out.println("<table Border='1'>");
  System.out.println("<tr BGColor='#FF0000'><th>Customer ID</th><th>Customer Name</th><th>Customer Address</th><th>Customer Phone Number</th></tr>");
  while(RSet.next())
  {
   System.out.println("<tr><td Align='Center'>" + RSet.getInt("CustomerID") + "</td><td Align='Center'>" +  RSet.getString("CustomerName") + "</td><td Align='Center'>" + RSet.getString("CustomerAddress") + "</td><td Align='Center'>" + RSet.getString("CustomerPhoneNumber") + "</td></tr>");
  }
  System.out.println("</table>");
  RSet.close();
  Stmt.close();	 
  Conn.close();

  System.out.println("<font Color='Red'>The Customer Data was Deleted Successfully.</font><br /><br />");
 }
}
