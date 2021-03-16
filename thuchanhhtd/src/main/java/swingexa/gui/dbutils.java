/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa.gui;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class dbutils {
    private String database;
    private String port;
    private String username;
    private String password;

    public dbutils() {
    }

    public dbutils(String database, String port, String username, String password) {
        this.database = database;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "dbutils{" + "database=" + database + ", port=" + port + ", username=" + username + ", password=" + password + '}';
    }
    
    public Connection lay_ket_noi_csdl(){
        Connection conn = null;
        try {
            //Code của bạn ở đây
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ketnoi = "jdbc:mysql://localhost:" + this.port + "/" + this.database;
            conn = DriverManager.getConnection(
                    ketnoi,
                    this.username, this.password);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
