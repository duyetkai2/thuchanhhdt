/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ProductController {
    private ArrayList<Product> products;
    private ProductView view;
    
    public ProductController() {
        this.products = new ArrayList<>();
    }
    public ProductController(ProductView view) {
        this.view = view;
    }
    

    public ProductController(ArrayList<Product> products) {
        this.products = products;
    }
    public void nhap_du_lieu_san_pham(){
        Product product = this.view.them_du_lieu_san_pham();
        product.save_product_to_db();
    }
    public void nhap_danh_sach_san_pham(){
        this.products = this.view.nhap_du_lieu_nhieu_san_pham();
        for(Product pd: products){
            pd.save_product_to_db();
        }
    }
     public void hien_thi_danh_sach_san_pham(){
        //Lay tu csdl ra
        this.products = new Product().lay_danh_sach_san_pham();
//        this.view.hien_thi_danh_sach_san_pham(this.products);
    }
    private ArrayList<Product> tim_san_pham_theo_tensp(ArrayList<Product> products, String pname){
        ArrayList<Product> result = new ArrayList<>(); //empty =khong tim thay
     
        for(Product pd: products){
            if (pd.getPname().contains(pname)){
                result.add(pd);
            }
             
        }
        return result;
    }
    
    public void tim_kiem_san_pham_theo_tensp(){
        String pname = this.view.nhap_tenpd_can_tim();
        ArrayList<Product> kq = tim_san_pham_theo_tensp(products, pname);
        this.view.ket_qua_tim_kiem_pname(kq);
    }
//    private ArrayList<Product> tim_san_pham_theo_idproduct(ArrayList<Product> products, String idproduct){
//        ArrayList<Product> result = new ArrayList<>(); //empty =khong tim thay
//     
//        for(Product pd: products){
//            if (pd.getPname().contains(idproduct)){
//                result.add(pd);
//            }
//             
//        }
//        return result;
//    }
//    public void tim_kiem_san_pham_theo_idproduct(){
//        String idproduct = this.view.nhap_idpd_can_tim();
//        ArrayList<Product> kq = tim_san_pham_theo_idproduct(products, idproduct);
//        this.view.ket_qua_tim_kiem_pname(kq);
//    }
    
    
}
