/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.donglenh.chuong01;

/**
 *
 * @author Admin
 */
public class Bai04 {
    public static void  main(String[]args){
    Shape htron = new Circle(5, 1, 2);
//    System.out.println("Chu vi cua hinh tron la "+htron.calcPerimeter());
//    System.out.println("Dien tich cua hinh tron la "+htron.calArea());
    System.out.println(htron.toString());
    Shape hcn = new Retangle(3, 15, 8, 5);
//    System.out.println("Chu vi hcn "+hcn.calcPerimeter());
//    System.out.println("Dien tich hcn"+hcn.calArea());
    System.out.println(hcn);
    } 
     
}
