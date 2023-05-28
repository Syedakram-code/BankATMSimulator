
package bankmanagementsystem;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
  public Conn(){
      try{
//          Class.forName(com.mysql.cj.jdbc.Driver);
          c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Syedakram@9032");
          s = c.createStatement();
      }catch(SQLException e){
          System.out.println(e);
      }
  }
}
