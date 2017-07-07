/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Elev
 */
public class DBConnection {

    private String url ="jdbc:derby://localhost:1527/KaffeDB";
    private String user = "auntau";
    private String password = "mario64";
    private String query = "SELECT * FROM USERS";
    public DBConnection() {
        try(Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("ID");
                String fName = rs.getString("FIRST_NAME"); 
                String lName = rs.getString("LAST_NAME"); 
                System.out.println(id + "  " + fName+ "  " + lName);
            }
            
        } 
        catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
}
