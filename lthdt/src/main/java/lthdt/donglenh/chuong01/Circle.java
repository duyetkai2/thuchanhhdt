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
public class Circle extends Shape{
    private int radius;
    private int x,y;

    public Circle() {
    }

    public Circle(int radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
   
    @Override
    public double calcPerimeter(){ 
        double result = 2*Math.PI*this.radius;
        return result;
    }

    @Override
    public double calArea(){
        double result = Math.PI*this.radius*this.radius;
        return result;
    }

    @Override
    public String toString() {
      String output ="Chu vi hinh tron la : "+ calcPerimeter()+""
               + " Dien tich hinh tron la :"+ calArea() ;
       return output;
    }
    

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
