import  java.sql.*;
import  java.io.*;

class SearchPurchasing
{
 public static void  main(String args[]) throws SQLException 
 {
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  Statement Stmt  = Conn.createStatement();
  ResultSet RSet  = Stmt.executeQuery("SELECT Customer.CustomerID, Customer.CustomerName, CD.CDASIN, CD.Title, CD.Price, Purchasing.PurchasingTime FROM Customer, CD, Purchasing WHERE Customer.CustomerID = Purchasing.CustomerID AND Purchasing.CDASIN = CD.CDASIN AND UPPER(Customer.CustomerName) like '%" + args[0].trim().toUpperCase() + "%'");
  if(RSet.next())
  {
   System.out.println("<table Border='1'>");
   System.out.println("<tr BGColor='#FF0000'><th>Customer ID</th><th>Customer Name</th><th>CD CDASIN</th><th>CD Title</th><th>CD Price</th><th>Purchasing Time</th></tr>");
   System.out.println("<tr><td Align='Center'>" + RSet.getInt("CustomerID") + "</td><td Align='Center'>" +  RSet.getString("CustomerName") + "</td><td Align='Center'>" + RSet.getString("CDASIN") + "</td><td Align='Center'>" + RSet.getString("Title") + "</td><td Align='Center'>" + RSet.getString("Price") + "</td><td Align='Center'>" + RSet.getString("PurchasingTime") + "</td></tr>");
   while(RSet.next())
   {
    System.out.println("<tr><td Align='Center'>" + RSet.getInt("CustomerID") + "</td><td Align='Center'>" +  RSet.getString("CustomerName") + "</td><td Align='Center'>" + RSet.getString("CDASIN") + "</td><td Align='Center'>" + RSet.getString("Title") + "</td><td Align='Center'>" + RSet.getString("Price") + "</td><td Align='Center'>" + RSet.getString("PurchasingTime") + "</td></tr>");
   }
   System.out.println("</table>");
  }
  else
  {
   System.out.println("<table Border='1'>");
   System.out.println("<tr BGColor='#FF0000'><th>Customer ID</th><th>Customer Name</th><th>CD CDASIN</th><th>CD Title</th><th>CD Price</th><th>Purchasing Time</th></tr>");
   System.out.println("</table><br />");
   System.out.println("<b>No Data Found !!</b>");
  } 
  RSet.close();
  Stmt.close();	 
  Conn.close();
 }
}
