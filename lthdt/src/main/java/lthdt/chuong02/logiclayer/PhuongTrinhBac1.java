/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.chuong02.logiclayer;

/**
 *
 * @author Admin
 */
public class PhuongTrinhBac1 implements PhuongTrinhInterface {
    private double a;
    private double b;
    private double nghiem_x;
    private String ketqua;

    public PhuongTrinhBac1() {
    }

    public PhuongTrinhBac1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getNghiem_x() {
        return nghiem_x;
    }

    public void setNghiem_x(double nghiem_x) {
        this.nghiem_x = nghiem_x;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }
    

    @Override
    public void giaiPhuongTrinh() {
      if(a!=0){
          nghiem_x =-b/a;
          ketqua ="Phuong Trinh Bac 1 co nghiem la"+nghiem_x;
          
          
      }else{
          if(b!=0){
              ketqua="Phuong Trinh Vo Nghiem";
          }else{
              ketqua="Phuong Trinh Bac 1 co vo so nghiem";
              
          }
      }
    }

    @Override
    public String toString() {
      if(ketqua==null||ketqua.isEmpty()){
          giaiPhuongTrinh();
      
      }
      return ketqua;
    }
    
    
    
}
