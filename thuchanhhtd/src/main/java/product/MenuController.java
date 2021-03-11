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
public class MenuController {
    private ProductController pd_contrl;
    private MenuView mnview;

    public MenuController() {
    }
     public MenuController(ProductController pd_contrl) {
        this.pd_contrl = pd_contrl;
    }

    public MenuController(ProductController pd_contrl, MenuView mnview) {
        this.pd_contrl = pd_contrl;
        this.mnview = mnview;
    }
    public void lua_chon_menu(){
        boolean flag = true;
        while (flag){
            int kq = mnview.hien_thi_menu();
            switch(kq){
                case 1: 
                    pd_contrl.nhap_danh_sach_san_pham();
                    break;
                case 2:
                  pd_contrl.hien_thi_danh_sach_san_pham();
                  pd_contrl.tim_kiem_san_pham_theo_tensp();
                    break;
                case 3: 
                    flag = false;
                    break;
            }
        }
        
    }
    
}
