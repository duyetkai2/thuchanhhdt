/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author MyPC
 */
public class Student {
    private int idstudent;
    private String fullname;
    private String sdt;
    private String email;
    private FileInputStream imageIn;
    private BufferedImage imageOut;
    
    //Xây dựng các hàm khởi tạo

    public Student() {
    }

    public Student(String fullname, String sdt, String email) {
        this.fullname = fullname;
        this.sdt = sdt;
        this.email = email;
    }

    public Student(int idstudent, String fullname, String sdt, String email) {
        this.idstudent = idstudent;
        this.fullname = fullname;
        this.sdt = sdt;
        this.email = email;
    }

    public Student(String fullname, String sdt, String email, 
                        String imagePath) {
        this.fullname = fullname;
        this.sdt = sdt;
        this.email = email;
        
        try {
            //Đọc ảnh vào bộ nhớ
            this.imageIn = new FileInputStream(new File(imagePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
       
    //Xây dựng hàm thêm 1 student vào database
    public void save_student_to_db(){
        try {
            //Code của bạn ở đây
            dbutils db = new dbutils("qlht", "3306", "root", "123456");
            Connection ketnoicsdl = db.lay_ket_noi_csdl();            
            // the mysql insert statement
            String query = " insert into student (fullname, sdt, email)"
                    + " values (?, ?, ?)";
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setString(1, this.fullname);
            preparedStmt.setString(2, this.sdt);
            preparedStmt.setString(3, this.email);
            
            // execute the preparedstatement
            preparedStmt.execute();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Hàm chèn dữ liệu sinh viên có ảnh vào csdl
    public void save_student_with_image(){
        try {
            dbutils db = new dbutils("qlht", "3306", "root", "123456");
            Connection ketnoicsdl = db.lay_ket_noi_csdl();
            // the mysql insert statement
            String query = " insert into student (fullname, sdt, email, image)"
                    + " values (?, ?, ?, ?)";
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setString(1, this.fullname);
            preparedStmt.setString(2, this.sdt);
            preparedStmt.setString(3, this.email);
            preparedStmt.setBlob(4, imageIn);
            
            // execute the preparedstatement
            preparedStmt.execute();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Hàm lấy ra 1 sinh vien theo id
    public Student get_student_by_id(int id) throws SQLException{
        dbutils db = new dbutils("qlht", "3306", "root", "123456");
        Connection conn = db.lay_ket_noi_csdl();
        String query = "select fullname, sdt, email from student where idstudent = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Student sv = new Student();
        if (rs.next()){
            sv.setFullname(rs.getString("fullname"));
            sv.setSdt(rs.getString("sdt"));
            sv.setEmail(rs.getString("email"));
        }
        conn.close();
        return sv;
    }
    
    //Hàm lấy sinh viên với ảnh theo id
    public Student get_student_image_by_id(int id){
        Student sv = new Student();
        try {
            dbutils db = new dbutils("qlht", "3306", "root", "123456");
            Connection conn = db.lay_ket_noi_csdl();
            String query = "select fullname, sdt, email, image from student where idstudent = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                sv.setIdstudent(idstudent);
                sv.setFullname(rs.getString("fullname"));
                sv.setSdt(rs.getString("sdt"));
                sv.setEmail(rs.getString("email"));
                //doc anh vao bo nho
                Blob blob = rs.getBlob("image");
                InputStream in = blob.getBinaryStream();
                sv.imageOut = ImageIO.read(in);
            }
            conn.close();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }
    
    //Hàm lấy ra danh sách các sinh viên trong bang student
    public ArrayList<Student> lay_danh_sach_sinh_vien(){
        ArrayList<Student> result = new ArrayList<>();
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("qlht", "3306", "root", "123456");
            Connection conn = db.lay_ket_noi_csdl(); 
            //String query = "select * from student";
            Statement stmt=conn.createStatement();
            //PreparedStatement stmt = ketnoicsdl.prepareStatement(query);
            ResultSet rs=stmt.executeQuery("select * from student");
            while(rs.next()){
                Student sv = new Student(rs.getInt("idstudent"), 
                                        rs.getString("fullname"), 
                                        rs.getString("sdt"), 
                                        rs.getString("email"));
                result.add(sv);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //Ham tim kiem sinh vien theo fullname
    public ArrayList<Student> tim_kiem_sinh_vien_theo_fulllname(String s){
        ArrayList<Student> result = new ArrayList<>();
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("qlht", "3306", "root", "123456");
            Connection conn = db.lay_ket_noi_csdl(); 
            String query = "select idstudent, fullname, sdt, email from student where fullname like ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, '%' + s + '%');
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Student sv = new Student(rs.getInt("idstudent"), 
                                        rs.getString("fullname"), 
                                        rs.getString("sdt"), 
                                        rs.getString("email"));
                result.add(sv);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ArrayList<Student> tim_kiem_sinh_vien_theo_fullall(String b,String t,String c  ){
        ArrayList<Student> result = new ArrayList<>();
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("qlht", "3306", "root", "123456");
            Connection conn = db.lay_ket_noi_csdl(); 
            String query = "select * from student where  fullname like ?  and sdt like ? and email like ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
         
            
            stmt.setString(1, '%' + b + '%');
           stmt.setString(2, '%' + t + '%');
           stmt.setString(3, '%' + c + '%');
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Student sv = new Student(rs.getInt("idstudent"), 
                                        rs.getString("fullname"), 
                                        rs.getString("sdt"), 
                                        rs.getString("email"));
                result.add(sv);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //Hàm cập nhật sinh viên hiện tại vào csdl
    public void update_current_student(){
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("qlht", "3306", "root", "123456");
            Connection ketnoicsdl = db.lay_ket_noi_csdl(); 
            // create the java mysql update preparedstatement
            String query = "update student set fullname = ?,"
                    + " sdt = ?,"
                    + "email = ? where idstudent = ?";
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setString(1, this.fullname);
            preparedStmt.setString(2, this.sdt);
            preparedStmt.setString(3, this.email);
            preparedStmt.setInt(4, this.idstudent);
            
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Hàm xóa sinh viên hiện tại ra khỏi csdl
    public void delete_current_student(){
        //code của bạn ở đây
        try {
            //code của bạn ở đây
            //Buoc 1: Tao ket noi toi csdl
            dbutils db = new dbutils("qlht", "3306", "root", "123456");
            Connection ketnoicsdl = db.lay_ket_noi_csdl(); 
            // create the java mysql update preparedstatement
            String query = "delete from student where idstudent = ?";
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setInt(1, this.idstudent);
            
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Các getter và setter 

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FileInputStream getImageIn() {
        return imageIn;
    }

    public void setImageIn(FileInputStream imageIn) {
        this.imageIn = imageIn;
    }

    public BufferedImage getImageOut() {
        return imageOut;
    }

    public void setImageOut(BufferedImage imageOut) {
        this.imageOut = imageOut;
    }

    
    @Override
    public String toString() {
        return "Student{" + "idstudent=" + idstudent + ", fullname=" + fullname + ", sdt=" + sdt + ", email=" + email + '}';
    }
    
    
}
