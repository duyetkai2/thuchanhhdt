/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa.gui;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class UserModel {
    private int iduser;
    private String username;
    private String password;
    

    public UserModel() {
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserModel(int iduser, String username, String password) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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
        return "UserModel{" + "iduser=" + iduser + ", username=" + username + ", password=" + password + '}';
    }
    
    public boolean kiem_tra_account(Connection ketnoi){
        boolean flag = false; //mac dinh account nay ko co
        try {
            
            Statement stmt=ketnoi.createStatement();
            String query = "select * from user where username = ? and password = ?";
            PreparedStatement sql = ketnoi.prepareStatement(query);
            sql.setString(1, this.username);
            sql.setString(2, this.password);
            ResultSet rs=sql.executeQuery();
            if(rs.next()){
                flag = true;
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
