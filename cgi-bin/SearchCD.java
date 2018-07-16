import  java.sql.*;
import  java.io.*;

class SearchCD
{
 public static void  main(String args[]) throws SQLException 
 {
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  Statement Stmt = Conn.createStatement();
  ResultSet RSet = Stmt.executeQuery("SELECT * FROM CD WHERE UPPER(Title) like '%" + args[0].toUpperCase() + "%'");
  if(RSet.next())
  {
   System.out.println("<table Border='1'>");
   System.out.println("<tr BGColor='#FF0000'><th>CDASIN</th><th>Title</th><th>Price</th></tr>");
   System.out.println("<tr><td Align='Center'>" + RSet.getInt("CDASIN") + "</td><td Align='Center'>" +  RSet.getString("Title") + "</td><td Align='Center'>" + RSet.getString("Price") + "</td></tr>");
   while(RSet.next())
   {
    System.out.println("<tr><td Align='Center'>" + RSet.getInt("CDASIN") + "</td><td Align='Center'>" +  RSet.getString("Title") + "</td><td Align='Center'>" + RSet.getString("Price") + "</td></tr>");
   }
   System.out.println("</table>");
  }
  else
  {
   System.out.println("<table Border='1'>");
   System.out.println("<tr BGColor='#FF0000'><th>CDASIN</th><th>Title</th><th>Price</th></tr>");
   System.out.println("</table><br />");
   System.out.println("<b>No Data Found !!</b>");
  }
  RSet.close();	
  Stmt.close();	 
  Conn.close();
 }
}
