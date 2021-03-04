/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.chuong02.shapelogic;

/**
 *
 * @author Admin
 */
public class Line {
    private int begin_x;
    private int begin_y;
    private int end_x;
    private int end_y;

    public Line() {
    }

    public Line(int begin_x, int begin_y, int end_x, int end_y) {
        this.begin_x = begin_x;
        this.begin_y = begin_y;
        this.end_x = end_x;
        this.end_y = end_y;
    }

    public int getBegin_x() {
        return begin_x;
    }

    public void setBegin_x(int begin_x) {
        this.begin_x = begin_x;
    }

    public int getBegin_y() {
        return begin_y;
    }

    public void setBegin_y(int begin_y) {
        this.begin_y = begin_y;
    }

    public int getEnd_x() {
        return end_x;
    }

    public void setEnd_x(int end_x) {
        this.end_x = end_x;
    }

    public int getEnd_y() {
        return end_y;
    }

    public void setEnd_y(int end_y) {
        this.end_y = end_y;
    }
    
    
}
