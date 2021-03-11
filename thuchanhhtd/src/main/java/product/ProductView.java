/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ProductView {

    public ProductView() {
    }
    public void hien_thi_mot_san_pham(Product x){
        System.out.println("---------------------------------");
        System.out.println("++++ " + x.toString() + " ++++");
        System.out.println("----------------------------------");
    }
    public Product them_du_lieu_san_pham(){
        System.out.println("----------------------------------");
        System.out.println("Product Name: ");
        Scanner sc = new Scanner(System.in);
        String fullname = sc.nextLine();
        System.out.println("Product Category : ");
        String sdt = sc.nextLine();
        System.out.println("Product Price: ");
        String email = sc.nextLine();
        Product pd = new Product(fullname, sdt, email);
        System.out.println("Finished");
        System.out.println("----------------------------------");
        return pd;
    }
    public ArrayList<Product> nhap_du_lieu_nhieu_san_pham(){
        ArrayList<Product> result = new ArrayList<>();
        boolean flag = true;
        while(flag){
            System.out.println("Ban co muon nhap du lieu khong? (y/n)");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();
            if ("n".equals(answer) || "N".equals(answer)){
                flag = false;
            }else{
                Product pd = them_du_lieu_san_pham();
                result.add(pd);
            }
        }
        return result;
    }
    public void hien_thi_danh_sach_san_pham(ArrayList<Product> products){
        
        System.out.println("----------------------------------");
        for(Product pd: products){
            System.out.println("++++ " + pd.toString() + " ++++");
        }    
        System.out.println("-----------------------------------");
    }
    //view nhap thong tin can tim
    public String nhap_tenpd_can_tim(){
        System.out.println("----------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten san pam can tim kiem: ");
        String pname = sc.nextLine();
        System.out.println("-----------------------");
        return pname;
    }
     //view in ket qua tim kiem
    public void ket_qua_tim_kiem_pname(ArrayList<Product> products){
        System.out.println("------------------------");
        if (products.isEmpty()){
            System.out.println("Khong tim thay");
        }else{
            for(Product pd: products){
                System.out.println(pd.toString());
            }
        }
        System.out.println("------------------------");
    }
    // view sua 
     public String nhap_idpd_can_tim(){
        System.out.println("----------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id san pam can sua: ");
        String pname = sc.nextLine();
        System.out.println("-----------------------");
        return pname;
    }
}
