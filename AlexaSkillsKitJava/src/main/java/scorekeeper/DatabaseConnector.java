ange this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorekeeper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sarahwatanabe
 */
public class DatabaseConnector {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
           static final String DB_URL = "jdbc:mysql://127.0.0.1:3307/phpmyadmin";
            //  Database credentials
   static final String USER = "root";
   static final String PASS = "code4good";
   Connection conn = null;
   Statement stmt = null;
   
   public void connect() {
       
   try{
      //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(true);
   } catch(Exception e) {
   }
   }
   
   public void showRows() {
       try{
       //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from team14student";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("studentid");
                String fn = rs.getString("firstname");
                String ln = rs.getString("lastname");
                String sc = rs.getString("school");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + fn);
                System.out.print(", First: " + ln);
                System.out.println(", Last: " + sc);
            }
            //STEP 6: Clean-up environment
            rs.close();
            //stmt.close();
            // conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } 
       
   }
   
   public void insertRow(int studentid, String fname, String lname, String school) {
       
       try{
       //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "insert into  team14student(studentid, firstname, lastname, school) values (" + studentid + ", '" + fname + "', '" + lname + "', '" + school + "')";
            stmt.execute(sql);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } 
       
   }
   
    public static void main(String... args) {
        
        DatabaseConnector dc = new DatabaseConnector();
        dc.connect();
        dc.showRows();
        dc.insertRow(1112, "First", "Last", "random");
        dc.showRows();
   

            
   System.out.println("Goodbye!");
}//end main
}
