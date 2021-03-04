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
public class Retangle extends Shape{
    private int upper_x;
    private int upper_y;
    private int lower_x;
    private int lower_y;
    public Retangle() {
    }

    public Retangle(int upper_x, int upper_y, int lower_x, int lower_y) {
        this.upper_x = upper_x;
        this.upper_y = upper_y;
        this.lower_x = lower_x;
        this.lower_y = lower_y;
    }
    @Override
    public double calcPerimeter(){
        return (2*Math.abs(upper_x - lower_x)+(Math.abs(upper_y - lower_y)));   
    
    }
    @Override
    public double   calArea(){
        return Math.abs((upper_x-lower_x)*(upper_y - lower_y));
    }

    @Override
    public String toString() {
       String output ="Chu vi hinh chu nhat la : "+ calcPerimeter()+""
               + " Dien tich hinh chu nhat la :"+ calArea() ;
       return output;
    }
    

    public int getUpper_x() {
        return upper_x;
    }

    public void setUpper_x(int upper_x) {
        this.upper_x = upper_x;
    }

    public int getUpper_y() {
        return upper_y;
    }

    public void setUpper_y(int upper_y) {
        this.upper_y = upper_y;
    }

    public int getLower_x() {
        return lower_x;
    }

    public void setLower_x(int lower_x) {
        this.lower_x = lower_x;
    }

    public int getLower_y() {
        return lower_y;
    }

    public void setLower_y(int lower_y) {
        this.lower_y = lower_y;
    }

   
}
