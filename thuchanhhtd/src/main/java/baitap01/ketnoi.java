package baitap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class ketnoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
      Connection conn = null;
      try{
          String userName = "root";
          String password = "123456";
          String url="jdbc:mysql://127.0.0.1:3306/qlht";
          conn = DriverManager.getConnection(url,userName, password);
          System.out.println("Da ket noi CSDL");
          conn.close();
          System.out.println("Dong ket noi");
      }
      catch(Exception e){
          System.err.println("Khong ket noi duoc");
      }
      }

} 