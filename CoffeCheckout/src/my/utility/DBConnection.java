/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private String query = "SELECT * FROM PERSON";
    public DBConnection() {
      
    }
    
    public int addUser(String firstName, String lastName){
        int result = 0;
        try(Connection con = DriverManager.getConnection(url, user, password)) {
            query = "INSERT INTO PERSON (ID,FIRSTNAME,LASTNAME) VALUES (default,?,?)";
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setString(1, firstName);
            pStmt.setString(2, lastName);
            
            result = pStmt.executeUpdate();
            
        } 
        catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return result;
    }
    
}
