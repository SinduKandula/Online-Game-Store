import  java.sql.*;
import  java.io.*;
import  java.util.Date;
import  java.text.DateFormat;
import  java.text.SimpleDateFormat;
import  java.util.Calendar;

class InsertPurchasing
{
 public static void  main(String args[]) throws SQLException 
 {
  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  Date date = new Date();

  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  PreparedStatement PStmt = Conn.prepareStatement("INSERT INTO Purchasing(CustomerID, CDASIN, PurchasingTime) VALUES(?, ?, ?)");
  PStmt.setInt(1, Integer.parseInt(args[0]));
  PStmt.setInt(2, Integer.parseInt(args[1]));
  PStmt.setString(3, dateFormat.format(date));
  PStmt.execute();
  PStmt.close();	 

  Statement Stmt = Conn.createStatement();
  ResultSet RSet = Stmt.executeQuery("SELECT * FROM Purchasing");  
  System.out.println("<table Border='1'>");
  System.out.println("<tr BGColor='#FF0000'><th>Customer ID</th><th>CDASIN</th><th>Purchasing Time</th></tr>");
  while(RSet.next())
  {
   System.out.println("<tr><td Align='Center'>" + RSet.getInt("CustomerID") + "</td><td Align='Center'>" +  RSet.getInt("CDASIN") + "</td><td Align='Center'>" +  RSet.getString("PurchasingTime") + "</td></tr>");
  }
  System.out.println("</table>");
  RSet.close();
  Stmt.close();	 
  Conn.close();  

  System.out.println("<br /><font Color='Red'>The Purchasing Data was Inserted Successfully.</font><br /><br />");
 }
}
