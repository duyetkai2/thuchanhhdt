/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

/**
 *
 * @author Admin
 */
public class ProductMVC {
    public static void main(String[] args) {
        // TODO code application logic here
        kich_ban_3();
    }
    
    public static void kich_ban_3(){
        MenuController menu = new MenuController(new ProductController(new ProductView()), 
                                new MenuView());
        menu.lua_chon_menu();
    }
    
    public static void kich_ban_1(){
        ProductController sc = new ProductController(new ProductView());
        sc.nhap_du_lieu_san_pham();
       
    }
    
    public static void kich_ban_2(){
       ProductController sc = new ProductController(new ProductView());
        sc.nhap_danh_sach_san_pham();
        sc.hien_thi_danh_sach_san_pham();
        sc.tim_kiem_san_pham_theo_tensp();
    }
}
