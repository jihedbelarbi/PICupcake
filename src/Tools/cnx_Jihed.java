/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jihed
 */
public class cnx_Jihed {
    
        String url="jdbc:mysql://localhost/pidev";
        String login="root";
        String password="";
        private Connection con;
        private static cnx_Jihed data;

    private cnx_Jihed() {

        try {
            con = DriverManager.getConnection(url, login, password);
            System.out.println("DataBase Connected");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}
  
    public Connection getConnection() {
        return con;
    }

    public static cnx_Jihed getInstance() {
        if (data == null) {
            data = new cnx_Jihed();
        }
        return data;
    }

}
