// +----------+-------------+------+-----+---------+----------------+
// | Field    | Type        | Null | Key | Default | Extra          |
// +----------+-------------+------+-----+---------+----------------+
// | id       | int(11)     | NO   | PRI | NULL    | auto_increment |
// | username | varchar(20) | NO   |     | NULL    |                |
// | password | varchar(20) | NO   |     | NULL    |                |
// +----------+-------------+------+-----+---------+----------------+

import java.sql.*;   
 
public class Database {  

   private Connection conn;
   private Statement stmt;
   public Database(){
      try{
         conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/accountdb?useSSL=false", "nathan", "password"); 

         stmt = conn.createStatement();  
      }catch(Exception e){
         System.out.println(e);
      }
   }   

   public boolean valid(String user, String pass) {
   		try{
   			String strSelect = "select * from account where username = '" + user + "\' and password = '" + pass + "'";
	   		ResultSet rset = stmt.executeQuery(strSelect);
	   		if (!rset.isBeforeFirst() ) {
	   		    return false;
	 		}
   			return true;	
   		}catch(Exception e){
   			System.out.println(e);
   			return false;
   		}	
   		
   }
}