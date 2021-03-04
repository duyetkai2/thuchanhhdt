/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.donglenh.chuong01;

import java.util.*;



/**
 *
 * @author Admin
 */
public class xuatnhap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a =0 ;
        double b =2.3;
        Scanner sc = new Scanner(System.in);   
        System.out.println("Nhap ho ten");
        String hoten = sc.nextLine();
        System.out.println("ho ten vua nhap la: "+hoten);
                
        System.out.println("Hay nhap so nguyen");
        String input = sc.nextLine();
        a = Integer.parseInt(input); 
        System.out.println("so nguyen ma ban da nhap la: "+a);
        
        System.out.println("Hay nhap so thuc");
        input = sc.nextLine();
        b = Double.parseDouble(input); 
        System.out.println("so thuc ma ban da nhap la: "+b);
    }
    
}
