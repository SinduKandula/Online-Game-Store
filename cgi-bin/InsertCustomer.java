import  java.sql.*;
import  java.io.*;

class InsertCustomer 
{
 public static void  main(String args[]) throws SQLException 
 {
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  Statement Stmt  = Conn.createStatement();
  ResultSet RSet  = Stmt.executeQuery("SELECT * FROM Customer WHERE CustomerName like '%" + args[0].trim() + "%'");  
  if(RSet.next() == false)
  {
   PreparedStatement PStmt = Conn.prepareStatement("INSERT INTO Customer VALUES(Customer_Sequence.NextVal, ?, ?, ?, ?, ?)");
   PStmt.setString(1, args[0]);
   PStmt.setString(2, args[1]);
   PStmt.setString(3, args[2]);
   PStmt.setString(4, args[3]);
   PStmt.setString(5, args[4]);
   PStmt.execute();
   PStmt.close();
   System.out.println("<font Color='Blue'>The Customer Data was Inserted Successfully.</font><br /><br />");
  }
  else
  {
   System.out.println("<font Color = 'Red'>Customer Named \"" + args[0] + "\" Already Exists !! </Font><br /><br />");
  }
  RSet.close();
  Stmt.close();

  Stmt = Conn.createStatement();
  RSet = Stmt.executeQuery("SELECT * FROM Customer");  
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
 }
}
