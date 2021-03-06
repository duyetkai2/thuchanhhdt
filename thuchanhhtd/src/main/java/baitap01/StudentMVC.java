/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap01;

/**
 *
 * @author MyPC
 */
public class StudentMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        kich_ban_3();
    }
    
    public static void kich_ban_3(){
        MenuController menu = new MenuController(new StudentController(new StudentView()), 
                                new MenuView());
        menu.lua_chon_menu();
    }
    
    public static void kich_ban_1(){
        StudentController sc = new StudentController(new StudentView());
        sc.nhap_du_lieu_sinh_vien();
        sc.hien_thi_sinh_vien();
    }
    
    public static void kich_ban_2(){
        StudentController sc = new StudentController(new StudentView());
        sc.nhap_danh_sach_sinh_vien();
        sc.hien_thi_danh_sach_sinh_vien();
        sc.tim_kiem_sv_theo_sdt();
    }
}
