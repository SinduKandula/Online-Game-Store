import  java.sql.*;
import  java.io.*;

class ClearSystem
{
 public static void  main(String args[]) throws SQLException 
 {  
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@134.129.213.35:1521:orcl", "mmahmoud", "passwd" );
  Statement Stmt = Conn.createStatement( );
  Stmt.execute("DELETE FROM Purchasing");
  Stmt.execute("DELETE FROM CustomerShoppingCart");
  Stmt.execute("DELETE FROM Customer");
  Stmt.execute("DELETE FROM CD");

  Stmt.close();
  Conn.close();
 }
} 
