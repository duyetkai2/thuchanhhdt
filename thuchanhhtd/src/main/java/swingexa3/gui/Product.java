/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa3.gui;

import swingexa.gui.*;
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
public class Product {
    private int idproduct;
    private String pname;
    private String pcategory;
    private int pprice;
    private FileInputStream imageIn;
    private BufferedImage imageOut;
    
    //Xây dựng các hàm khởi tạo

    public Product() {
    }

    public Product(String pname, String pcategory, int pprice) {
        this.pname = pname;
        this.pcategory = pcategory;
        this.pprice = pprice;
    }

    public Product(int idproduct, String pname, String pcategory, int pprice) {
        this.idproduct = idproduct;
        this.pname = pname;
        this.pcategory = pcategory;
        this.pprice = pprice;
    }

    public Product(String pname, String pcategory, int pprice, String imagePath) {
        this.pname = pname;
        this.pcategory = pcategory;
        this.pprice = pprice;
         try {
            //Đọc ảnh vào bộ nhớ
            this.imageIn = new FileInputStream(new File(imagePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

//    Product(String text, String text0, String text1, String text2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
    
    
    
       
    //Xây dựng hàm thêm 1 product vào database
    public void save_product_to_db(){
        try {
            //Code của bạn ở đây
            dbutils db = new dbutils("product", "3306", "root", "123456");
            Connection ketnoicsdl = db.lay_ket_noi_csdl();            
            // the mysql insert statement
            String query = " insert into product (pname, pcategory, pprice)"
                    + " values (?, ?, ?)";
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setString(1, this.pname);
            preparedStmt.setString(2, this.pcategory);
            preparedStmt.setInt(3, this.pprice);
            
            // execute the preparedstatement
            preparedStmt.execute();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Hàm chèn dữ liệu sản phẩm có ảnh vào csdl
    public void save_product_with_image(){
        try {
            dbutils db = new dbutils("product", "3306", "root", "123456");
            Connection ketnoicsdl = db.lay_ket_noi_csdl();
            // the mysql insert statement
            String query = " insert into product (pname, pcategory, pprice, image)"
                    + " values (?, ?, ?, ?)";
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setString(1, this.pname);
            preparedStmt.setString(2, this.pcategory);
            preparedStmt.setInt(3, this.pprice);
            preparedStmt.setBlob(4, imageIn);
            
            // execute the preparedstatement
            preparedStmt.execute();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Hàm lấy ra 1 sản phẩm theo id
    public Product get_product_by_id(int id) throws SQLException{
        dbutils db = new dbutils("product", "3306", "root", "123456");
        Connection conn = db.lay_ket_noi_csdl();
        String query = "select pname, pcategory, pprice from product where idproduct = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Product sp = new Product();
        if (rs.next()){
            sp.setPname(rs.getString("pname"));
            sp.setPcategory(rs.getString("pcategory"));
            sp.setPprice(rs.getInt("pprice"));
        }
        conn.close();
        return sp;
    }
    
    //Hàm lấy sản phẩm với ảnh theo id
    public Product get_product_image_by_id(int id){
        Product sp = new Product();
        try {
            dbutils db = new dbutils("product", "3306", "root", "123456");
            Connection conn = db.lay_ket_noi_csdl();
            String query = "select pname, pcategory, pprice, image from product where idproduct = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                sp.setIdproduct(idproduct);
                sp.setPname(rs.getString("pname"));
                sp.setPcategory(rs.getString("pcategory"));
                sp.setPprice(rs.getInt("pprice"));
                //doc anh vao bo nho
                Blob blob = rs.getBlob("image");
                InputStream in = blob.getBinaryStream();
                sp.imageOut = ImageIO.read(in);
            }
            conn.close();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
    }
    
    //Hàm lấy ra danh sách các sản phẩm trong bang product
    public ArrayList<Product> lay_danh_sach_san_pham(){
        ArrayList<Product> result = new ArrayList<>();
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("product", "3306", "root", "123456");
            Connection conn = db.lay_ket_noi_csdl(); 
           
            Statement stmt=conn.createStatement();
          
            ResultSet rs=stmt.executeQuery("select * from product");
            while(rs.next()){
                Product sp = new Product(rs.getInt("idproduct"), 
                                        rs.getString("pname"), 
                                        rs.getString("pcategory"), 
                                        rs.getInt("pprice"));
                result.add(sp);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //Ham tim kiem san pham theo pname
    public ArrayList<Product> tim_kiem_san_pham_theo_pname(String s){
        ArrayList<Product> result = new ArrayList<>();
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("product", "3306", "root", "123456");
            Connection conn = db.lay_ket_noi_csdl(); 
            String query = "select idproduct, pname, pcategory, pprice from product where pname like ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, '%' + s + '%');
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Product sp = new Product(rs.getInt("idproduct"), 
                                        rs.getString("pname"), 
                                        rs.getString("pcategory"), 
                                        rs.getInt("pprice"));
                result.add(sp);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ArrayList<Product> tim_kiem_san_pham_theo_fullall(String b,String t,int c  ){
        ArrayList<Product> result = new ArrayList<>();
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("product", "3306", "root", "123456");
            Connection conn = db.lay_ket_noi_csdl(); 
            String query = "select * from product where  pname like ?  and pcategory like ? and pprice like ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
         
            
            stmt.setString(1, '%' + b + '%');
           stmt.setString(2, '%' + t + '%');
           stmt.setInt(3, '%' + c + '%');
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Product sp = new Product(rs.getInt("idproduct"), 
                                        rs.getString("pname"), 
                                        rs.getString("pcategory"), 
                                        rs.getInt("pprice"));
                result.add(sp);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //Hàm cập nhật sản phẩm hiện tại vào csdl
    public void update_current_product(){
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("product", "3306", "root", "123456");
            Connection ketnoicsdl = db.lay_ket_noi_csdl(); 
            // create the java mysql update preparedstatement
            String query = "update product set pname = ?,"
                    + " pcategory = ?,"
                    + "pprice = ? where idproduct = ?";
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setString(1, this.pname);
            preparedStmt.setString(2, this.pcategory);
            preparedStmt.setInt(3, this.pprice);
            preparedStmt.setInt(4, this.idproduct);
            
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Hàm xóa sản  phẩm hiện tại ra khỏi csdl
    public void delete_current_product(){
        //code của bạn ở đây
        try {
            //code của bạn ở đây
            //Buoc 1: Tao ket noi toi csdl
            dbutils db = new dbutils("product", "3306", "root", "123456");
            Connection ketnoicsdl = db.lay_ket_noi_csdl(); 
            // create the java mysql update preparedstatement
            String query = "delete from product where idproduct = ?";
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setInt(1, this.idproduct);
            
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Các getter và setter 

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcategory() {
        return pcategory;
    }

    public void setPcategory(String pcategory) {
        this.pcategory = pcategory;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
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
        return "Product{" + "idproduct=" + idproduct + ", pname=" + pname + ", pcategory=" + pcategory + ", pprice=" + pprice + '}';
    }
    
    
}
