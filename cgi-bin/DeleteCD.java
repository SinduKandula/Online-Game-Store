import  java.sql.*;
import  java.io.*;

class DeleteCD
{
 public static void  main(String args[]) throws SQLException 
 {  
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  PreparedStatement PStmt = Conn.prepareStatement("DELETE FROM CD WHERE Title = ?");
  PStmt.setString(1, args[0]);
  PStmt.execute();
  PStmt.close();	 
 
  Statement Stmt = Conn.createStatement();
  ResultSet RSet = Stmt.executeQuery("SELECT * FROM CD");  
  System.out.println("<table Border='1'>");
  System.out.println("<tr BGColor='#FF0000'><th>CDASIN</th><th>Title</th><th>Price</th></tr>");
  while(RSet.next())
  {
   System.out.println("<tr><td Align='Center'>" + RSet.getInt("CDASIN") + "</td><td Align='Center'>" +  RSet.getString("Title") + "</td><td Align='Center'>" + RSet.getString("Price") + "</td></tr>");
  }
  System.out.println("</table>");
  RSet.close();
  Stmt.close(); 
  Conn.close();

  System.out.println("<br /><font Color='Red'>The CD Data was Deleted Successfully.</font><br /><br />");
 }
}
