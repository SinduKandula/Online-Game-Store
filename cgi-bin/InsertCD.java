import  java.sql.*;
import  java.io.*;

class InsertCD 
{
 public static void  main(String args[]) throws SQLException 
 {
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  Statement Stmt  = Conn.createStatement();
  ResultSet RSet  = Stmt.executeQuery("SELECT * FROM CD WHERE Title like '%" + args[0].trim() + "%'");
  if(RSet.next() == false)
  {
   PreparedStatement PStmt = Conn.prepareStatement("INSERT INTO CD VALUES(CD_Sequence.NextVal, ?, ?)");
   PStmt.setString(1, args[0]);
   PStmt.setFloat(2, Float.parseFloat(args[1]));
   PStmt.execute();
   PStmt.close();
   System.out.println("<font Color='Blue'>The CD Data was Inserted Successfully.</font><br /><br />");
  }
  else
  {
   System.out.println("<font Color = 'Red'>CD Titled \"" + args[0] + "\" Already Exists !! </Font><br /><br />");
  }
  RSet.close();

  RSet = Stmt.executeQuery("SELECT * FROM CD");  
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
 }
}
